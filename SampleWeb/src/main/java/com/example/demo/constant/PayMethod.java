package com.example.demo.constant;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum PayMethod {

	/*現金*/
	CASH(1, "現金"),
	
	/*クレジットカード*/
	CREDIT_CARD(2, "クレジットカード"),
	
	/*銀行引き落とし*/
	BANK_WITHDRAWAL(3, "銀行引き落とし"),
	
	/*給与天引き*/
	SALARY_DEDUCTION(4, "給与天引き"),
	
	EPOS(5, "エポスカード");
	
	/*DB表示*/
	private Integer method;
	
	/*画面表示*/
	private String displayValue;

	
	public static PayMethod from(Integer value) {
		return Arrays.stream(PayMethod.values())
				  .filter(payMethod -> payMethod.getMethod().equals(value))
				  .findFirst()
				  .orElse(BANK_WITHDRAWAL);
	}
}
