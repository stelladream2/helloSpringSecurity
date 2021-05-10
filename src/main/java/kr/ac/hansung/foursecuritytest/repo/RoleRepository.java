package kr.ac.hansung.foursecuritytest.repo;

import kr.ac.hansung.foursecuritytest.entity.Role;
import kr.ac.hansung.foursecuritytest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRolename(String rolename);

}