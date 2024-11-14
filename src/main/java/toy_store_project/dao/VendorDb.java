package toy_store_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toy_store_project.dto.Vendor;

public class VendorDb {
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy?createDatabaseIfNotExist=true","root","Mani");
	}
	public void createVendorTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists Vendor(id int auto_increment primary key,email varchar(45) unique,pwd varchar(45))");
	}
	public int saveVendor(Vendor v) throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("insert into Vendor(email,pwd) values(?,?)");
		ps.setString(1, v.getEmail());
		ps.setString(2, v.getPwd());
		return ps.executeUpdate();
		
	}
	public boolean login(Vendor v) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select email,pwd from Vendor where email=?"); 
		ps.setString(1,v.getEmail());
		ResultSet r=ps.executeQuery();
		boolean b=false;
		while(r.next())
		{
			if(r.getString("email").equalsIgnoreCase(v.getEmail())&& r.getString("pwd").equalsIgnoreCase(v.getPwd()))
			{
				b=true;
			}
			
		}
		if(b)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public int VendorUpdate1(Vendor v) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("update Vendor set pwd=? where email=?"); 
		ps.setString(1,v.getPwd());
		ps.setString(2, v.getEmail());
		return ps.executeUpdate();
		
		
	}
	public int VendorDelete1(Vendor v) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from Vendor where email=?"); 
		ps.setString(1, v.getEmail());
		return ps.executeUpdate();
		
	}
	public void vendorProfile1(Vendor v) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from Vendor where email=?"); 
		ps.setString(1, v.getEmail());
		ResultSet r=ps.executeQuery();
		boolean b=false;
		while(r.next())
		{
			System.out.println(r.getInt("id")+" "+r.getString("email")+" "+r.getString("pwd"));
			System.out.println("---okay----");
			b=true;
		}
		if(b==false)
		{
			System.out.println("check once something went wrong");
		}
		
	}
}
