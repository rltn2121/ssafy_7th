package com.ssafy.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.util.DBUtil;

@WebServlet("/articlewrite")
public class GuestBookWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DBUtil dbUtil;
	
	@Override
	public void init() {
		dbUtil= DBUtil.getInstance();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//		1. 아이디, 제목, 내용 get
//		2. Logic -> 받은 데이터를 DB에 insert
//		3. 응답 페이지 작성 (response page >> html)
		
		
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			String sql = "insert into guestbook (userid, subject, content) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  userid);
			pstmt.setString(2,  subject);
			pstmt.setString(3,  content);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>SSAFY - 글목록</title>");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
		out.println("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
		out.println("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
		out.println("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
		out.println("    <script type=\"text/javascript\">");
		out.println("        $(document).ready(function () {");
		if(cnt != 0 ) {
			
			out.println("            $(\"#mvListBtn\").click(function () {");
			out.println("                location.href = \"/guestbook_servlet/articlelist\";");
			out.println("            });");
		}
		else {
			
			out.println("            $(\"#mvRegisterBtn\").click(function () {");
			out.println("                location.href = \"/guestbook_servlet/guestbook/write.html\";");
			out.println("            });");
		}
		out.println("        });");
		out.println("    </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("    <div class=\"container text-center mt-3\">");
		out.println("        <div class=\"col-lg-8 mx-auto\">");
		if(cnt != 0) {
			out.println("            <div class=\"jumbotron\">");
			out.println("                <h1 class=\"text-primary\">글작성 성공 ^^</h1>");
			out.println("                <p class=\"mt-4\"><button type=\"button\" id=\"mvListBtn\" class=\"btn btn-outline-dark\">글목록 페이지로 이동</button>");
			out.println("                </p>");
			out.println("            </div>");
		}
		else {
 			out.println("            <div class=\"jumbotron\">");
			out.println("                <h1 class=\"text-danger\">글작성 실패 T.T</h1>");
			out.println("                <p class=\"mt-4\"><button type=\"button\" id=\"mvRegisterBtn\" class=\"btn btn-outline-dark\">글쓰기 페이지로 이동</button>");
			out.println("                </p>");
			out.println("            </div>");
		}
		out.println("        </div>");
		out.println("    </div>");
		out.println("</body>");
		out.println("</html>");
	}

}
