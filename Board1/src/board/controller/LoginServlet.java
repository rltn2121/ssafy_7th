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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginService service = LoginServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		UserDto userDto = service.login(userEmail, userPassword);

		//JSON
		if( userDto != null ) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userDto", userDto);
			
			// client 성공 전달
			Gson gson = new Gson();
			
			JsonObject obj = new JsonObject();
			obj.addProperty("result", "success");
			
			String jsonStr = gson.toJson(obj);
			
			System.out.println("Login Success!!");
			System.out.println("jsonStr : " + jsonStr);
						
			response.getWriter().append(jsonStr);
		}else {
			// clinet 실패 전달
			Gson gson = new Gson();
			
			JsonObject obj = new JsonObject();
			obj.addProperty("result", "fail");
			
			String jsonStr = gson.toJson(obj);
			
			System.out.println("Login Fail!!");
			System.out.println("jsonStr : " + jsonStr);
						
			response.getWriter().append(jsonStr);
		}
	}

}
