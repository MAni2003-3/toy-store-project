package toy_store_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toy_store_project.dto.Customer;
import toy_store_project.dto.Vendor;

public class CustomerDb {
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy?createDatabaseIfNotExist=true","root","Mani");
	}
	public void createCustomerTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists Customer(id int auto_increment primary key,email varchar(45) unique,pwd varchar(45),wallet varchar(45))");
	}
	public int saveCustomer(Customer c) throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("insert into Customer(email,pwd,wallet) values(?,?,?)");
		ps.setString(1, c.getEmail());
		ps.setString(2, c.getPwd());
		ps.setInt(3, c.getWallet());
		return ps.executeUpdate();
		
	}
	public boolean login(Customer c) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select email,pwd from Customer where email=?"); 
		ps.setString(1,c.getEmail());
		ResultSet r=ps.executeQuery();
		boolean b=false;
		while(r.next())
		{
			if(r.getString("email").equalsIgnoreCase(c.getEmail())&& r.getString("pwd").equalsIgnoreCase(c.getPwd()))
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
	public int customerUpdate(Customer c) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("update Customer set pwd=? where email=?"); 
		ps.setString(1,c.getPwd());
		ps.setString(2, c.getEmail());
		return ps.executeUpdate();
		
		
	}
	public int customerDelete(Customer c) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from Customer where email=?"); 
		ps.setString(1, c.getEmail());
		return ps.executeUpdate();
		
	}
	public void customerProfile(Customer c) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from Customer where email=?"); 
		ps.setString(1, c.getEmail());
		ResultSet r=ps.executeQuery();
		boolean b=false;
		while(r.next())
		{
			System.out.println(r.getInt("id")+" "+r.getString("email")+" "+r.getString("pwd")+" "+r.getInt("wallet"));
			System.out.println("---okay----");
			b=true;
		}
		if(b==false)
		{
			System.out.println("check once something went wrong");
		}
		
	}


}
