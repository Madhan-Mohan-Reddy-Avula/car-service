package com.customer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Car {
	 String username;
	 String car_model;
	 String car_type;
	 String car_regis_number;
	 String service_request;
	 String service_status;
	 Connection con;
	public Car() {
		super();
	}
	public Car(String username, String car_model, String car_type, String car_regis_number, String service_request,
			String service_status) {
		super();
		this.username = username;
		this.car_model = car_model;
		this.car_type = car_type;
		this.car_regis_number = car_regis_number;
		this.service_request = service_request;
		this.service_status = service_status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_regis_number() {
		return car_regis_number;
	}
	public void setCar_regis_number(String car_regis_number) {
		this.car_regis_number = car_regis_number;
	}
	public String getService_request() {
		return service_request;
	}
	public void setService_request(String service_request) {
		this.service_request = service_request;
	}
	public String getService_status() {
		return service_status;
	}
	public void setService_status(String service_status) {
		this.service_status = service_status;
	}
	@Override
	public String toString() {
		return "Car [username=" + username + ", car_model=" + car_model + ", car_type=" + car_type
				+ ", car_regis_number=" + car_regis_number + ", service_request=" + service_request
				+ ", service_status=" + service_status + "]";
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int insetcardata() {
		try {
			String s= "insert into car values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, car_model);
			pstmt.setString(3, car_type);
			pstmt.setString(4, car_regis_number);
			pstmt.setString(5, "null");
			pstmt.setString(6, "null");
			
			int res = pstmt.executeUpdate();
			if(res == 1) {
				return 1;
			}else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
