package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;//careful



public class DatabaseConnection {

	public static void main(String[] args) throws SQLException {
		// Step1:we should create object for the driver and register the driver
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Step2 get connection
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33", "root","root");
		
		//step3 get statement
		Statement statement = connection.createStatement();
		
		//execute query and  to fetch data(dql)
		ResultSet result = statement.executeQuery("select* from sdet33");//execute query abstrct method
		
		while(result.next())//to check next data is there or not
		{
			System.out.println(result.getString(1));//id-1 and address-2
		}
		//to store data and do modification(dml,ddl)
		//int res = statement.executeUpdate("");
		
		connection.close();//if so many tabs opened only frst close statement then connection,else just connection
		
		//ultimately we ve to close connection
		
		
        
	}

}
