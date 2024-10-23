package com.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.model.Car;

public class Insercardetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Corrected to use getParameter() instead of getAttribute()
		String carModel = request.getParameter("carModel");
		String carType = request.getParameter("carType");
		String carRegistationNumber = request.getParameter("carRegistationNumber");

		Car car = new Car();
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("susername");
		
		// Setting values in the Car object
		car.setUsername(username);
		car.setCar_model(carModel);
		car.setCar_type(carType);
		car.setCar_regis_number(carRegistationNumber);

		// Insert the car data
		int res = car.insetcardata();

		// Redirect based on result
		if(res == 1) {
			response.sendRedirect("/car-service-system/customerRegistersuc.jsp");
		} else {
			response.sendRedirect("/car-service-system/customerRegisterfail.jsp");
		}
	}
}
