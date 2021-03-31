package com.desafio.tecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitsConvertionDTO {
	
	private String unit_name;
	private double multiplication_factor;
	
}
