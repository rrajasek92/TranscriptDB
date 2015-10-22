package transcript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class transcriptDB {
	public static void updateInfo(String StudentID, String CourseID, Integer credits, String grade) 
	{ 
		try 
	{ 
	//URL of Oracle database server 
			String url = "jdbc:oracle:thin:system/password@localhost"; 
	 
			//properties for creating connection to Oracle database 
			Properties props = new Properties(); 
			props.setProperty("user", "TestUserDB"); 
			props.setProperty("password", "password"); 
	 
	 //creating connection to Oracle database using JDBC 
			Connection conn = DriverManager.getConnection(url,props); 
	 
			String sql ="insert into gradeRecord (StudentID, CourseID, Credits, Grade) Values ('"+StudentID+"', '"+CourseID+"', "+credits+", '"+grade+"')";
	 
	 //creating PreparedStatement object to execute query 
			PreparedStatement preStatement = conn.prepareStatement(sql); 
	 
			ResultSet result = preStatement.executeQuery(); 
			
		System.out.println(); 
		//while(result.next()){ 
		//	System.out.println("Customer number: " + result.getString("customerid") + "\n " + result.getString("title") + " " + result.getString("fullname") + "\n" + result.getString("streetaddress") + "\n" + result.getString("city") + " " + result.getString("state") + " " + result.getString("zipcode") + "\n" + result.getString("emailaddress") + "\n" + result.getString("position") +" at " + result.getString("company"));
		//	System.out.println(); 
		//} 
		conn.close(); 
		}catch(SQLException e) 
		{ 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		}}
	public static void retrieveInfo(String StudentID, String CourseID, Integer credits, String grade) 
	{ 
		try 
	{ 
	//URL of Oracle database server 
			String url = "jdbc:oracle:thin:system/password@localhost"; 
	 
			//properties for creating connection to Oracle database 
			Properties props = new Properties(); 
			props.setProperty("user", "TestUserDB"); 
			props.setProperty("password", "password"); 
	 
	 //creating connection to Oracle database using JDBC 
			Connection conn = DriverManager.getConnection(url,props); 
	 
			String sql ="select credits, grades from graderecord where studentid='"+StudentID+"'";
	 
	 //creating PreparedStatement object to execute query 
			PreparedStatement preStatement = conn.prepareStatement(sql); 
	 
			ResultSet result = preStatement.executeQuery(); 
			
		System.out.println(); 
		//while(result.next()){ 
		//	System.out.println("Customer number: " + result.getString("customerid") + "\n " + result.getString("title") + " " + result.getString("fullname") + "\n" + result.getString("streetaddress") + "\n" + result.getString("city") + " " + result.getString("state") + " " + result.getString("zipcode") + "\n" + result.getString("emailaddress") + "\n" + result.getString("position") +" at " + result.getString("company"));
		//	System.out.println(); 
		//} 
		conn.close(); 
		}catch(SQLException e) 
		{ 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		}}
}
