package com.fms.smartbutler.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByEmail(String email);
	Users findByUserName(String userName);
	Page<Users> findAllByOrderByUserIdDesc(Pageable pageable);
}
