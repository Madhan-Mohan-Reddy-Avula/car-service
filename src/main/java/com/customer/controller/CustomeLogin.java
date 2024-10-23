package com.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.model.Customer;

public class CustomeLogin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer c = new Customer();
		c.setUsername(username);
		c.setPassword(password);
		username = c.getUsername();
	
		try {
			int r = c.customerLogin();
			if(r == 1) {
				String name = c.getName();
				HttpSession session = request.getSession(true);
				session.setAttribute("susername", username);
				response.sendRedirect("/car-service-system/customerloginsuc.jsp");
			}else if(r==-1) {
				response.sendRedirect("/car-service-system/customerusernameerror.jsp");
			}else {
				response.sendRedirect("/car-service-system/customerpassworderror.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
}
