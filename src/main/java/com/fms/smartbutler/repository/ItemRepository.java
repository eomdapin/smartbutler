package com.fms.smartbutler.repository;

/**
* @author 정시운
* @editDate 2024-01-29 ~ 2024-01-31
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
//	List<Item> findByBuild_BuildId(Long buildId);
	Page<Item> findByBuild_BuildIdOrderByItemIdDesc(Long buildId, Pageable pageable);
	Page<Item> findAllByOrderByItemIdDesc(Pageable pageable);
}
