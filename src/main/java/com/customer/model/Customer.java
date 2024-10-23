package com.customer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	String name;
	String username;
	String password;
	String email;
	Connection con = null;
	public Customer(String name, String usernmae, String password, String email) {
		super();
		this.name = name;
		this.username = usernmae;
		this.password = password;
		this.email = email;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String usernmae) {
		this.username = usernmae;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", usernmae=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int customerRegister() throws Exception{
		String s = "insert into customer values(?,?,?,?)";
		 PreparedStatement pstmt = con.prepareStatement(s);
		 pstmt.setString(1, name);
		 pstmt.setString(2, username);
		 pstmt.setString(3, password);
		 pstmt.setString(4, email);
		 int row = pstmt.executeUpdate();
		 return row;
	}	
	public int customerLogin() throws Exception {
		String s = "select * from customer where username=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		pstmt.setString(1, username);
		ResultSet res = pstmt.executeQuery();
		if(res.next()) {
			String s1 = "select * from customer where username=? and password=?";
			PreparedStatement pstmt1 = con.prepareStatement(s1);
			pstmt1.setString(1, username);
			pstmt1.setString(2, password);
			ResultSet res1 = pstmt.executeQuery();
			if(res1.next()) //or password.equals(res.
			{
				name = res1.getString(1);
				return 1;// both user name 
			}else {
				return 0;
			}
		}else {
			return -1;//invalid user name.
		}	
	}	
	
}
