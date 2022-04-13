package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SqlexceptionandHandle {
	
	    
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		// Step1:we should create object for the driver and register the driver
		
		Connection connection=null;//global variable declare
		    
		
		try {
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				
				//Step2 get connection
				
				 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33", "root","root");
				
				//step3 get statement
				Statement statement = connection.createStatement();
				
				//execute query and  to fetch data(dql)
				ResultSet result = statement.executeQuery("select* from sdet;");//execute query abstrct method
				
				while(result.next())//to check next data is there or not
				{
					System.out.println(result.getString(1));//id-1 and address-2
				}
				//to store data and do modification(dml,ddl)
				//int res = statement.executeUpdate("");
				
				connection.close();
		}
				
				
				finally {
					//to close connection if exception is also there
					connection.close();
					System.out.println("connection is closed");
				}
				
				

	
	}
}
