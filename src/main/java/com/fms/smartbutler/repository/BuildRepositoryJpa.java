package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.domain.Build;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Repository
public class BuildRepositoryJpa implements BuildRepository {
	private final EntityManager em;
	
	@Override
	public void save(Build build) {
		em.persist(build);
	}

	@Override
	public void update(Build build) {
		Build updateBuild = em.find(Build.class, build.getBuildId());
		
		updateBuild.setBuildName(build.getBuildName());
		updateBuild.setAddress(build.getAddress());
		
		em.persist(updateBuild);
	}
	
	@Override
	public Optional<Build> findById(Long buildId) {
		Build build = em.find(Build.class, buildId);
		return Optional.ofNullable(build);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Build> findAll() {
		Query query = em.createQuery("SELECT b FROM Build b");
		return query.getResultList();
	}
}
