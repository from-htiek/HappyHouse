package com.ssafy.happyhouse.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping("/register")
	public String register(MemberDto memberDto, Model model) throws Exception{
		logger.debug("controller dto: {}", memberDto);
		memberService.regist(memberDto);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("/info/{memId}")
	public String memberInfo(@PathVariable("memId") String memId, HttpSession session) throws Exception {
		MemberDto memberDto = memberService.memberInfo(memId);
		session.setAttribute("userDetailInfo", memberDto);
		return "member/memberInfo";
	}	
	
	@GetMapping("/update")
	public String update() {
		return "member/memberUpdate";
	}
	
	@PostMapping("/update")
	public String update(MemberDto memberDto, HttpSession session, Model model) throws Exception {
		memberService.update(memberDto);
		session.setAttribute("userDetailInfo", memberDto);
		model.addAttribute("msg", "회원정보가 수정되었습니다.");
		return "member/memberInfo";
	}

	@GetMapping("/delete/{memId}")
	public String delete(@PathVariable String memId, HttpSession session, Model model) throws Exception {
		logger.debug("delete memId: {}", memId);
		memberService.delete(memId);
	    session.invalidate();
	    model.addAttribute("msg", "회원탈퇴가 완료되었습니다.");
	    return "redirect:/";
	}
	
	
}
