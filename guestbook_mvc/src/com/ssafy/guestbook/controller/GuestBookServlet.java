package com.ssafy.guestbook.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.GuestBookService;
import com.ssafy.guestbook.model.service.GuestBookServiceImpl;
import com.ssafy.util.DBUtil;

@WebServlet("/article")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	private GuestBookService guestBookService = GuestBookServiceImpl.getGuestBookService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		if("mvregister".equals(act)) {
			response.sendRedirect(request.getContextPath() + "/guestbook/write.jsp");
		} else if ("register".equals(act)) {
			path = registerArticle(request, response);
//			response.sendRedirect(request.getContextPath() + path);
			request.getRequestDispatcher(path).forward(request, response);
		} else if ("list".equals(act)) {
			path = listArticle(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private String registerArticle(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = dbUtil.getConnection();
			StringBuilder registerArticle = new StringBuilder();
			registerArticle.append("insert into guestbook (userid, subject, content, regtime) \n");
			registerArticle.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(registerArticle.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt != 0 ? "/guestbook/writesuccess.jsp" : "/guestbook/writefail.jsp";
	}

	private String listArticle(HttpServletRequest request, HttpServletResponse response) {
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder listArticle = new StringBuilder();
			listArticle.append("select articleno, userid, subject, content, regtime \n");
			listArticle.append("from guestbook \n");
			listArticle.append("order by articleno desc \n");
			pstmt = conn.prepareStatement(listArticle.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBookDto guestBookDto = new GuestBookDto();
				guestBookDto.setArticleNo(rs.getInt("articleno"));
				guestBookDto.setUserId(rs.getString("userid"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegTime(rs.getString("regtime"));
				
				list.add(guestBookDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		request.setAttribute("articles", list);
		
		return "/guestbook/list.jsp";
	}

}
