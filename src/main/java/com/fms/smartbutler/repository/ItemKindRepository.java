package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Item;

public interface ItemKindRepository extends JpaRepository<Item.ItemKind, String> {
	
}
