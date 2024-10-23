package com.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.model.Customer;

public class CustomeRegister extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmPassword");
		String email = request.getParameter("emial");
		System.out.println(name+" "+username+" "+password+" "+confirmpassword+" "+email);
	if(password.equals(confirmpassword)) {
		
		
		Customer c = new Customer(name, username,password,email);
		try {
			int r = c.customerRegister();
			if(r==1) {
				response.sendRedirect("/car-service-system/customerRegistersuc.jsp");
			}else {
				response.sendRedirect("/car-service-system/customerRegisterfail.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else {
		response.sendRedirect("/car-service-system/passworderror.html");
	}
}}
