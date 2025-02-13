package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DaySumAmount {
	
	private LocalDate date;
	
	private Integer sum;
	
	private String memo;
}
