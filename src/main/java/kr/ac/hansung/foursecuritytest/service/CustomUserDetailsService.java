package kr.ac.hansung.foursecuritytest.service;

import kr.ac.hansung.foursecuritytest.entity.User;
import kr.ac.hansung.foursecuritytest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;

// 인증 관리자는 UserDetailsService 를 통해 UserDetails 객체를 획득하고
// 이 UserDetails 객체에서 인증 및 인가에 필요한 정보를 추출하여 사용한다.
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email: " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user)
    {
        String[] userRoles = user.getRoles()
                .stream()
                .map((role) -> role.getRolename())
                .toArray(String[]::new);

        //System.out.println(Arrays.toString(userRoles)); [ROLE_ADMIN, ROLE_USER]

        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}