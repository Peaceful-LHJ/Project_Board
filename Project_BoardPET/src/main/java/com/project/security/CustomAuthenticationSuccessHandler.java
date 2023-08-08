package com.project.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("로그인 성공");
		String name = authentication.getName();
		log.info("getName() : " + name);
		log.info(authentication.getDetails());
		authentication.getAuthorities().forEach(auth -> {
			log.info(auth);
		});
		
		// 요청한 페이지
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		if(savedRequest != null) {
			response.sendRedirect(savedRequest.getRedirectUrl());
			return;
		}
		
		// 이전에 보던 페이지
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		if(prevPage != null) {
			request.getSession().removeAttribute("prevPage");
			response.sendRedirect(prevPage);
			return;
		}
		
		response.sendRedirect(request.getContextPath());
	}
	
}
