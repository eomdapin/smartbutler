package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void update(Build build) {
//		String sql = "UPDATE Build b "
//						+ "SET b.name :name, b.address :address"
//						+ "WHERE b.build_id = :buildId";
//		
//		em.createQuery(sql, Build.class)
//						.setParameter("name", build.getName())
//						.setParameter("address", build.getAddress())
//						.setParameter("buildId", build.getBuildId());
		
		Build updateBuild = em.find(Build.class, build.getBuildId());
		
		updateBuild.setName(build.getName());
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
