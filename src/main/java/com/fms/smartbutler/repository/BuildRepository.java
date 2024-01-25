package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Build;

public interface BuildRepository extends JpaRepository<Build, Long>{
	
}
