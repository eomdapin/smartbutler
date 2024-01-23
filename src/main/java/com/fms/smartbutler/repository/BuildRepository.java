package com.fms.smartbutler.repository;

import java.util.List;

import com.fms.smartbutler.dto.Build;

public interface BuildRepository {
	void save(Build build);
	List<Build> findAll();
}
