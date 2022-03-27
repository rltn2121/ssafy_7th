package com.ssafy.backend.servlet;

import javax.servlet.RequestDispatcher;
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
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    // DB 연동을 위해 UserDao와 BookDao 객체를 사용한다.
    private final UserDao userDao = UserDaoImpl.getInstance();
    private final BookDao bookDao = BookDaoImpl.getInstance();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * post 방식의 요청에 대해 응답하는 메서드이다.
     * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        process(request, response);
    }

    /**
     * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist)
     * 호출해준다.
     */
    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
	        case "login":
	        	doLogin(request, response);
	        	break;
	        case "logout":
	        	doLogout(request, response);
	        	break;
            case "regist":
                doRegist(request, response);
                break;
            case "list":
                doList(request, response);
                break;
            case "detail":
            	doDetail(request, response);
            	break;
            case "remove":
            	doRemove(request, response);
            	break;
        }
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		try {
			bookDao.delete(isbn);
			RequestDispatcher disp = request.getRequestDispatcher("./main?action=list");
			disp.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String isbn = request.getParameter("isbn");
		try {
			Book book = bookDao.detail(isbn);
			request.setAttribute("book", book);
			RequestDispatcher disp = request.getRequestDispatcher("/detail.jsp");
			disp.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

	/**
     * 클라이언트에서 전달된 request를 분석해서 regist_result.jsp에서 보여줄 수 있게 한다.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doRegist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int price = Integer.parseInt(request.getParameter("price"));
        String desc = request.getParameter("desc");
        Book book = new Book(isbn, title, author, price, desc, null);
        try {
            // bookDao의 insert를 호출한다.
            bookDao.insert(book);
            request.setAttribute("book", book);
            RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
            disp.forward(request, response);
        }
        // P.K 중복과 관련된 내용은 사용자에게 정확히 내용을 전달해야 하는 상황이다.
        catch (SQLIntegrityConstraintViolationException e) {
            request.setAttribute("msg", "도서 등록 실패:" + isbn + "은 이미 사용중입니다.");
            RequestDispatcher disp = request.getRequestDispatcher("/regist.jsp");
            disp.forward(request, response);
        }
        // 그 외의 오류들은 서버에 로그를 남기고 사용자에게는 단순한 에러 페이지를 보여준다.
        catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    /**
     * 로그인 처리한다.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        try {
            // id를 기반으로 사용자 정보를 조회해 온다.
            User user = userDao.select(id);
            // id가 null이 아니고 비밀번호가 파라미터인 pass와 같다면 로그인 가능하다.
            if (user != null && user.getPass().equals(pass)) {
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", user);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                request.setAttribute("msg", "로그인 실패");
                RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
                disp.forward(request, response);
            }
        }
        // 예외가 발생한다면 오류 페이지로 연결한다.
        catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    /**
     * 로그아웃 처리한다.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /**
     * 등록된 도서 정보를 request에 저장하고 list.jsp를 forward로 호출한다.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // BookDao의 select를 호출한다.
            List<Book> books = bookDao.select();
            request.setAttribute("books", books);
            RequestDispatcher disp = request.getRequestDispatcher("/list.jsp");
            disp.forward(request, response);
        }
        // 예외가 발생한다면 오류 페이지로 연결한다.
        catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
