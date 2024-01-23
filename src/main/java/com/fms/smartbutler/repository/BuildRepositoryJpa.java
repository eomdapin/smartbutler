package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.dto.Build;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Build> findAll() {
		Query query = em.createQuery("SELECT b FROM Build b");
		return query.getResultList();
	}
}
