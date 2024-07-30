package com.sse.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sse.app.boards.BoardDTO;
import com.sse.app.members.MemberDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		String method = request.getMethod();
		
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		
		Map<String, Object> map =modelAndView.getModel();
		Iterator<String> it =map.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		BoardDTO boardDTO = (BoardDTO) map.get("dto");
		if(!boardDTO.getBoardWriter().equals(memberDTO.getMember_id())) {
			modelAndView.addObject("result", "작성자만 수정 할 수 있습니다");
			modelAndView.addObject("url", "/");
			modelAndView.setViewName("commons/message");
			//modelAndView.setViewName("redirect:/");
		}
		
	}
	
}
