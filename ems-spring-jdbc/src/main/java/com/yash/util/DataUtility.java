package com.yash.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataUtility {
	@Bean
	public static Connection connect() throws Exception{
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb?autoReconnect=true&useSSL=false", "root", "root");
	      return con;      
	    }
}
