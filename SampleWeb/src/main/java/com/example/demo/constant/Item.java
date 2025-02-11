package com.example.demo.constant;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Item {

	RENT("家賃"),
	
	UTILITIES("光熱費"),
	
	FOOD("食費"),
	
	COMMUNICATION("通信費"),
	
	TRANSPORTATION("交通費"),
	
	ENTERTAINMENT("交際費"),
	
	MEDICAL("医療費"),
	
	DAILY("日用品"),
	
	BEAUTY("美容費"),
	
	CLOTHING("衣料品類"),
	
	KARAOKE("カラオケ"),
	
	MISCELLANEOUS("雑費");
	
	private String jpName;
	
	public static Item from(String value) {
		return Arrays.stream(Item.values())
				  .filter(item -> item.getJpName().equals(value))
				  .findFirst()
				  .orElse(RENT);
	}
}
