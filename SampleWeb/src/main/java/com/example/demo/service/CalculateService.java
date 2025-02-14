package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DaySumAmount;
import com.example.demo.dto.ItemInfo;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculateService {

	@Autowired
	private Mapper mapper;
	
	Integer sumAmount = 0;

	public List<DaySumAmount> calcDayAmount(List<ItemInfo> itemInfos) {
		
		var sumListPerDay = new ArrayList<DaySumAmount>();
		
		for(ItemInfo itemInfo : itemInfos) {
			
			if(itemInfo.getAmount() == null) {
				
				itemInfo.setAmount(0);
				
			}
		}
		
		for(Integer i = 0; i < itemInfos.size() ; i++) {
			
			if (i == itemInfos.size() - 1) {
				createDaySumAmount(itemInfos, sumListPerDay, i);
			} else {
				
				if (itemInfos.get(i).getDate().equals(itemInfos.get(i + 1).getDate())) {

					sumAmount += itemInfos.get(i).getAmount();

				} else {

					createDaySumAmount(itemInfos, sumListPerDay, i);

				}
			}
			
			}	
		return sumListPerDay;
		}
	
	public void createDaySumAmount(List<ItemInfo> itemInfos, List<DaySumAmount> sumListPerDay, Integer i) {
		sumAmount += itemInfos.get(i).getAmount();
		var daySumAmount = mapper.map(itemInfos.get(i), DaySumAmount.class);
		daySumAmount.setSum(sumAmount);
		sumListPerDay.add(daySumAmount);
		sumAmount = 0;
	}
	}




