package com.fms.smartbutler.repository;

/**
 * @author 송창민
 * @editDate 2024-01-31 ~ 2024-02-01
 */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	Page<Job> findByBuild_BuildIdOrderByJobIdDesc(Long buildId, Pageable pageable);
	Page<Job> findByCompany_CompanyIdOrderByJobIdDesc(Long companyId, Pageable pageable);
	Page<Job> findAllByOrderByJobIdDesc(Pageable pageable);
}
