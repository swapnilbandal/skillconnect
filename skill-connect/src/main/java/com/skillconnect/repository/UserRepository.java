package com.skillconnect.repository;

import com.skillconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query methods if needed
	//User findByUsername(String username);
	User findByEmail(String email);


}
