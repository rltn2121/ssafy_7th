package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 안녕하세요 안효인(ssafy)님!!! 
 * 아이디의 글자색을 서울 : 파랑, 대전 : 오렌지, 구미 : 핑크, 광주 : 초록, 부울경 : 보라
 */

@WebServlet("/singleparam.ssafy")
public class SingleParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet call!!!!");
//		1. data get
		String name = request.getParameter("username");
		String id = request.getParameter("userid");
		int area = Integer.parseInt(request.getParameter("area"));
		
//		2. logic >> 인사의 글자색을 서울 : 파랑, 대전 : 오렌지, 구미 : 핑크, 광주 : 초록, 부울경 : 보라
		String color[] = {"blue", "orange", "pink", "green", "purple"};
		
//		3. response page
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("	<h2 style=\"color:" + color[area] + "\">안녕하세요. " + name + "(" + id + ")님!!!</h2>");
		out.println("	</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost call!!!!");
//		1. data get
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		System.out.println(">>>>>>>>>>>>" + name);
		String id = request.getParameter("userid");
		int area = Integer.parseInt(request.getParameter("area"));
		
//		2. logic >> 인사의 글자색을 서울 : 파랑, 대전 : 오렌지, 구미 : 핑크, 광주 : 초록, 부울경 : 보라
		String color[] = {"blue", "orange", "pink", "green", "purple"};
		
//		3. response page
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("	<h2 style=\"color:" + color[area] + "\">안녕하세요. " + name + "(" + id + ")님!!!</h2>");
		out.println("	</body>");
		out.println("</html>");
	}

}
