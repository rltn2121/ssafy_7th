package com.ssafy.backend.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dao.BookDao;
import com.ssafy.backend.dao.BookDaoImpl;
import com.ssafy.backend.dao.UserDao;
import com.ssafy.backend.dao.UserDaoImpl;
import com.ssafy.backend.dto.Book;
import com.ssafy.backend.dto.User;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = UserDaoImpl.getInstance();
	private BookDao bookDao = BookDaoImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action: " + action + "\nrequest.getContextPath(): " + request.getContextPath());
		
		switch(action) {
		case "remove":
			doRemove(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "regist":
			doRegist(request, response);
			break;
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogout(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Book> books = bookDao.select();
			request.setAttribute("books", books);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pass");
		try {
			User user = userDao.select(id);
			if(user != null && pw.equals(user.getPass())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			else {
				request.setAttribute("msg", "로그인 실패");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = null;
		String isbn = request.getParameter("isbn");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		book = new Book(isbn, title, author, price, desc, null);
		try {
			bookDao.insert(book);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/regist_result.jsp").forward(request, response);
		} catch (SQLIntegrityConstraintViolationException e ) {
			request.setAttribute("msg", "도서 등록 실패: " + isbn + "은 이미 사용중");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		try {
			Book book = bookDao.detail(isbn);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/detail.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		try {
			bookDao.delete(isbn);
			request.getRequestDispatcher("./main?action=list").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

}
