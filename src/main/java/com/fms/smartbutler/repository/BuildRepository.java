package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import com.fms.smartbutler.dto.Build;

public interface BuildRepository {
	void save(Build build);
	void update(Build build);
	Optional<Build> findById(Long buildId);
	List<Build> findAll();
}
