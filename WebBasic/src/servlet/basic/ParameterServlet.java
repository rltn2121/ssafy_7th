package servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request: 한글 안깨짐
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		System.out.println("username : " + username);
		System.out.println("email : " + email);
		
		// response: 한글 깨짐
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("username : " + username);
		response.getWriter().append("email : " + email);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String pw = request.getParameter("pw");
		String[] hobby = request.getParameterValues("hobby");
		System.out.println("username : " + username);
		System.out.println("pw : " + pw);
		
		if(hobby != null) {
			for(String h : hobby)
				System.out.println(h);
		}
		// response: 한글 깨짐
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("username : " + username);
		response.getWriter().append("pw : " + pw);
	}

}
