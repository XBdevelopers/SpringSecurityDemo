package edu.xbd.custom.spring.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.xbd.custom.spring.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from USER u where u.username=?1", nativeQuery = true)
	Optional<User> getUserByName(String userName);
}
