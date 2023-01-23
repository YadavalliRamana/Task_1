package StudentDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	 public static void main(String[] args)
	    {
			Scanner sc = new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/demo";
			String user ="root";
			String password = "Ramana@2000";
			String query = "insert into studentdetails values(?,?,?,?)";
			
			Connection connect;
			PreparedStatement ps;
			try 
			{
				connect=DriverManager.getConnection(url,user,password);
				ps=connect.prepareStatement(query);
			    System.out.println("Enter Student Id : ");
			    ps.setInt(1, sc.nextInt());
			    System.out.println("Enter Student Name : ");
			    ps.setString(2, sc.next());
			    System.out.println("Enter Student Marks : ");
			    int marks = sc.nextInt();
			    ps.setInt(3,marks);
			    double prce = ((marks*0.01)*100);
			    ps.setDouble(4, prce);
			    int res = ps.executeUpdate();
			    
			    if(res>0)
			    {
			    	System.out.println("Student Details Added...!!!");
			    }
			    else
			    {
			    	System.out.println("Invalid Details...!!!");
			    }
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
	 

}
