package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.PopularAreaDto;
import com.ssafy.happyhouse.dto.PopularHouseDto;
import com.ssafy.happyhouse.service.PopularService;

@RequestMapping("/popular")
@RestController
@CrossOrigin("*")
public class PopularController {
	
	private final Logger logger = LoggerFactory.getLogger(PopularController.class);
	
	@Autowired
	private PopularService popularSerivce;
	
	@GetMapping("/area")
	public ResponseEntity<List<PopularAreaDto>> getPopularArea() throws Exception{
		logger.debug("getPopularArea");
		return new ResponseEntity<List<PopularAreaDto>>(popularSerivce.getPopularArea(), HttpStatus.OK);	
	}
	
	@GetMapping("/house")
	public ResponseEntity<List<PopularHouseDto>> getPopularHouse() throws Exception{
		logger.debug("getPopularHouse");
		return new ResponseEntity<List<PopularHouseDto>>(popularSerivce.getPopularHouse(), HttpStatus.OK);	
	}
}
