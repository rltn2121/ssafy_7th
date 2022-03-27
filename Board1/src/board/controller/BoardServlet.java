package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.dto.UserDto;
import board.service.LoginService;
import board.service.LoginServiceImpl;


@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 객체를 얻어와서 그 안에 userDto 녀석이 있는 지 확인
		// 없으면 login 페이지로 분기
		
		String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());
		
		System.out.println(path);
		switch( path ) {
			case "/board/boardMain" : 
				boardMain(request, response); 
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void boardMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/board/boardMain.jsp").forward(request, response);	
	}
}
