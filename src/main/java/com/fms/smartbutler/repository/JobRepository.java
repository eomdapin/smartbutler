package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import com.fms.smartbutler.dto.Job;

public interface JobRepository {
	void save();
	List<Job> findAll();
	Optional<Job> findById();
}
