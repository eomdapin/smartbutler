package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	List<Image> findByOutIdAndImageCategory_Coded(Long outId, String coded);
}
