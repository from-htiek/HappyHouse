package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDetailDto;
import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.dto.TempDto;
import com.ssafy.happyhouse.service.HouseMapService;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService houseMapService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		logger.debug("sido : {}", houseMapService.getSido());
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseMapService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		logger.debug("gugun : {}", houseMapService.getGugunInSido(sido));
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseMapService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/aptdong")
	public ResponseEntity<List<HouseInfoDto>> searchByDong(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseMapService.getAptInDong(dong), HttpStatus.OK);
	}
	
	@GetMapping("/aptName")
	public ResponseEntity<List<HouseInfoDto>> searchByName(@RequestParam("aptName") String aptName) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseMapService.getAptInName(aptName), HttpStatus.OK);
	}
	
//	@GetMapping("/aptDetail")
//	public ResponseEntity<List<HouseDetailDto>> aptDetail(@RequestParam("aptCode") String aptCode) throws Exception {
//		return new ResponseEntity<List<HouseDetailDto>>(houseMapService.getAptDetail(aptCode), HttpStatus.OK);
//	}
	
	// {  "memId": "aa",  "atpCode": 1}
	@GetMapping("/aptDetail")
	public ResponseEntity<List<HouseDetailDto>> aptDetail(TempDto tempDto) throws Exception {
		logger.debug("tempDto : {}", tempDto);
		return new ResponseEntity<List<HouseDetailDto>>(houseMapService.getAptDetail(tempDto), HttpStatus.OK);
	}
	

	
}
