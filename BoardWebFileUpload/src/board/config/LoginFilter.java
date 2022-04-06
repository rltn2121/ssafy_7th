package board.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.dto.UserDto;

// no exclude
// Project 별로 처리 X
// 설정 내용은 모든 Project 에 대응됨.
// 서블릿별로도 가능
@WebFilter("/*")
public class LoginFilter implements Filter{


	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) res;
		
		String contextPath = httpServletRequest.getContextPath();
		String path = httpServletRequest.getRequestURI();
		
		System.out.println("BoardWebAjaxJson - doFilter path : " + path ); 

		HttpSession session = httpServletRequest.getSession();

		// 동기화 요청과 비동기 요청을 모두 처리할 수 있어야 한다.
		// 클라이언트가 비동기 요청을 하는 지 구분해야 함
		// -> 헤더에 async 값이 true 이면 비동기 요청
//		String async = httpServletRequest.getHeader("async");
		String async = "aaa";
		
		// exclude
		// /html/
		// /img/
		// /login
		if( ! path.contains("/img/") && ! path.contains("/css/") && 
			! path.contains("/js/") && ! path.contains("/register") && ! path.contains("/login") ) {
			UserDto userDto = (UserDto) session.getAttribute("userDto");

			// != null: 로그인 한 상태. 아직 세션 살아있음
			// == null: 로그인 안함 or 세션 종료
			if(userDto == null) {
				
				// async == true -> 비동기 요청
				if("true".equals(async)) {
					// "result":"login"
					System.out.println("Async SessionTimeout !!!");
					
					Gson gson = new Gson();
					JsonObject jsonObject = new JsonObject();
					jsonObject.addProperty("result","login");
					String jsonStr = gson.toJson(jsonObject);
					httpServletResponse.getWriter().write(jsonStr);
				}
				
				// async != true -> 일반 요청
				else {
					httpServletResponse.sendRedirect(contextPath + "/jsp/login.jsp");
					
				}
				return;
			}
		}

		chain.doFilter(req, res);
	}

}
