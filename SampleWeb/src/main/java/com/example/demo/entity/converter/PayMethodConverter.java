package com.example.demo.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import com.example.demo.constant.PayMethod;

@Converter
public class PayMethodConverter implements AttributeConverter<PayMethod, Integer> {

	@Override
	public Integer convertToDatabaseColumn(PayMethod payMethod) {
		return payMethod.getMethod();
	}

	@Override
	public PayMethod convertToEntityAttribute(Integer dbData) {
		// TODO 自動生成されたメソッド・スタブ
		return PayMethod.from(dbData);
	}
}
