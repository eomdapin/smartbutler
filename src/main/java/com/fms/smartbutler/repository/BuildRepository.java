package com.fms.smartbutler.repository;

/**
* @author 엄다빈
* @editDate 2024-01-23 ~ 2024-01-24
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Build;

public interface BuildRepository extends JpaRepository<Build, Long>{
	
}
