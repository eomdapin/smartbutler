package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	List<Item> findByBuild_BuildId(Long buildId);

}
