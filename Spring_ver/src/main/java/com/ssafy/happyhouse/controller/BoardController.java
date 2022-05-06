package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.BoardService;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/board")
public class BoardController extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) { 
		this.boardService = boardService; 
	}

	// index에서 보드 태그 눌렀을 때 글 작성 했던 목록들 다 불러오기
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();

		String spp = map.get("spp"); // size per page (페이지당 글갯수)
		map.put("spp", spp != null ? spp : "10");
		List<BoardDto> list = boardService.list(map);
		PageNavigation pageNavigation = boardService.makePageNavigation(map);
		mav.addObject("posts", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("board/boardList");
		return mav;
	}

	@GetMapping("/register")
	public String register() throws Exception {
		return "board/boardWrite";
	}

	@PostMapping("/register")
	public String register(BoardDto boardDto, Model model, HttpSession session, RedirectAttributes redirectAttributes)
			throws Exception {

		MemberDto memberDto = (MemberDto) session.getAttribute("userDetailInfo");
		boardDto.setMemId(memberDto.getMemId());

		boardService.register(boardDto);

		redirectAttributes.addAttribute("pg", 1);
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
//		redirectAttributes.addFlashAttribute("msg", "글작성 성공!");
		return "redirect:/board/list";
	}

	@GetMapping("/getPost")
	public ModelAndView getPost(@RequestParam("postNo") int no) throws Exception {
		ModelAndView mav = new ModelAndView();
		BoardDto boardDto = boardService.getPost(no);
		boardDto.setPostNo(no);
		mav.addObject("post", boardDto);
		mav.setViewName("board/postEdit");
		return mav;
	}

	@PostMapping("/update")
	public String update(BoardDto boardDto, Model model, RedirectAttributes redirectAttributes) throws Exception {
		boardService.update(boardDto);
		redirectAttributes.addAttribute("pg", 1);
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
//		redirectAttributes.addFlashAttribute("msg", "글수정 성공!!!");
		return "redirect:/board/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("postNo") int no, Model model, RedirectAttributes redirectAttributes)
			throws Exception {
		boardService.delete(no);
		redirectAttributes.addAttribute("pg", 1);
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
//		redirectAttributes.addFlashAttribute("msg", "글삭제 성공!!!");
		return "redirect:/board/list";
	}

}
