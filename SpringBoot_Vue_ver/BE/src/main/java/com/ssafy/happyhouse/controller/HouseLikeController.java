package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.AreaLikeDto;
import com.ssafy.happyhouse.dto.HouseLikeDto;
import com.ssafy.happyhouse.service.HouseLikeService;
import com.ssafy.happyhouse.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("HouseLikeController")
@RestController
//@RequestMapping("/houselike")
@CrossOrigin("*")
public class HouseLikeController {

	static final Logger logger = LoggerFactory.getLogger(HouseLikeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private HouseLikeService houseLikeService;
	
	@ApiOperation(value = "관심매물 등록", notes = "관심매물을 등록한다. 그리고 DB입력 성공여부에 따라  'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/houselike/insert")
	public ResponseEntity<String> insertHouseLike(@RequestBody HouseLikeDto houseLikeDto) throws Exception{
		logger.info("insertHouse - 호출");
		if(houseLikeService.insertLikeHouse(houseLikeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "관심매물 삭제", notes = "no에 해당하는 관심매물을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/houselike/delete/{no}")
	public ResponseEntity<String> deleteHouseLike(@PathVariable("no") int no) throws Exception {
		logger.info("deleteHouseLike - 호출");
		if (houseLikeService.deleteLikeHouse(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	@ApiOperation(value = "관심매물 리스트 보기", notes = "memId에 따른 관심매물 dto을 반환한다.", response = HouseLikeDto.class)
	@GetMapping("/houselike/list/{memId}")
	public ResponseEntity<List<HouseLikeDto>> listHouseLike(@PathVariable("memId") String memId) throws Exception {
		logger.info("listHouseLike - 호출");
		return new ResponseEntity<List<HouseLikeDto>>(houseLikeService.getLikeHouse(memId), HttpStatus.OK);
	}
	
	@PostMapping("/arealike/insert")
	public ResponseEntity<String> addBookmarkArea(@RequestBody AreaLikeDto areaLikeDto) throws Exception {
		logger.debug("makeBookmarkArea : {}", areaLikeDto);
		if(houseLikeService.addBookmarkArea(areaLikeDto)){
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/arealike/{memId}")
	public ResponseEntity<List<AreaLikeDto>> listBookmarkArea(@PathVariable("memId") String memId) throws Exception {
		return new ResponseEntity<List<AreaLikeDto>>(houseLikeService.getBookmarkArea(memId), HttpStatus.OK);
	}
	
	
}
