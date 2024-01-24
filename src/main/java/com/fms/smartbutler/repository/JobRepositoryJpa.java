package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.dto.Job;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class JobRepositoryJpa implements JobRepository {

	private final EntityManager em;
	
	@Override
	public void save() {
		
	}

	@Override
	public List<Job> findAll() {
		return null;
	}

	@Override
	public Optional<Job> findById() {
		return Optional.empty();
	}

}
