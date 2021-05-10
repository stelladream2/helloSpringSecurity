package kr.ac.hansung.foursecuritytest;

import kr.ac.hansung.foursecuritytest.entity.Role;
import kr.ac.hansung.foursecuritytest.entity.User;
import kr.ac.hansung.foursecuritytest.repo.RoleRepository;
import kr.ac.hansung.foursecuritytest.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FoursecuritytestApplicationTests {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void contextLoads() {

       /*

       // Cleanup the tables
        postRepository.deleteAllInBatch();
        tagRepository.deleteAllInBatch();

       // Create Roles: RoleAdmin, RoleUser
        Role roleAdmin = new Role();
        roleAdmin.setRolename("ROLE_ADMIN");

        Role roleUser = new Role();
        roleUser.setRolename("ROLE_USER");

        // Create Users: 3 people
        User user1 = new User();
        user1.setEmail("alice@hansung.ac.kr");
        user1.setPassword( encoder.encode("alicepw"));

        User user2 = new User();
        user2.setEmail("bob@hansung.ac.kr");
        user2.setPassword( encoder.encode("bobpw"));

        User user3 = new User();
        user3.setEmail("trudy@hansung.ac.kr");
        user3.setPassword( encoder.encode("trudypw"));

        // save roles
        List<User> adminList = new ArrayList<User>();
        adminList.add(user1);
        roleAdmin.setUsers(adminList);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        roleUser.setUsers(userList);

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        //save users
        List<Role> roleList1 = new ArrayList<Role>();
        roleList1.add(roleAdmin);
        roleList1.add(roleUser);
        user1.setRoles(roleList1);

        List<Role> roleList2 = new ArrayList<Role>();
        roleList2.add(roleUser);
        user2.setRoles(roleList2);

        List<Role> roleList3 = new ArrayList<Role>();
        roleList3.add(roleUser);
        user3.setRoles(roleList3);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3); */
    }

}
