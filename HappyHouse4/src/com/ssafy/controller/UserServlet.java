package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dao.UserDao;
import com.ssafy.dao.UserDaoImpl;
import com.ssafy.dto.UserDto;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	private final UserDao userDao = UserDaoImpl.getInstance();
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
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
            case "edit":
                doEdit(request, response);
                break;
            case "view":
                doView(request, response);
                break;   
            case "remove":
                doRemove(request, response);
                break;
        }
        
	}
	private void doView(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("doView");
		HttpSession session = request.getSession();
		String Member_id = (String) session.getAttribute("id");
      
      try {
           UserDto user = userDao.view(Member_id);
           System.out.println(user);
           // 넘겨줘야하면 -> forward
           // 넘겨줄거 없으면 ->sendRedirect
           request.setAttribute("id", user.getMember_id());
           request.setAttribute("pw", user.getMember_pwd());
           request.setAttribute("nm", user.getMember_nm());
           request.setAttribute("add", user.getMember_add());
           request.setAttribute("tell", user.getMember_tell());
           request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
            
        }
        catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
      
   }

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}


	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("userId");
		String pw = request.getParameter("password");
		try {
			UserDto user = userDao.login(id);
			if(user != null && (id.equals(user.getMember_id()) && pw.equals(user.getMember_pwd()))) {
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				System.out.println(request.getContextPath());
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			else {
				System.out.println("로그인 실패");
				request.setAttribute("msg", "로그인 실패");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        String Member_id = request.getParameter("userId2");
        String Member_pwd = request.getParameter("password");
        String Member_nm = request.getParameter("name");
        String Member_add = request.getParameter("address");
        String Member_tell = request.getParameter("number");

        UserDto user = new UserDto(Member_id, Member_pwd, Member_nm, Member_add, Member_tell);
        try {
        	int ret = userDao.register(user);
        	if( ret == 1) {
        		request.setAttribute("user", user);
        		RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        		disp.forward(request, response);
        	}
        	else {
        		request.setAttribute("msg", "회원가입 실패");
        		RequestDispatcher disp = request.getRequestDispatcher("/register.jsp");
        		disp.forward(request, response);
        	}
        }
        // 그 외의 오류들은 서버에 로그를 남기고 사용자에게는 단순한 에러 페이지를 보여준다.
        catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
	
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String Member_id = (String) session.getAttribute("id");
	      
	      try {
	           int ret = userDao.remove(Member_id);
	           if(ret == 1) {
	        	   request.setAttribute("user", ret);
	        	   response.sendRedirect(request.getContextPath()+"/user?act=logout");
	           }
	            
	        }
	        // 그 외의 오류들은 서버에 로그를 남기고 사용자에게는 단순한 에러 페이지를 보여준다.
	        catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(500);
	        }
	   }
	
	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String Member_id = (String) session.getAttribute("id");
	      String Member_pwd = request.getParameter("password");
	        String Member_nm = request.getParameter("name");
	        String Member_add = request.getParameter("address");
	        String Member_tell = request.getParameter("number");
	        
	        try {
	           int ret= userDao.edit(Member_id,Member_pwd,Member_nm,Member_add,Member_tell);
	           
	           if(ret == 1) {
	              request.setAttribute("user", ret);
	                RequestDispatcher disp = request.getRequestDispatcher("user?act=view");
	                disp.forward(request, response);
	           }
	           
	           
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(500);
	        }

	      
	   }
}
