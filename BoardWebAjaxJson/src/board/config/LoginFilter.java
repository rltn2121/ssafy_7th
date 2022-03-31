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

// Project 별로 처리됨. ( context path 를 /BoardWebAjaxJson / 두가지 모두 테스트  WebBasic 요청 시 이 필터는 적용되지 않음 )
// 가끔  다른 Project 에 적용되는 현상 확인 하자!
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

		// exclude
		// /html/
		// /img/
		// /login
		if( ! path.contains("/img/") && ! path.contains("/css/") && ! path.contains("/js/") && ! path.contains("/register") && ! path.contains("/login") ) {
			UserDto userDto = (UserDto) session.getAttribute("userDto");

			if(userDto == null) {
				httpServletResponse.sendRedirect(contextPath + "/jsp/login.jsp");
				return;
			}
		}

		chain.doFilter(req, res);
	}

}
