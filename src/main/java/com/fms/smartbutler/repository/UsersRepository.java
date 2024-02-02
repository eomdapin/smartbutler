package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByEmail(String email);
	Users findByUserName(String userName);
//	Users findByResidents_User_UserId();
}
