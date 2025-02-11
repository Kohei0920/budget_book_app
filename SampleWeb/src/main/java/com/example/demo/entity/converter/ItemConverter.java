package com.example.demo.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import com.example.demo.constant.Item;

@Converter
public class ItemConverter implements AttributeConverter<Item, String> {
	
	@Override
	public String convertToDatabaseColumn(Item item) {
		return item.getJpName();
	}

	@Override
	public Item convertToEntityAttribute(String jpName) {
		// TODO 自動生成されたメソッド・スタブ
		return Item.from(jpName);
	}
}
