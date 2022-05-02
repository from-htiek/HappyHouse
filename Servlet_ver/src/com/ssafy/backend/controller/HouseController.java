package com.ssafy.backend.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dto.HouseDto;
import com.ssafy.backend.dto.MemberDto;
import com.ssafy.backend.service.HouseServiceImpl;
import com.ssafy.backend.service.MemberServiceImpl;

@WebServlet("/house")
public class HouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HouseServiceImpl service = HouseServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		String root = request.getContextPath();
		switch(act) {
		case "dongsearch":
				path = searchDong(request,response);
				request.getRequestDispatcher(path).forward(request, response);
				break;
		
		case "aptsearch":
				path = searchApt(request,response);
				request.getRequestDispatcher(path).forward(request, response);
				break;
				
		case "favorite":
				path = favorite(request,response);
				response.sendRedirect(root+path);
				break;
				
		case "inquire":
				path = inquire(request,response);
				request.getRequestDispatcher(path).forward(request, response);
				break;
				
		case "delete":
				path = delete(request,response);
				request.getRequestDispatcher(path).forward(request, response);
				break;	
				
		}
		
	}


	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String path = "/favorite/favorite.jsp";
		String aptNo = request.getParameter("aptNo");
		String aptCode = request.getParameter("aptCode");
		String memId = request.getParameter("memId");
		int res = -1;
		
		try {
			res = service.deleteFavoriteHouse(aptNo, aptCode, memId);
		} catch (SQLException e) {
			System.out.println("찜목록 삭제 중 오류가 발생했습니다. ");
			e.printStackTrace();
		}
		if(res == 0) {
			request.setAttribute("msg", "나의 목록을 삭제하지  못했습니다.");
		}
		
		return inquire(request, response);
	}


	private String inquire(HttpServletRequest request, HttpServletResponse response) {
		List<HouseDto> list = null;
		String path = "/favorite/favorite.jsp";
		String memId = request.getParameter("memId");
		try {
			list = service.inquireFavorite(memId);
			System.out.println("리스트 받아오기 성공");
		} catch (SQLException e) {
			System.out.println("나의 관심 목록 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
			path = "/error/error.jsp";
		}
		if(list == null) {
			request.setAttribute("msg", "나의 목록을 불러오지 못했습니다.");
		}else {
			request.setAttribute("list", list);
		}
		
		return path;
	}


	private String favorite(HttpServletRequest request, HttpServletResponse response) {
		String path = "/house?act=";
		String aptNo = request.getParameter("aptNo");
		String aptCode = request.getParameter("aptCode");
		String memId = request.getParameter("memId");
		int res = 0;
		try {
			res = service.addFavoriteHouse(aptNo, aptCode, memId);
			System.out.println("아파트 관심목록 등록 성공");
		} catch (SQLException e) {
			System.out.println("아파트 관심목록 등록 중 오류가 발생했습니다.");
			e.printStackTrace();
			path = "/error/error.jsp";
		}
		if(res == 1) {
			//성공적인 등록
			HttpSession session = request.getSession();
			String method = (String) session.getAttribute("method");
			
			if(method.equals("dongsearch")) {
				path += method + "&dong=" + (String) session.getAttribute("dong") + "&memId=" + memId;
			}else if(method.equals("aptsearch")) {
				path += method + "&apt=" + (String) session.getAttribute("apt") + "&memId=" + memId;
			}
			
		}
		else if(res == 2) {
			//이미 등록되어있는 찜
		}
		System.out.println(path);
		return path;
	}


	private String searchDong(HttpServletRequest request, HttpServletResponse response) {
		List<HouseDto> list = null;
		String path = "/search/searchMain.jsp";
		String dong = request.getParameter("dong");
		String memId = request.getParameter("memId");
		
		HttpSession session = request.getSession();
		session.setAttribute("method", "dongsearch");
		session.setAttribute("dong", dong);
		try {
			list = service.searchByDong(dong, memId);
			System.out.println("성공");
		} catch (SQLException e) {
			System.out.println("동 검색 도중 오류가 발생했습니다.");
			e.printStackTrace();
			path = "/error/error.jsp";
		}
		
		if(list == null) {
			request.setAttribute("msg", "동에 있는 정보 목록을 불러오지 못했습니다.");
		}else {
			request.setAttribute("list", list);
		}
		return path;
	}

	private String searchApt(HttpServletRequest request, HttpServletResponse response) {
		List<HouseDto> list = null;
		String path = "/search/searchMain.jsp";
		String apt = request.getParameter("apt");
		String memId = request.getParameter("memId");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("method", "aptsearch");
		session.setAttribute("apt", apt);
		try {
			list = service.searchByApt(apt, memId);
			System.out.println("아파트 써치 성공");
		} catch (SQLException e) {
			System.out.println("아파트 검색 도중 오류가 발생했습니다.");
			path = "/error/error.jsp";
		}
		
		if(list == null) {
			request.setAttribute("msg", "아파트 목록을 불러오지 못했습니다.");
		}else {
			request.setAttribute("list", list);
		}
		return path;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
