package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	
}
