package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	
}
