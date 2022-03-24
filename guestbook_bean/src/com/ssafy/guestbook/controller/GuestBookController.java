package com.ssafy.guestbook.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.util.DBUtil;

@WebServlet("/article")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbUtil;
	
	public void init() {
		dbUtil = DBUtil.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "index.jsp";
		if("register".equals(act)) {
			path = registerArticle(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if("list".equals(act)) {
			path = listArticle(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private String listArticle(HttpServletRequest request, HttpServletResponse response) {
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "select articleno, userid, subject, content, regtime \n";
			sql += "from guestbook \n";
			sql += "order by articleno desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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

	private String registerArticle(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = dbUtil.getConnection();
			String sql = "insert into guestbook (userid, subject, content) \n";
			sql += "values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
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

	

}
