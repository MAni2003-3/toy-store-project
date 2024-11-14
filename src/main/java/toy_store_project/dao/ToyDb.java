package toy_store_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import toy_store_project.dto.Shop;
import toy_store_project.dto.Toy;
import toy_store_project.dto.Vendor;

public class ToyDb {
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy?createDatabaseIfNotExist=true","root","Mani");
		
	}
	public void createToyTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists Toy(id int auto_increment primary key,cost int,quantity int,brand varchar(45),type varchar(45),color varchar(45))");
	}
	public int saveToy(Toy t) throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("insert into Toy(cost,quantity,brand,type,color) values(?,?,?,?,?)");
		ps.setInt(1,t.getCost());
		ps.setInt(2, t.getQuantity());
		ps.setString(3, t.getBrand());
		ps.setString(4, t.getType());
		ps.setString(5, t.getColor());
		return ps.executeUpdate();
		
	}
	public int toyUpdate(Toy t) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("update Toy set cost=?,quantity=?,type=?,color=? where brand=?"); 
		ps.setInt(1,t.getCost());
		ps.setInt(2,t.getQuantity());
		ps.setString(3, t.getType());
		ps.setString(4,t.getColor());
		ps.setString(5,t.getBrand());
		return ps.executeUpdate();
		
		
	}
	public int toyDelete(Toy t) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from Toy where brand=?"); 
		ps.setString(1, t.getBrand());
		return ps.executeUpdate();
		
	}
	public void toyInfo(Toy t) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from Toy where brand=?"); 
		ps.setString(1, t.getBrand());
		ResultSet r=ps.executeQuery();
		boolean b=false;
		while(r.next())
		{
			System.out.println(r.getInt("id")+" "+r.getInt("cost")+" "+r.getInt("quantity")+" "+r.getString("brand")+" "+r.getString("type")+" "+r.getString("color"));
			System.out.println("---okay----");
			b=true;
		}
		if(b==false)
		{
			System.out.println("check once something went wrong");
		}
		
	}
	public void browserToy() throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from Toy "); 
		ResultSet r=ps.executeQuery();
		if(r.next()==false)
		{
			System.out.println("no toys is there");
		}
		else {
			while(r.next())
			{
				System.out.println(r.getInt("id")+" "+r.getInt("cost")+" "+r.getInt("quantity")+" "+r.getString("brand")+" "+r.getString("type")+" "+r.getString("color"));
				System.out.println("---okay----");
			}
		}
	}
	public void addToy(int id,String cemail) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from Toy where id=?"); 
		ps.setInt(1, id);
		ResultSet r=ps.executeQuery();
		while(r.next())
		{
			cartToy(r.getInt("id"),r.getInt("cost"),r.getInt("quantity"),r.getString("brand"),r.getString("type"),r.getString("color"),cemail);
			
		}
	}
	public void createCartTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists Cart2(id int primary key,cost int,quantity int,brand varchar(45),type varchar(45),color varchar(45),email varchar(45))");
	}
	public void cartToy(int id,int cost,int quantity,String brand,String type,String color,String email) throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("insert into Cart2(id,cost,quantity,brand,type,color,email) values(?,?,?,?,?,?,?)");
		ps.setInt(1,id);
		ps.setInt(2, cost);
		ps.setInt(3,quantity);
		ps.setString(4, brand);
		ps.setString(5, type);
		ps.setString(6,color);
		ps.setString(7, email);
		int n=ps.executeUpdate();
		if(n>0)
		{
			System.out.println(" add to cart successfully");
			
		}
		else
		{
			System.out.println("----no one toy is added to cart----give correct id");
		}
		
		
	}
	public void CartDelete(String email) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from Cart2 where email=?"); 
		ps.setString(1, email);
	    int n=ps.executeUpdate();
	    if(n>0)
	    {
	    	System.out.println("---removed cart successfully-----");
	    }
	    else
	    {
	    	System.out.println("---not removed-----");
	    	
	    }
		
	}
	

}
