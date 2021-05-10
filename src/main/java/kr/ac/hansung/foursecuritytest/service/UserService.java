package kr.ac.hansung.foursecuritytest.service;

import kr.ac.hansung.foursecuritytest.entity.Role;
import kr.ac.hansung.foursecuritytest.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user, List<Role> userRoles);

    boolean checkEmailExists(String email);

    Role findByRolename(String rolename);


}
