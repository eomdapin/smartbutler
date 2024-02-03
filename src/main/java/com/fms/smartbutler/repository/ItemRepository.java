package com.fms.smartbutler.repository;

/**
* @author 정시운
* @editDate 2024-01-29 ~ 2024-01-31
*/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findByBuild_BuildId(Long buildId);

}
