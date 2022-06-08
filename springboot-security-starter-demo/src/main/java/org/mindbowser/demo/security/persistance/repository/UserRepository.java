package org.mindbowser.demo.security.persistance.repository;

import java.util.Optional;
import org.mindbowser.demo.security.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
		
	Optional<User> findByEmail(String email); 
	
	Boolean existsByEmail(String email);
	
}
