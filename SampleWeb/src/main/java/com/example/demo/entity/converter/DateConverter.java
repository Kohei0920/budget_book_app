package com.example.demo.entity.converter;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class DateConverter implements AttributeConverter<LocalDate, Date>{

	@Override 
	public Date convertToDatabaseColumn(LocalDate javaDate) {
		return Date.valueOf(javaDate);
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		// TODO 自動生成されたメソッド・スタブ
		return sqlDate.toLocalDate();
	}
}
