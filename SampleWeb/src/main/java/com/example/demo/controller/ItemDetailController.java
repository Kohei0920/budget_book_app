package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.DayItemAmount;
import com.example.demo.entity.RegistItem;
import com.example.demo.service.DateItemService;
import com.example.demo.service.ItemCalculateService;

@Controller
public class ItemDetailController {
	
	@Autowired
	DateItemService dateItemService;
	@Autowired
	ItemCalculateService itemCalcService;
	
	@GetMapping("login/date={date}")
	public String viewItemDetail(@PathVariable LocalDate date, Model model) {
		List<RegistItem> itemList = dateItemService.findItemByDate(date);
		List<DayItemAmount> itemAmounts = itemCalcService.calcItemTotal(itemList);
		model.addAttribute("itemAmounts", itemAmounts);
		model.addAttribute("itemList", itemList);
		return "itemDetail";
	}
}
