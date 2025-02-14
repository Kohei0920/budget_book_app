package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RegistItem;
import com.example.demo.repository.RegistItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DateItemService {

	@Autowired
	private final RegistItemRepository itemRepository;
	
	public List<RegistItem> findItemByDate(LocalDate date) {
		return itemRepository.findByDateOrderByItemDesc(date);
	}
	
}
