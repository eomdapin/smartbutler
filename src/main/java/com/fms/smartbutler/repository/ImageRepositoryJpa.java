package com.fms.smartbutler.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fms.smartbutler.dto.Image;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Repository
public class ImageRepositoryJpa implements ImageRepository {
	
	private final EntityManager em;
	
	@Override
	public void save(Image image) {
		em.persist(image);
	}

	@Override
	public Optional<Image> findById(Long imgId) {
		return Optional.ofNullable(em.find(Image.class, imgId));
	}

}
