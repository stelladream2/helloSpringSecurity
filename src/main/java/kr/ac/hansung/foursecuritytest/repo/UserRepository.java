package kr.ac.hansung.foursecuritytest.repo;

import kr.ac.hansung.foursecuritytest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}