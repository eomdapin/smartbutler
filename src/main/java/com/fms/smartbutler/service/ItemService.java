package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Item;
import com.fms.smartbutler.dto.ItemDTO;
import com.fms.smartbutler.repository.ItemRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
	
	private final ItemRepository itemRepository;
	private final ModelMapper modelMapper;
	
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
	
	public List<ItemDTO> findAll() {
		List<Item> itemList = itemRepository.findAll();
		List<ItemDTO> itemDTOList = itemList
										.stream()
										.map(i -> 
											modelMapper
											.map(i, ItemDTO.class))
											.collect(Collectors.toList());
		
		return itemDTOList;
	}

}
