package com.fms.smartbutler.repository;

import java.util.Optional;

import com.fms.smartbutler.dto.Build;
import com.fms.smartbutler.dto.Image;

public interface ImageRepository {
	
	void save(Image image);
	void update(Image image);
	Optional<Image> findById(Long imgId);
}
