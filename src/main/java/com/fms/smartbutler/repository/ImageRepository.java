package com.fms.smartbutler.repository;

/**
* @author 엄다빈
* @editDate 2024-01-24 ~ 2024-01-25
*/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	
	List<Image> findByOutIdAndImageCategory_Coded(Long outId, String coded);
}
