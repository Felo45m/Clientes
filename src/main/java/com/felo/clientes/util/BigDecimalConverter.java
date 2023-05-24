package com.felo.clientes.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConverter {

	public BigDecimal toConvert(String value) {
		
		if(value == null) {
			return null;
		}
		
		value = value.replace(".", "").replace(",", ".");
		return new BigDecimal(value);
	}
}
