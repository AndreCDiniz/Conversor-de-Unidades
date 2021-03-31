package com.desafio.tecnico.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import com.desafio.tecnico.dto.UnitsConvertionDTO;

public class UnitsConvertionBusiness {

	public UnitsConvertionDTO getConversion(String unit) {

		UnitsConvertionDTO conversorDTO = new UnitsConvertionDTO();
		double valorPrimeiraUnidade = 0d, valorSegundaUnidade = 0d;

		String unidadeDeMedida = unit.toLowerCase().toString();

		List<String> unidades = Arrays.asList("minute", "hour", "day", "degree", "arcminute", "arcsecond", "hectare", "lite", "tonne");
		List<Double> valores = Arrays.asList(60d, 3600d, 84600d, 0.0174533d, 3.14159265359f / 10800d, 3.14159265359f / 68400d, 1000d, 0.001d, 1000d);
		List<String> medidas = Arrays.asList("s", "s", "s", "rad", "rad", "rad", "m²", "m³", "kg");

		int posicaoDaString = unit.indexOf('/');
		String valorUnidadeAEsquerda = unit.toLowerCase().substring(1, posicaoDaString);
		String valorUnidadeADireita = unit.toLowerCase().substring(posicaoDaString + 1, unit.length() - 1);

		for (int i = 0; i < unidades.size(); i++) {

			if (valorUnidadeAEsquerda.contains(unidades.get(i))) {
				valorPrimeiraUnidade = valores.get(i);
				unidadeDeMedida = unidadeDeMedida.replace(unidades.get(i), medidas.get(i));
			}

			if (valorUnidadeADireita.contains(unidades.get(i))) {
				valorSegundaUnidade = valores.get(i);
				unidadeDeMedida = unidadeDeMedida.replace(unidades.get(i), medidas.get(i));
			}

		}

		double resultadoDivisaoDasUnidade = valorPrimeiraUnidade / valorSegundaUnidade;
		BigDecimal resultado = new BigDecimal(resultadoDivisaoDasUnidade).setScale(14, RoundingMode.HALF_EVEN);

		conversorDTO.setUnit_name(unidadeDeMedida);
		conversorDTO.setMultiplication_factor(resultado.doubleValue());

		return conversorDTO;

	}
}
