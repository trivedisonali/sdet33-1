package com.crm.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class DataBaseUtility {
	/**
	 * This class contains all generic methods of Database
	 * @param args
	 */

	    static Connection connection;
	    static ArrayList<String> list=new ArrayList<String>();
	    /**
	     * This method is used to establish connection to MySQL database
	     * @param dbUrl
	     * @param dbUsername
	     * @param dbPassword
	     * @throws SQLException 
	     */
	    public static void getMySqlDatabaseConnection(String dbUrl,String dbUsername,String dbPassword) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}
	    
	    /**
	     * This method used to fetch data from database based on column number
	     * @param query
	     * @param columnName
	     * @return
	     * @throws SQLException 
	     */
	    public static ArrayList<String> getDataFromDatabase(String query,int columnNumber) throws SQLException{
	    Statement statement = connection.createStatement();
	    ResultSet result = statement.executeQuery(query);
	    
	    while(result.next()) {
	    	
			list.add(result.getString(columnNumber));
	    }
	    statement.close();
	    return list;
	    }
	    
	    /**
	     * This method used to fetch data from database based on column name
	     * @param query
	     * @throws SQLException
	     */
	    
	   /* public static ArrayList<String> updateDataIntoDatabase(String query,String columnNameOrcolumnNumber ) throws SQLException {
	    	String num="";
	    	for (int i = 0; i < columnNameOrcolumnNumber.length(); i++) {//IF WE GIVE STRING IT WILL TAKE DATA IN LAST COLUMN ONLY,THATY USED LIST
				char ch=columnNameOrcolumnNumber.charAt(i);
				if(Character.isDigit(ch)) {
					num=num+columnNameOrcolumnNumber.charAt(i);
			}
				else {
					break;
				}
	    	
	    	Statement statement = connection.createStatement();
	    	statement.executeUpdate(query);
	    	
	    	int columnNumber=0;
	    	String columnName=null;
	    	if(num.equalsIgnoreCase(columnNameOrcolumnNumber))
	    	{
	    		columnNumber=Integer.parseInt(num);
	    		while(Result.next()) {
	    			list.add(result.getString(columnNumber));
	    		}
	    	}
	    	else {
	    		columnName=columnNameOrcolumnNumber;
	    		while(result.next())
	    		{
	    			list.add(result.getString(columnName));
	    			
	    		}
	    	}
	    	
	    
	    	statement.close();
	    	return list;
	    	
	}
	    	
	    public static void updateDataIntoDatabase(String query)	{
	    	Statement statement = connection.createStatement();
	    	statement.executeUpdate(query);
	    	System.out.println("Query executed successfully");
	    	statement.close();
	    }*/
	    	
	    	
	    /**
	     * 
	     * @throws SQLException
	     */
	    
	    public static void closeDatabaseConnection() throws SQLException {
	    	connection.close();
	    }
	    
	    /**
	     * 
	     * @param query
	     * @param columnName
	     * @param expData
	     * 
	     */
	   /* public static boolean verifyData(String query,String columnNameOrcolumnNumber,String expData) {
	    	ArrayList<String> listdata = getDataFromDatabase(query,columnNameOrcolumnNumber);
	    	boolean flag=false;
	    	for(String data:listData) {//TO ITERATE LOOP
	    	if(data.equalsIgnoreCase(expData)) {//TRUE--->HAVE DATA,FALSE--->NO DATA
	    		flag=true;
	    		break;
	    	}
	    }
          return flag;*/
}

