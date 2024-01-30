package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Item;
import com.fms.smartbutler.dto.ItemDTO;
import com.fms.smartbutler.repository.ItemKindRepository;
import com.fms.smartbutler.repository.ItemRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
	
	private final ItemRepository itemRepository;
	private final ItemKindRepository itemKindRepository;
	private final ModelMapper modelMapper;
	
	public void insert(ItemDTO itemDTO) {
		Item item = modelMapper.map(itemDTO, Item.class);
		
		itemRepository.save(item);
		itemDTO.setItemId(item.getItemId());
	}
	
	public void update(ItemDTO itemDTO) {
		Item item = modelMapper.map(itemDTO, Item.class);
		
		log.info("itemService >> " + item.getItemKind().getKindType());
		
		itemRepository.save(item);
		itemDTO.setItemId(item.getItemId());
	}
	
	public Optional<ItemDTO> findById(Long itemId) {
		Optional<Item> item = itemRepository.findById(itemId);
		ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
		
		return Optional.ofNullable(itemDTO);
	}
	
	public List<ItemDTO.ItemKindDTO> findAllItemKind() {
		List<Item.ItemKind> itemKind = itemKindRepository.findAll();
		List<ItemDTO.ItemKindDTO> itemKindDTO = itemKind
														.stream()
														.map(i ->
														modelMapper
														.map(i, ItemDTO.ItemKindDTO.class))
														.collect(Collectors.toList());
		
		return itemKindDTO;
	}
	
	public List<ItemDTO> findByBuildId(Long buildId) {
		List<Item> item = itemRepository.findByBuild_BuildId(buildId);
		List<ItemDTO> itemDTO = item
									.stream()
									.map(i ->
											modelMapper
											.map(i, ItemDTO.class))
											.collect(Collectors.toList());
		
		return itemDTO;
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

	public void delete(ItemDTO itemDTO) {
		Item item = modelMapper.map(itemDTO, Item.class);
		
		itemRepository.delete(item);
	}
}
