package servlet.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// .../WebBasic/mvc/aaa
// .../WebBasic/mvc/bbb
// .../WebBasic/mvc/ccc
@WebServlet("/mvc/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html);charset=utf-8");
		
		String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());
		// path: /mvc/aaa, /mvc/bbb, ...
		switch(path) {
		case "/mvc/list": list(request, response);
//		case "mvc/insert": insert(request,response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// enlteks
		List<String> list  =new ArrayList<String>();
		list.add("홍길동");
		list.add("이길동");
		list.add("박길동");
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/mvc/userList.jsp").forward(request, response);
	}
}
