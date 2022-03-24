package com.ssafy.guestbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;
import com.ssafy.guestbook.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = MemberServiceImpl.getMemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		if("mvregister".equals(act)) {
			response.sendRedirect(request.getContextPath() + "/user/join.jsp");
		} else if("register".equals(act)) {
			path = registerMember(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		} else if("idcheck".equals(act)) {
			int cnt = idCheck(request, response);
			response.getWriter().append(cnt+"");
		} else if("mvlogin".equals(act)) {
			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
		} else if("login".equals(act)) {
			path = loginMember(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		} else if("logout".equals(act)) {
			path = loginOutMember(request, response);
			
		}
	}

	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 1;
		String id = request.getParameter("ckid");
		cnt = memberService.idCheck(id);
		return cnt;
	}

	private String registerMember(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = new MemberDto();
		memberDto.setUserName(request.getParameter("username"));
		memberDto.setUserId(request.getParameter("userid"));
		memberDto.setUserPwd(request.getParameter("userpwd"));
		memberDto.setEmail(request.getParameter("emailid") + "@" + request.getParameter("emaildomain"));
		try {
			memberService.registerMember(memberDto);
			return "/user/login.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "회원가입 중 문제가 발생했습니다.");
			return "/error/error.jsp";
		}
	}

	private String loginMember(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = null;
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpwd");
		
		try {
			memberDto = memberService.login(id, pass);
			// 로그인 성공
			if(memberDto != null) {
				 HttpSession session = request.getSession();
				 session.setAttribute("userInfo", memberDto);
				return "/index.jsp";
			} 
			// 로그인 실패
			else {
				request.setAttribute("msg", "아이디 비번 확인");
				return "/user/login.jsp";
			}
 			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리중 문제 발생!!");
			return "/error/error.jsp";
		}
	}

	private String loginOutMember(HttpServletRequest request, HttpServletResponse response) {
		
		return "/index.jsp";
	}

}
