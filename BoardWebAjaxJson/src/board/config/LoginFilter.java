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

import board.dto.UserDto;

// context path를 고려해야 함
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)req;
		HttpServletResponse httpServletResponse = (HttpServletResponse)res;	
		
		
		String contextPath = httpServletRequest.getContextPath();
		String path = httpServletRequest.getRequestURI();
		
		// 걸러야 하는 요청에 대해서 처리
		HttpSession session = httpServletRequest.getSession();
		UserDto userDto = (UserDto)session.getAttribute("userDto");
		
		
		/**
		 * 적용하지 않아야 하는 자원 (public)은 제외해야 함 (exclude)
		 */
		if(!path.contains("/login") 
				&& !path.contains("/register") 
				&& !path.contains("/img/") 
				&& !path.contains("/js/") 
				&& !path.contains("/css/")) {
			// 로그인 안했으면
			if(userDto == null) {
				// 로그인 페이지로 이동
				httpServletResponse.sendRedirect(contextPath+"/jsp/login.jsp");
				return;	// chain.doFilter() 들어가지 않음
			}
		}
		// 로그인 했으면
		else {
			
		}
		// filter 계속 진행
		chain.doFilter(req, res);
	}
}
