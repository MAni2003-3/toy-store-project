package toy_store_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toy_store_project.dto.Shop;
import toy_store_project.dto.Vendor;

public class ShopDb {
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy?createDatabaseIfNotExist=true","root","Mani");
		
	}
	public void createShopTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists Shop(id int auto_increment primary key,name varchar(45),Vemail varchar(45) ,address varchar(45))");
	}
	public int saveShop(Shop s) throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("insert into Shop(name,Vemail,address) values(?,?,?)");
		ps.setString(1,s.getName() );
		ps.setString(2, s.getVendorEmail());
		ps.setString(3, s.getAddress());
		return ps.executeUpdate();
		
	}
	public int shopUpdate(Shop s) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("update Shop set name=?,address=? where vemail=?"); 
		ps.setString(1,s.getName());
		ps.setString(2, s.getAddress());
		ps.setString(3, s.getVendorEmail());
		return ps.executeUpdate();
		
		
	}
	public int shopDelete(Shop s) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from Shop where vemail=?"); 
		ps.setString(1, s.getVendorEmail());
		return ps.executeUpdate();
		
	}
	public void shopInfo(Shop s) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from Shop where vemail=?"); 
		ps.setString(1, s.getVendorEmail());
		ResultSet r=ps.executeQuery();
		boolean b=false;
		while(r.next())
		{
			System.out.println(r.getInt("id")+" "+r.getString("name")+" "+r.getString("address")+" "+r.getString("vemail"));
			System.out.println("---okay----");
			b=true;
		}
		if(b==false)
		{
			System.out.println("check once something went wrong");
		}
		
	}

}
