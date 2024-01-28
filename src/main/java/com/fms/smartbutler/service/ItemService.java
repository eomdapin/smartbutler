package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Item;
import com.fms.smartbutler.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	public void insert(Item item) {
		itemRepository.save(item);
	}
	
	public void update(Item item) {
		itemRepository.save(item);
	}
	
	public void delete(Item item) {
		itemRepository.delete(item);
	}
	
	public Optional<Item> findById(Long itemId) {
		return itemRepository.findById(itemId);
	}
	
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

}
