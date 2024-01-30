package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByName(String name);
}
