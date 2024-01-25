package com.fms.smartbutler.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fms.smartbutler.domain.Image;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public void update(Image image) {
		Image updateImage = em.find(Image.class, image.getImageId());
		
		log.info("before image.getImageId :: {}", image.getImageId());
		log.info("before updateImage.getImageId :: {}", updateImage.getImageId());
		
		updateImage.setName(image.getName());
		updateImage.setRealName(image.getRealName());
		updateImage.setSrc(image.getSrc());
		updateImage.setRealSrc(image.getRealSrc());
		
		log.info("after image.getImageId :: {}", image.getImageId());
		log.info("after updateImage.getImageId :: {}", updateImage.getImageId());
		em.persist(updateImage);
	}

	@Override
	public Optional<Image> findById(Long imgId) {
		return Optional.ofNullable(em.find(Image.class, imgId));
	}

}
