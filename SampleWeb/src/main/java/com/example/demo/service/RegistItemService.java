package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemInfo;
import com.example.demo.entity.RegistItem;
import com.example.demo.form.ItemForm;
import com.example.demo.repository.RegistItemRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistItemService {
	
	@Autowired
	private final RegistItemRepository itemRepository;
	
	private final Mapper mapper;
	
	public void create(ItemForm itemForm) {
		itemRepository.save(createItem(itemForm));
	}
	
	public RegistItem createItem(ItemForm itemForm) {
		
		RegistItem item = new RegistItem();
		item.setDate(itemForm.getDate());
		item.setItem(itemForm.getItem());
		item.setAmount(itemForm.getAmount());
		item.setPayMethod(itemForm.getPayMethod());
		item.setRemarks(itemForm.getRemarks());
		
		return item;
	}
	
	public List<ItemInfo> findAll() {
		return toItemListInfos(itemRepository.findAllByOrderByDate());
	}
	
	public List<ItemInfo> toItemListInfos(List<RegistItem> registItems) {
		var itemListInfo = new ArrayList<ItemInfo>();
		for (RegistItem registItem : registItems) {
			var itemInfo = mapper.map(registItem, ItemInfo.class);
			itemInfo.setPayMethod(registItem.getPayMethod().getDisplayValue());
			itemInfo.setItem(registItem.getItem().getJpName());
			itemListInfo.add(itemInfo);
		}
		return itemListInfo;
	}
	
}
