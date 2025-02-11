package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.constant.Item;
import com.example.demo.constant.PayMethod;

import lombok.Data;

@Data
public class ItemForm {
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;
	
	private Item item;
	
	private Integer amount;
	
	private PayMethod payMethod;
	
	private String remarks;
	
}
