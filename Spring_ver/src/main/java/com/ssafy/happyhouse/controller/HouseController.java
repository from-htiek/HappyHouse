package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
public class HouseController {

	static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	
	private HouseService houseSerivce;
	
	@Autowired
	public HouseController(HouseService houseSerivce) {
		this.houseSerivce = houseSerivce;
	}

	@GetMapping("/favorite/list/{memId}")
	public String list(@PathVariable("memId") String memId, Model model) throws Exception {
		logger.debug("id : {}", memId);
		
		List<HouseDto> list = houseSerivce.inquireFavorite(memId);
		model.addAttribute("list", list);
		return "favorite/favorite";
	}
	
	@PostMapping("/favorite/delete")
	public String delete(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("map : {}", map);
		houseSerivce.deleteFavoriteHouse(map);
		return "redirect:/favorite/list/" + map.get("memId");
	}
	
	
	@GetMapping("/house/search")
	public String search() {
		return "search/searchMain";
	}
	
	@GetMapping("/house/search/dong")
	public String searchBydong(@RequestParam Map<String, String> map, HttpSession session, Model model) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String memId = memberDto.getMemId();
		map.put("memId", memId);
		logger.debug("map : {}", map);
	
		List<HouseDto> list = houseSerivce.searchByDong(map);
		model.addAttribute("list", list);
		session.setAttribute("method", "dong");
		session.setAttribute("dong", map.get("dong"));
		return "search/searchMain";
	}
	
	@GetMapping("/house/search/apt")
	public String searchByapt(@RequestParam Map<String, String> map, HttpSession session, Model model) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String memId = memberDto.getMemId();
		map.put("memId", memId);
		logger.debug("map : {}", map);
		
		List<HouseDto> list = houseSerivce.searchByApt(map);
		model.addAttribute("list", list);
		session.setAttribute("method", "apt");
		session.setAttribute("apt", map.get("apt"));
		return "search/searchMain"; 
	}
	
	@PostMapping("/house/favorite")
	public String addFavorite(@RequestParam Map<String, String> map, HttpSession session, Model model) throws Exception {
		String method = (String) session.getAttribute("method");
		logger.debug("map : {}, method : {}", map, method);
		
		houseSerivce.addFavoriteHouse(map);
		
		if(method.equals("dong")) {
			String dong = (String) session.getAttribute("dong");
			return "redirect:/house/search/dong" + "?dong=" + dong;
		}
		else {
			String apt = (String) session.getAttribute("apt");
			return "redirect:/house/search/apt" + "?apt=" + apt;
		}
	}
}