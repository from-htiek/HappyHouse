package com.ssafy.backend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dto.BoardDto;
import com.ssafy.backend.dto.MemberDto;
import com.ssafy.backend.service.BoardServiceImpl;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceImpl service = BoardServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		String root = request.getContextPath();
		switch(act) {
		case "list":
			path = doList(request, response);
			request.getRequestDispatcher(path).forward(request, response);	
//			response.sendRedirect(root + path);
			break;
		case "mvregister" :
			response.sendRedirect(root + "/board/boardWrite.jsp");
			break; 
		case "register" :
			path = doRegist(request, response);
			response.sendRedirect(root + path);
			break;
		case "view" :
			path = doView(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			break;
		case "mvedit" :
			path = domvEdit(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			break; 
		case "edit" :
			path = doEdit(request, response);
			response.sendRedirect(root + path);
			break; 
		case "delete" :
			path = doDeletePost(request, response);
			response.sendRedirect(root + path);
			break;
		}
	}

	private String doDeletePost(HttpServletRequest request, HttpServletResponse response) {
		String path = "/board?act=list";
		try {
			service.delete(Integer.parseInt(request.getParameter("postNo")));
		} catch (Exception e) {
			System.out.println("글 삭제중 에러가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러페이지 리턴 
		}
		
		return path;
	}

	private String doEdit(HttpServletRequest request, HttpServletResponse response) {
		String path = "/board?act=view";
		
		BoardDto dto = new BoardDto();
		dto.setPostNo(Integer.parseInt(request.getParameter("postNo")));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		int cnt = 0;
		try {
			cnt = service.update(dto);
			if(cnt == 1) { // 수정 성공
				path += "&postNo=" + dto.getPostNo();
			}else { // 수정 실패
				System.out.println("글 수정을 실패하였습니다. 잠시 후 다시 시도해 주세요.");
			}
			
		} catch (Exception e) {
			System.out.println("글을 수정하던 중 에러가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러페이지 리턴
		}
		
		return path;
	}

	private String domvEdit(HttpServletRequest request, HttpServletResponse response) {
		String path = "/board/postEdit.jsp";
		BoardDto dto = null; 
		try {
			dto = service.getPost(Integer.parseInt(request.getParameter("postNo")));
			request.setAttribute("post", dto);
		} catch (Exception e) {
			System.out.println("글 수정 정보를 불러오던 중 에러가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러페이지 리턴
		}
		return path;
	}

	private String doView(HttpServletRequest request, HttpServletResponse response) {
		String path = "/board/postView.jsp";
		BoardDto dto = null; 
		try {
			dto = service.getPost(Integer.parseInt(request.getParameter("postNo")));
			request.setAttribute("post", dto);
		} catch (Exception e) {
			System.out.println("글을 불러오던 중 에러가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러페이지 리턴
		}
		return path;
	}

	private String doRegist(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
		
		if(memberDto != null) {
			BoardDto dto = new BoardDto();
			dto.setMemId(memberDto.getMemId());
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			
			try {
				service.register(dto);
				path = "/board?act=list";
			} catch (Exception e) {
				System.out.println("글 작성중 에러가 발생했습니다.");
				e.printStackTrace();
				return null; // 에러페이지 리턴
			}
		}else {
			path = "/index.jsp"; 
		}
		
		return path;
	}

	private String doList(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		try {
			List<BoardDto> list = service.list();
			request.setAttribute("posts", list);
//			System.out.println(list); 
			path = "/board/boardList.jsp";
		} catch(Exception e){
			System.out.println("글 목록 얻기 중 에러가 발생했습니다");
			e.printStackTrace();
			return null; // 에러 페이지로 리턴
		}
		
		return path;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
