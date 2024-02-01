package com.fms.smartbutler.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	Page<Job> findByBuild_BuildIdOrderByJobIdDesc(Long buildId, Pageable pageable);
	Page<Job> findAllByOrderByJobIdDesc(Pageable pageable);
}
