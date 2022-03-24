package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PersonDto;
import service.PersonService;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personIdStr = request.getParameter("personId");
		int personId = Integer.parseInt(personIdStr); 
		
		PersonService service = new PersonService();
		PersonDto dto = service.getPerson(personId);
		System.out.println(dto);
		
		// jsp
		// Servlet이 받은 request를 person.jsp로 넘겨줌 (response)
		request.setAttribute("dto", dto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/person.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
