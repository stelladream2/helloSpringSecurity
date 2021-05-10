package kr.ac.hansung.foursecuritytest.service;

import kr.ac.hansung.foursecuritytest.entity.Role;
import kr.ac.hansung.foursecuritytest.entity.User;
import kr.ac.hansung.foursecuritytest.repo.RoleRepository;
import kr.ac.hansung.foursecuritytest.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(User user, List<Role> userRoles) {

        for (Role ur : userRoles) {
                roleRepository.save(ur);
        }

        // generate new Bcrypt hash
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        user.setRoles(userRoles);

        User newUser = userRepository.save(user);

        return newUser;
    }

    public boolean checkEmailExists(String email) {

        if (userRepository.findByEmail(email).isPresent()) {
            return true;
        }

        return false;
    }

    public Role findByRolename(String rolename) {
        Optional<Role> role = roleRepository.findByRolename(rolename);
        return role.orElseGet(() -> new Role("ROLE_USER"));
    }


}

