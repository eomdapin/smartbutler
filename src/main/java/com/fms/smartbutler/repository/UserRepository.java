package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
