package com.ssafy.backend.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dto.MemberDto;
import com.ssafy.backend.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceImpl service = MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		String root = request.getContextPath();
		switch(act) {
		case "signup":
			path = root + doRegist(request, response);
			response.sendRedirect(path);
			break;
		case "login":
			path = doLogin(request, response);
			response.sendRedirect(root + path);
			break; 
		case "logout" :
			HttpSession session = request.getSession();
			session.invalidate();
			path = "/index.jsp";
			response.sendRedirect(root + path);
			break;
		case "memberinfo" :
			path = doMemberinfo(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			break; 
		case "mvupdate" :
			path = domvUpdate(request, response);
			request.getRequestDispatcher(path).forward(request, response);
			break; 
		case "update" :
			path = doUpdate(request, response);
//			request.getRequestDispatcher(path).forward(request, response);
			response.sendRedirect(root + path);
			break; 
		case "delete" :
			path = doDeleteMember(request, response);
			response.sendRedirect(root + path);
			break;
		case "mvfindpassword" :
			path = root + "/member/findPassword.jsp";
			response.sendRedirect(path);
			break;
		case "findpassword" :
//			path = doFindpassword(request, response);
			response.sendRedirect(root + path);
			break; 
		
		}
	}
	
	
	private String doFindpassword(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		MemberDto dto = new MemberDto();
		dto.setMemId(request.getParameter("name"));
		dto.setMemPw(request.getParameter("id"));
		dto.setMemName(request.getParameter("tel"));
		String result = "";
		
		
		return path; 
		
	}
	
	
	private String doDeleteMember(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		
		try {
			service.delete(request.getParameter("id"));
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (Exception e) {
			System.out.println("탈퇴 중 오류가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러 페이지로 리턴 
		}
		return path; 
	}
	
	private String doUpdate(HttpServletRequest request, HttpServletResponse response) {
		String path = "/member?act=memberinfo";
		
		MemberDto dto = new MemberDto();
		dto.setMemId(request.getParameter("id"));
		dto.setMemPw(request.getParameter("pw"));
		dto.setMemName(request.getParameter("name"));
		dto.setMemEmail(request.getParameter("email"));
		dto.setMemTel(request.getParameter("tel"));
		
		int cnt = 0;
		
		try {
			cnt = service.update(dto);
			if(cnt == 1) { // 수정 성공
				path += "&id=" + dto.getMemId(); // 아이디 붙여서 가져가기
			}else { // 수정 실패
				System.out.println("회원 수정을 실패하였습니다. 잠시 후 다시 시도해 주세요.");
			}
		} catch (Exception e) {
			System.out.println("회원 수정 중 오류가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러 페이지로 리턴 
		}
		
		return path;
		
	}
	
	private String domvUpdate(HttpServletRequest request, HttpServletResponse response) {
		String path = "/member/memberUpdate.jsp";
		MemberDto dto = null;
		
		try {
			dto = service.memberInfo(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println("회원 수정 정보를 불러오던 중 오류가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러 페이지로 리턴 
		}

		request.setAttribute("userDetailInfo", dto);
		return path;
		
	}
	
	private String doMemberinfo(HttpServletRequest request, HttpServletResponse response) {
		String path = "/member/memberInfo.jsp";
		MemberDto dto = null;
		
		try {
			dto = service.memberInfo(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println("회원 정보를 불러오던 중 오류가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러 페이지로 리턴 
		}
//		System.out.println(dto);
		request.setAttribute("userDetailInfo", dto);
		return path;
	}
	
	private String doLogin(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
		
		MemberDto dto = null;
		
		try {
			dto = service.login(id, pw);
			if(dto != null) { // 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", dto);
			} else { // 로그인 실패
				System.out.println("아이디 또는 비밀번호를 확인하세요."); // msg로 넘겨주기 
			}
			
			return "/index.jsp";
		} catch (Exception e) {
			System.out.println("로그인 중 오류가 발생했습니다.");
			e.printStackTrace();
			return null; // 에러 페이지로 리턴 
		}
	
	}

	private String doRegist(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto = new MemberDto();
		dto.setMemId(request.getParameter("id"));
		dto.setMemPw(request.getParameter("pw"));
		dto.setMemName(request.getParameter("name"));
		dto.setMemEmail(request.getParameter("email"));
		dto.setMemTel(request.getParameter("tel"));
		
		int result = 0;
//		System.out.println(dto);
		try {
			result = service.regist(dto);
		} catch (Exception e) {
			System.out.println("회원 등록 중에 오류가 발생했습니다.");
			//에러페이지 이동
			e.printStackTrace();
		}

		
		return "/index.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
