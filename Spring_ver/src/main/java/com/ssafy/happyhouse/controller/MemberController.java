package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) throws Exception {
		
		logger.debug("map : {} ", map);
		MemberDto memberDto = memberService.login(map);
		
		if(memberDto != null) {
			session.setAttribute("userInfo", memberDto);
		} else {
			model.addAttribute("msg", "Check your ID or Password.");
		}
		return "redirect:/";
	}
	
}
