package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DayItemAmount;
import com.example.demo.entity.RegistItem;
import com.github.dozermapper.core.Mapper;

@Service
public class ItemCalculateService {
	
	Integer sum = 0;
	
	@Autowired
	private Mapper mapper;
	

	public List<DayItemAmount> calcItemTotal(List<RegistItem> itemInfos) {
		
		var itemAmount = new ArrayList<DayItemAmount>();
		
		for (Integer i = 0; i < itemInfos.size(); i++) {
			
			if (i == itemInfos.size() - 1) {
				
				sum += itemInfos.get(i).getAmount();
				var itemInfo = mapper.map(itemInfos.get(i), DayItemAmount.class);
				itemInfo.setSubTotal(sum);
				itemInfo.setItem(itemInfos.get(i).getItem().getJpName());
				itemAmount.add(itemInfo);
				sum = 0;
				
			} else {
				
				if (itemInfos.get(i).getItem().getJpName().equals(itemInfos.get(i+1).getItem().getJpName())) {
					
					sum += itemInfos.get(i).getAmount();
					
				} else {
					
					sum += itemInfos.get(i).getAmount();
					var itemInfo = mapper.map(itemInfos.get(i), DayItemAmount.class);
					itemInfo.setSubTotal(sum);
					itemInfo.setItem(itemInfos.get(i).getItem().getJpName());
					itemAmount.add(itemInfo);
					sum = 0;
					
				}			
				
			}
			
		}
		return itemAmount;
		
	}
}
