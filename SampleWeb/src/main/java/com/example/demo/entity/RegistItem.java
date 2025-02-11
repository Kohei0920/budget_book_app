package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.constant.Item;
import com.example.demo.constant.PayMethod;
import com.example.demo.entity.converter.DateConverter;
import com.example.demo.entity.converter.ItemConverter;
import com.example.demo.entity.converter.PayMethodConverter;

import lombok.Data;

@Entity
@Table(name="register_item")
@Data
public class RegistItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="budget_id")
	private Integer budgetId;
	
	@Column(name="buy_dt")
	@Convert(converter = DateConverter.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;
	
	@Convert(converter = ItemConverter.class)
	private Item item;
	
	private Integer amount;
	
	@Column(name="pay_method")
	@Convert(converter = PayMethodConverter.class)
	private PayMethod payMethod;
	
	private String remarks;
}
