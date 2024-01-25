package com.fms.smartbutler.repository;

import java.util.Optional;

import com.fms.smartbutler.domain.Image;

public interface ImageRepository {
	
	void save(Image image);
	void update(Image image);
	Optional<Image> findById(Long imgId);
}
