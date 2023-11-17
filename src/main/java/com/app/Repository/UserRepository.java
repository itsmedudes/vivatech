package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	


	boolean existsByMobile(String mobile);
	
	long count();


	User findByMobile(String mobile);
}
