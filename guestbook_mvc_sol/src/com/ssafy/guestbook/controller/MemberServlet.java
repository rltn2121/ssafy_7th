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
			response.sendRedirect(request.getContextPath() + path);
		} else if("idcheck".equals(act)) {
			int cnt = idCheck(request, response);
			response.getWriter().append(cnt + "");
		} else if("mvlogin".equals(act)) {
			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
		} else if("login".equals(act)) {
			path = loginMember(request, response);
//			response.sendRedirect(request.getContextPath() + path);
			request.getRequestDispatcher(path).forward(request, response);
		} else if("logout".equals(act)) {
			path = loginOutMember(request, response);
			response.sendRedirect(request.getContextPath() + path);
		}
	}

	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String ckid = request.getParameter("ckid");
		int cnt = 1;
		try {
			cnt = memberService.idCheck(ckid);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			e.printStackTrace();
			request.setAttribute("msg", "회원 가입 처리중 문제 발생!!");
			return "/error/error.jsp";
		}
	}

	private String loginMember(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = null;
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpwd");
		
		try {
			memberDto = memberService.login(id, pass);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리중 문제 발생!!");
			return "/error/error.jsp";
		}
		
		if(memberDto != null) {
//			session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
			
//			cookie 설정
			String idsave = request.getParameter("idsave");
			if("saveok".equals(idsave)) {//아이디 저장을 체크 했다면.
				Cookie cookie = new Cookie("ssafy_id", id);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
				response.addCookie(cookie);
			} else {//아이디 저장을 해제 했다면.
				Cookie cookies[] = request.getCookies();
				if(cookies != null) {
					for(Cookie cookie : cookies) {
						if("ssafy_id".equals(cookie.getName())) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
							break;
						}
					}
				}
			}
			return "/index.jsp";
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return "/user/login.jsp";
		}
	}

	private String loginOutMember(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/index.jsp";
	}

}
