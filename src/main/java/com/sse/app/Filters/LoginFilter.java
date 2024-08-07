package com.sse.app.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("member");

		if (obj != null) {

			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
//			1.forward
			request.setAttribute("result", "로그인이 필요한 항목입니다.");
			request.setAttribute("url", "/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);

//			2.redirect
//			HttpServletResponse res = (HttpServletResponse) response;
//			res.sendRedirect("/member/login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
