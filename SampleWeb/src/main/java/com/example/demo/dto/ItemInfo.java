package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ItemInfo {
	
	private LocalDate date;
	
	private String item;
	
	private Integer amount;
	
	private String payMethod;
	
	private String remarks;
}
