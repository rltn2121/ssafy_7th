package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.dao.UserDao;
import com.ssafy.dao.UserDaoImpl;
import com.ssafy.dto.Dong;
import com.ssafy.dto.Gugun;
import com.ssafy.dto.HouseDeal;
import com.ssafy.dto.HouseInfo;
import com.ssafy.service.HouseService;
import com.ssafy.service.HouseServiceImpl;

@WebServlet("/house")
public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final HouseService service = HouseServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		process(request, response);
	}

	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String act = request.getParameter("act");
		switch(act) {
		case "gugun":
			doGugun(request, response);
			break;
		case "dong":
			doDong(request, response);
			break;
		case "search":
			doSearch(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		}
	}


	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int NO = Integer.parseInt(request.getParameter("no"));
      
      try {
         HouseInfo houseinfo = service.detail(NO);
         request.setAttribute("houseinfo", houseinfo);
         request.getRequestDispatcher("/aptDetail.jsp").forward(request, response);
         
      } catch (Exception  e) {
         e.printStackTrace();
      }
   
      
   }

	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido_code = request.getParameter("address1");
		String gugun_code = request.getParameter("address2");
		String dong_code = request.getParameter("address3");
		
		if(sido_code==null)
			sido_code="11";
		if(gugun_code==null)
			gugun_code="11110";
		if(dong_code==null)
			dong_code="1111010100";

		System.out.println(sido_code);
		System.out.println(gugun_code);
		System.out.println(dong_code);
		try {
			// housedeal 검색하기
			List<HouseDeal> list = service.search(sido_code, gugun_code, dong_code);
			for(HouseDeal hd : list)
				System.out.println(hd);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/apt.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void doDong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		String gugun_code = request.getParameter("address2");
		if(gugun_code == null) {
			System.out.println("구군 코드 null");
		}
		else {
			System.out.println("구군코드: " + gugun_code);
		}
		try {
			List<Dong> list = service.getDong(gugun_code);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			response.getWriter().write(jsonStr);
			System.out.println(jsonStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	private void doGugun(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		String sido_code = request.getParameter("address1");
		System.out.println("시도코드: " + sido_code);
		try {
			List<Gugun> list = service.getGugun(sido_code);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			response.getWriter().write(jsonStr);
			System.out.println(jsonStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
