package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	List<Job> findByBuild_BuildId(Long buildId);
	Page<Job> findAllByOrderByJobIdDesc(Pageable pageable);
}
