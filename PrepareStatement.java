package preparestate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatement {
	
	//Create Table
	public void createTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","root");
		
		PreparedStatement ps = c.prepareStatement("Create table Employee(id int, name varchar(30), Age int )");
		System.out.println("Table Created Succesfully....");
		
		ps.execute();
		c.close();
	}
	
	//Insert Data
	public void insertData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","root");
		
		 PreparedStatement ps =c.prepareStatement("insert into Employee values(?, ?, ?)");
		 ps.setInt(1, 5);
		 ps.setString(2, "rushikesh");
		 ps.setInt(3, 24);
		 
		 System.out.println("Data inserted Succesfully...");
		 
		 ps.executeUpdate();
		 c.close();
	}
	
	//Update Data
	public void updateData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","root");
		
		PreparedStatement ps = c.prepareStatement("Update Employee set name = ? where id = ?");
		ps.setString(1, "Karan");
		ps.setInt(2, 5);
		
		System.out.println("Data Updated Sucessfully.....");
		
		ps.executeUpdate();
		c.close();
	}
	
	//Delete Data
	public void deleteData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","root");
		
		PreparedStatement ps = c.prepareStatement("delete from Employee where id = ?");
		ps.setInt(1, 5);
		System.out.println("Data deleted succesfully....");
		
		ps.executeUpdate();
		c.close();
		
	}
	
	//Fetch Data
	public void fetchData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197","root","root");
		
		PreparedStatement ps = c.prepareStatement("select * from Employee");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt(1) + "  Name:  " + rs.getString(2) + "  Age:  " + rs.getInt(3));
			
		}
		
	}
}
