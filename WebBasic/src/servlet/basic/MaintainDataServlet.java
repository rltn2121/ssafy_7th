package servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/maintain")
public class MaintainDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("attr1", "value1");
		getServletContext().setAttribute("attr2", "value2");
		request.getSession().setAttribute("attr3", "value3");
		
		System.out.println("maintain");
		
		// forward
//		request.getRequestDispatcher("/maintain2").forward(request,response);
		
		// sendRedirect
//		response.sendRedirect("/WebBasic/maintain2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
