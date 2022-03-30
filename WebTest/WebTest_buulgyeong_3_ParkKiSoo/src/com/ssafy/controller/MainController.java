package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dao.NoteDAO;
import com.ssafy.dao.NoteDAOImpl;
import com.ssafy.dto.NoteBook;
import com.ssafy.dto.UserInfo;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoteDAO dao = NoteDAOImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		case "NOTEREG":
			doNoteReg(request, response);
			break;
		case "NOTESAVE":
			doNoteSave(request, response);
			break;
		case "NOTESEARCH":
			System.out.println("doList");
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogout(request, response);
			break;
		}
	}


	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/Index.jsp");
	}


	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try {
			UserInfo user = dao.login(id);
			if(id.equals(user.getId()) && pw.equals(user.getPw())) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect(request.getContextPath() + "/Index.jsp");
			}
			else {
				request.setAttribute("msg", "로그인 실패");
				request.getRequestDispatcher("/Index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String noteCode = request.getParameter("noteCode");
		try {
			int ret = dao.removeNote(noteCode);
			response.sendRedirect("main.do?action=NOTESEARCH");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Error.jsp");
		}
	}


	private void doNoteReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/NoteRegister.jsp");
	}


	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String noteCode = request.getParameter("noteCode");
		try {
			NoteBook noteBook = dao.detail(noteCode);
			System.out.println(noteBook);
			request.setAttribute("notebook", noteBook);
			request.getRequestDispatcher("/NoteView.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Error.jsp");
		}
		
	}


	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<NoteBook> books = dao.select();
			
			for(NoteBook book : books)
				System.out.println(book);
			request.setAttribute("books", books);
			request.getRequestDispatcher("/NoteList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/Error.jsp");
		}
	}


	private void doNoteSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 모델번호
		String notecode = request.getParameter("noteCode");
		// 모델명
		String model = request.getParameter("model");
		// 가격
		int price = Integer.parseInt(request.getParameter("price"));
		// 제조사
		String company = request.getParameter("company");
		
		NoteBook dto = new NoteBook(notecode, model, price, company);
		try {
			int ret = dao.saveNote(dto);
			System.out.println("등록결과: " + ret);
			if(ret == 1) {
				request.setAttribute("result", "등록 성공");
				request.getRequestDispatcher("/Result.jsp").forward(request, response);
			}
			else {
				request.setAttribute("result", "등록 실패");
				request.getRequestDispatcher("/Result.jsp").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/Error.jsp");
		}
	}
}
