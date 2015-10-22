package transcript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class transcriptDB {
	public static int cr=0,rown=0;
	public static String gd="";
	public static ResultSet result;
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
		//conn.close(); 
		}catch(SQLException e) 
		{ 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		}}
	public static void updateStudentRec(String StudentID, Double gpa) 
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
	 
			String sql ="insert into studentRecord (StudentID, GPA) Values ('"+StudentID+"', '"+gpa+"')";
	 
	 //creating PreparedStatement object to execute query 
			PreparedStatement preStatement = conn.prepareStatement(sql); 
	 
			ResultSet result = preStatement.executeQuery(); 
			
		System.out.println(); 
		//while(result.next()){ 
		//	System.out.println("Customer number: " + result.getString("customerid") + "\n " + result.getString("title") + " " + result.getString("fullname") + "\n" + result.getString("streetaddress") + "\n" + result.getString("city") + " " + result.getString("state") + " " + result.getString("zipcode") + "\n" + result.getString("emailaddress") + "\n" + result.getString("position") +" at " + result.getString("company"));
		//	System.out.println(); 
		//} 
		//conn.close(); 
		}catch(SQLException e) 
		{ 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		}}
	public static void retrieveInfo(String StudentID) 
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
	 
			String sql ="select credits, grade,rownumber from graderecord where studentid='"+StudentID+"'";
						
			
	 //creating PreparedStatement object to execute query 
			PreparedStatement preStatement = conn.prepareStatement(sql); 
	 
			result = preStatement.executeQuery();
			
		 
		//while(result.next()){ 
		//	System.out.println("Customer number: " + result.getString("customerid") + "\n " + result.getString("title") + " " + result.getString("fullname") + "\n" + result.getString("streetaddress") + "\n" + result.getString("city") + " " + result.getString("state") + " " + result.getString("zipcode") + "\n" + result.getString("emailaddress") + "\n" + result.getString("position") +" at " + result.getString("company"));
		//	System.out.println(); 
		//} 
		//conn.close(); 
		}catch(SQLException e) 
		{ 
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		}}
public static double studentGPA(String studentID){
		double q=0,c=0,gpa=0;
		int l=0;
		retrieveInfo(studentID);
		try {
//			rown=result.getInt("Rownumber");
			while(result.next()){
			cr=result.getInt("Credits");
			gd=result.getString("Grade");
			double g=Transcript.gp(gd);
			q+=g*cr;
			c+=cr;
			}
			gpa=q/c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gpa;
	}
}
