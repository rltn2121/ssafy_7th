package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.dto.UserDto;
import board.service.UserService;
import board.service.UserServiceImpl;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService service = UserServiceImpl.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(userPassword);
		UserDto userDto = service.register(userName, userEmail, userPassword);
		
		
		// JSON 형식으로 반환
		if(userDto != null) {
			// 회원가입 성공
			
			request.setAttribute("result", "success");
			request.setAttribute("userName", userDto.getUserName());
			request.setAttribute("userEmail", userDto.getUserEmail());
			request.setAttribute("userPassword", userDto.getUserPassword());
			
			System.out.println("Register Success!!");
			
			// reuqest에 담은 정보들을 결과 패이지에 넘겨준다.
			RequestDispatcher disp = request.getRequestDispatcher("/jsp/register_result.jsp");
			disp.forward(request, response);
		}
		else {
			// 회원가입 실패
			request.setAttribute("result", "fail");
			System.out.println("Register fail!!");
			
			// reuqest에 담은 정보들을 결과 패이지에 넘겨준다.
			RequestDispatcher disp = request.getRequestDispatcher("/jsp/register_result.jsp");
			disp.forward(request, response);
			
		}
		
	}
}

