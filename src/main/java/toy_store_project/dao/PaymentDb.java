package toy_store_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toy_store_project.dto.Vendor;

public class PaymentDb {
	static int balance;
	static int cost1=0;
	static int id;
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/toy?createDatabaseIfNotExist=true","root","Mani");
	}
	public void createPaymentTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists Payment(id int auto_increment primary key,bill int ,cu_id int)");
	}
	public void savePayment(String email) throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps1=con.prepareStatement("select cost from Cart2 where email=?");
		PreparedStatement ps2=con.prepareStatement("select id,wallet from customer where email=?");
		PreparedStatement ps=con.prepareStatement("insert into Payment(bill,cu_id) values(?,?)");
		ps1.setString(1, email);
		ResultSet r=ps1.executeQuery();
		while(r.next())
		{
			cost1=cost1+r.getInt("cost");
		}
		ps.setInt(1,cost1);
		ps2.setString(1, email);
	    ResultSet r1=ps2.executeQuery();
		while(r1.next())
		{
			ps.setInt(2,r1.getInt("id"));
			id=r1.getInt("id");
			if(cost1<r1.getInt("wallet"))
			{
				balance=r1.getInt("wallet")-cost1;

			}
			else
			{
				System.out.println("-----you have not enough balance----");
			}
			
		}
		PreparedStatement ps3=con.prepareStatement(" update customer set wallet=? where id=?");
		ps3.setInt(1, balance);
		ps3.setInt(2, id);
		int n1=ps.executeUpdate();
		int n=ps3.executeUpdate();
		if(n1>0 && n>0)
		{
			System.out.println("---payment successfull----");
		}
		
		
	}

}
