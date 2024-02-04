package com.fms.smartbutler.repository;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByEmail(String email);
	Users findByUserName(String userName);
}
