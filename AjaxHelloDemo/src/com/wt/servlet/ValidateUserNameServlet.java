package com.wt.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateUserName")
public class ValidateUserNameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<String> userNames = Arrays.asList("AAA", "BBB", "CCC");
		
		String username = request.getParameter("username");
		String result = null;
		
		System.out.println("username " + username);
		
		if(userNames.contains(username)){
			result = "<font color='red'>该用户名已经被使用</font>";
		}
		else{
			result = "<font color='green'>该用户名可以使用</font>";
		}
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		
	}

}
