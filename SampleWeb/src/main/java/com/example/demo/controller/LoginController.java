package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.constant.Item;
import com.example.demo.constant.PayMethod;
import com.example.demo.dto.DaySumAmount;
import com.example.demo.dto.ItemInfo;
import com.example.demo.form.ItemForm;
import com.example.demo.service.CalculateService;
import com.example.demo.service.RegistItemService;

@Controller
public class LoginController {
	
	@Autowired
	RegistItemService registItemService;
	@Autowired
	CalculateService calculateService;

//	@GetMapping("/login")
//	public String view(Model model){ 
//		List<RegistItem> itemList = registItemService.findAll();
//		model.addAllAttributes("itemList", itemList);
//		return "login";
//	}
	
	@GetMapping("login")
	public String registItem(Model model) {
		
		ItemForm item = new ItemForm();
		List<ItemInfo> itemList = registItemService.findAll();
		List<DaySumAmount> sumAmounts = calculateService.calcDayAmount(itemList);
		model.addAttribute("sumAmounts", sumAmounts);
//		model.addAttribute("itemList", itemList);
		model.addAttribute("item", item);
		model.addAttribute("payMethods", PayMethod.values());
		model.addAttribute("items", Item.values());
		return "index";
	}
	
	@GetMapping("/other")
	public String view() {
		return "other";
	}
	
	@PostMapping("login") 
	public String itemList(ItemForm itemForm) {
		
		registItemService.create(itemForm);
		return "redirect:/login";
	}
}
