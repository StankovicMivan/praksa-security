package com.praksa.ivan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praksa.ivan.service.KlubService;
import com.praksa.ivan.support.KlubToKlubDTO;

import com.praksa.ivan.model.Klub;
import com.praksa.ivan.web.dto.KlubDTO;


@RestController
@RequestMapping("api/klubovi")
public class ApiKlubController {
	@Autowired
	private KlubService klubService;
	
	@Autowired
	private KlubToKlubDTO toDTO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KlubDTO>> getAll() {

		List<Klub> klubovi;

		klubovi = klubService.findAll();
		
		return new ResponseEntity<>(toDTO.convert(klubovi),  HttpStatus.OK);
	}
}
