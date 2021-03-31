package com.desafio.tecnico.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.tecnico.business.UnitsConvertionBusiness;
import com.desafio.tecnico.dto.UnitsConvertionDTO;

@RestController
@RequestMapping("/units")
public class UnitsService {

	UnitsConvertionBusiness conversor = new UnitsConvertionBusiness();
	
	@RequestMapping(value = "/si", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)			
	public UnitsConvertionDTO getConverta(@RequestParam(value = "units") String units) {
	    
	    return this.conversor.getConversion(units);
	}

}
 