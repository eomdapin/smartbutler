package com.fms.smartbutler.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.dto.Build;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class BuildRepositoryJpa implements BuildRepository {
	private final EntityManager em;
	
	@Override
	public void save(Build build) {
		em.persist(build);
	}
}
