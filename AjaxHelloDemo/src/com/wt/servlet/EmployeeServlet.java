package com.wt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.beans.Location;
import com.wt.dao.impl.BaseDaoImpl;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private BaseDaoImpl baseDaoImpl = new BaseDaoImpl();
	
	protected void listLocations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sql = "SELECT location_id, city FROM Location";
		
		List<Location> locations = baseDaoImpl.getForList(sql);
		
		request.setAttribute("locations", locations);
		
		request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
	}
}
