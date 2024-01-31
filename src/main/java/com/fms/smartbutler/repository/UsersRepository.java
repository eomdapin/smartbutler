package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByUserName(String userName);
}
