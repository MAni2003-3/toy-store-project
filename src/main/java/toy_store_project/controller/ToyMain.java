package toy_store_project.controller;

import java.sql.SQLException;
import java.util.Scanner;

import toy_store_project.dao.CustomerDb;
import toy_store_project.dao.PaymentDb;
import toy_store_project.dao.ShopDb;
import toy_store_project.dao.ToyDb;
import toy_store_project.dao.VendorDb;
import toy_store_project.dto.Customer;
import toy_store_project.dto.Shop;
import toy_store_project.dto.Toy;
import toy_store_project.dto.Vendor;

public class ToyMain {
	static VendorDb vd=new VendorDb();
	static ShopDb sd=new ShopDb();
	static ToyDb td=new ToyDb();
	static CustomerDb cd=new CustomerDb();
	static PaymentDb pd=new PaymentDb();
	static Scanner s=new Scanner(System.in);
	static String vemail;
	static String cemail;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		vd.createVendorTable();
		sd.createShopTable();
		td.createToyTable();
		cd.createCustomerTable();
		td.createCartTable();
		pd.createPaymentTable();
		System.out.println("--------WELCOME TO TOY STORE---------");
		boolean haa=true;
		while(haa)
		{
			System.out.println("enter your option \n 1.Vendor\n 2.Customer\n 3.Exit  ");
			int ch=s.nextInt();
			switch(ch) 
			{
			case 1:{
				   boolean haa1=true;
				   while(haa1) {
	
						System.out.println(" select one in below \n 1.Register \n 2.Login \n 3.Exit");
						int ch1=s.nextInt();
						switch(ch1) 
						{
							case 1:{
								createVendor();
								
							
							}	
							break;
							case 2:{
								      boolean b=vendorLogin();
								      if(b) {
								    	  System.out.println("successfully login---------");
								    	  boolean haa2=true;
								           while(haa2) {
							
												System.out.println(" select one in below \n 1.Shop \n 2.Profile \n 3.Exit");
												int ch2=s.nextInt();
												switch(ch2) 
												{
													case 1:{
														 boolean haa4=true;
												           while(haa4) {
											
																System.out.println(" select one in below \n 1.createShop \n 2.updateShop \n 3.DeleteShop \n 4.fetchShop \n 5.craeteToy \n 6.updateToy \n 7.deleteToy \n 8.FetchToy \n 9.Exit");
																int ch4=s.nextInt();
																switch(ch4) 
																{
																	case 1:{
																		createShop();
																		
																		
																	}
																	break;
																	case 2:{
																		ShopUpdate();
																		
																		
																	
																	}
																	break;
																	case 3:{
																		shopDelete();
																	
																																
																	}
																	break;
																	case 4:{
																		shopInfo();
																	
																	}
																	break;
                                                                    case 5:{
                                                            			createToy();
																		
																	}
																	break;
																	case 6:{
																		ToyUpdate();
																		
																		
																	
																	}
																	break;
																	case 7:{
																		toyDelete();
																	
																																
																	}
																	break;
																	case 8:{
																		toyInfo();
																	
																	}
																	break;
																	case 9:{
																		haa4=false;
																		
																	}
																	break;
																	default :{
																		System.out.println("your enter wrong option");
																	
																}
															  }
														   }
														
													}
													break;
													case 2:{
														 boolean haa3=true;
												           while(haa3) {
											
																System.out.println(" select one in below \n 1.Update \n 2.Delete \n 3.Profile \n 4.Exit");
																int ch3=s.nextInt();
																switch(ch3) 
																{
																	case 1:{
																		vendorUpdate( vemail);
																		
																	}
																	break;
																	case 2:{
																		VendorDelete(vemail);
																		
																	
																	}
																	break;
																	case 3:{
																		VendorProfile(vemail);
																																
																	}
																	break;
																	case 4:{
																		haa3=false;
																	}
																	break;
																	default :{
																		System.out.println("your enter wrong option");
																	
																}
															  }
														   }
														
													
													}
													break;
													case 3:{
														haa2=false;														
													}
													break;
													default :{
														System.out.println("your enter wrong option");
													
												}
											  }
										   }
								    	  
								    	  
								      }
								      else
								      {
								    	  System.out.println("wrong email or pwd try Again-----");
								    	  vendorLogin();
							    	  
								      }
						
								
								
								
							}
							break;
							case 3:{
								haa1=false;
								
							}
							break;
							default :{
								System.out.println("your enter wrong option");
							
						}
					  }
				   }
					
					
			}
			break;
			case 2:{
				 boolean haa5=true;
		           while(haa5) {
	
						System.out.println(" select one in below \n 1.Register \n 2.Login \n 3.Exit");
						int ch5=s.nextInt();
						switch(ch5) 
						{
							case 1:{
								createCustomer();
					
								
							}
							break;
							case 2:{
								 boolean b=customerLogin();
							      if(b) 
							      {
							    	  System.out.println("successfully login---------");
							    	  boolean haa6=true;
							           while(haa6) {
						
											System.out.println(" select one in below \n 1.Shopping \n 2.Profile  \n 3.Exit");
											int ch6=s.nextInt();
											switch(ch6) 
											{
												case 1:{
													 boolean haa8=true;
											           while(haa8) {
										
															System.out.println(" select one in below \n 1.Browser Toys \n 2.RemoveCart/bucket cart \n 3.Pyment \n 4.Exit");
															int ch8=s.nextInt();
															switch(ch8) 
															{
																case 1:{
																	  td.browserToy();
																	     boolean haa9=true;
																	     while(haa9) {
																	    	 System.out.println(" select one in below \n 1.AddCart \n 2.Exit");
																	    	 int ch9=s.nextInt();
																	    	 switch(ch9)
																	    	 {
																	    	 case 1:{
																	    		 System.out.println("enetr id for you add");
																	    		 int id=s.nextInt();
																	    		 td.addToy(id,cemail);
																	    		 
																	    	 }
																	    	 break;
																	    	 case 2:{
																	    		 haa9=false;
																	    		 
																	    	 }
																	    	 break;
																	    	 default :{
																					System.out.println("your enter wrong option");
																				
																			}
																	    	 
																	    	 }
																	    	 
																	     }
																	
																	
																}
																break;
																case 2:{
																	td.CartDelete(cemail);
																	
																	
																
																}
																break;
																case 3:{
																	pd.savePayment(cemail);
																	
																															
																}
																break;
																case 4:{
																	haa8=false;
																}
																break;
																default :{
																	System.out.println("your enter wrong option");
																
															}
														  }
													   }
													
											
													
												}
												break;
												case 2:{
													 boolean haa7=true;
											           while(haa7) {
										
															System.out.println(" select one in below \n 1.Update \n 2.Delete \n 3.Profile \n 4.Exit");
															int ch7=s.nextInt();
															switch(ch7) 
															{
																case 1:{
																	customerUpdate( cemail);
																	
																}
																break;
																case 2:{
																	customerDelete(cemail);
																	
																
																}
																break;
																case 3:{
																	customerProfile(cemail);
																															
																}
																break;
																case 4:{
																	haa7=false;
																}
																break;
																default :{
																	System.out.println("your enter wrong option");
																
															}
														  }
													   }
											
													
												
												}
												break;
								
												case 3:{
													haa6=false;
												}
												break;
												default :{
													System.out.println("your enter wrong option");
												
											}
										  }
									   }
									
								
							    	  
							       }
							      else
							      {
							    	  System.out.println("wrong email or pwd try Again-----");
							    	  customerLogin();
							    	  
							      }
							
								
							
							}
							break;
							case 3:{
								haa5=false;
							}
							break;
							default :{
								System.out.println("your enter wrong option");
							
						}
					  }
				   }
				
				
			}
			break;
			case 3:{
				haa=false;
				
			}
			break;
			default :{
				System.out.println("your enter wrong option");
				
			}

			}
		}
		
	}
	private static void createVendor() throws  SQLException, ClassNotFoundException
	{
		
		System.out.println("enter email");
		String email=s.next();
		System.out.println("enter pwd");
		String pwd=s.next();
		Vendor v=new Vendor(email,pwd);
		try {
			int res=vd.saveVendor(v);
			if(res>0)
			{
				System.out.println("profile is created");
			}
		
		} catch (SQLException e) {
			System.err.println("your enter data is already exist");
			createVendor();
			
			
		}
		
	}
	private static boolean vendorLogin() throws ClassNotFoundException, SQLException
	{
		System.out.println("enter email");
		String email=s.next();
		System.out.println("enter pwd");
		String pwd=s.next();
		Vendor v=new Vendor(email,pwd);
		boolean b=vd.login(v);
		if(b) {
			vemail=email;
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	private static void vendorUpdate(String vemail) throws ClassNotFoundException, SQLException {
		System.out.println("enter your update password");
		String pwd=s.next();
		Vendor v=new Vendor(vemail,pwd);
		int n=vd.VendorUpdate1(v);
		if(n>0)
		{
			System.out.println("------password updated succesfuly-------");
			
		}
		else
		{
			System.out.println("---pwd not updated give correct password---");
			vendorUpdate( vemail);
		}
		
		
	}
	private static void VendorDelete(String vemail) throws ClassNotFoundException, SQLException {
		Vendor v=new Vendor(vemail,null);
		int n=vd.VendorDelete1(v);
		if(n>0)
		{
			System.out.println("------deleted succesfuly-------");
			
		}
		else
		{
			System.out.println("-- not deleted---");
			VendorDelete(vemail);
			
		}
		
		
		
	}
	private static void VendorProfile(String vemail) throws ClassNotFoundException, SQLException {
		Vendor v=new Vendor(vemail,null);
		vd.vendorProfile1(v);
		
	}
	private static void createShop() throws  SQLException, ClassNotFoundException
	{
		
		System.out.println("enter name");
		String name=s.next();
		System.out.println("enter address");
		String address=s.next();
		Shop sh=new Shop(name,address,vemail);
		int res=sd.saveShop(sh);
		if(res>0)
		{
			System.out.println("shop is created");
		}
		else
	     {
			System.out.println("shop is not created");
			createShop();
			
	     }
	}
	private static void ShopUpdate() throws ClassNotFoundException, SQLException {
		System.out.println("enter your name");
		String name=s.next();
		System.out.println("enter your address");
		String address=s.next();
		Shop sc=new Shop(name,address,vemail);
		int n=sd.shopUpdate(sc);
		if(n>0)
		{
			System.out.println("------ updated succesfuly-------");
			
		}
		else
		{
			System.out.println("--- not updated check once---");
			ShopUpdate();
		}
		
	}
	private static void shopDelete() throws ClassNotFoundException, SQLException {
		Shop sc=new Shop(null,null,vemail);
		int n=sd.shopDelete(sc);
		if(n>0)
		{
			System.out.println("------deleted succesfuly-------");
			
		}
		else
		{
			System.out.println("-- not deleted---");
			shopDelete();
			
		}
		
	}
	private static void shopInfo() throws ClassNotFoundException, SQLException {
		Shop sc=new Shop(null,null,vemail);
		sd.shopInfo(sc);
		
	}
	private static void createToy() throws  SQLException, ClassNotFoundException
	{
		System.out.println("enter cost");
		int cost=s.nextInt();
		System.out.println("enter quantity");
		int quantity=s.nextInt();
		System.out.println("enter brand");
		String brand=s.next();
		System.out.println("enter type");
		String type=s.next();
		System.out.println("enter color");
		String color=s.next();
		Toy t=new Toy(cost,quantity,brand,type,color);
	
		int res=td.saveToy(t);
		if(res>0)
		{
			System.out.println("Toy is created");
		}
		else
	     {
			System.out.println("Toy is not created");
			createToy();
			
	     }
	}
	private static void ToyUpdate() throws ClassNotFoundException, SQLException {
		System.out.println("enter your toy brand");
		String brand=s.next();
		System.out.println("enter type");
		String type=s.next();
		System.out.println("enter color");
		String color=s.next();
		System.out.println("enter cost");
		int cost=s.nextInt();
		System.out.println("enter quantity");
		int quantity=s.nextInt();
		Toy t=new Toy(cost,quantity,brand,type,color);
		
		int n=td.toyUpdate(t);
		if(n>0)
		{
			System.out.println("------ updated succesfuly-------");
			
		}
		else
		{
			System.out.println("--- not updated check once---");
			ToyUpdate();
			
		}
		
	}
	private static void toyDelete() throws ClassNotFoundException, SQLException {
		System.out.println("enter your toy brand");
		String brand=s.next();
		Toy t=new Toy(0,0,brand,null,null);
		int n=td.toyDelete(t);
		if(n>0)
		{
			System.out.println("------deleted succesfuly-------");
			
		}
		else
		{
			System.out.println("-- not deleted---");
			toyDelete();
			
			
		}
		
	}
	private static void toyInfo() throws ClassNotFoundException, SQLException {
		System.out.println("enter your toy brand");
		String brand=s.next();
		Toy t=new Toy(0,0,brand,null,null);
		td.toyInfo(t);
		
		
	}
	private static void createCustomer() throws  SQLException, ClassNotFoundException
	{
		System.out.println("enter wallet");
		int wallet=s.nextInt();
		System.out.println("enter email");
		String email=s.next();
		System.out.println("enter pwd");
		String pwd=s.next();
		Customer c=new Customer(wallet,email,pwd);
		try {
			int res=cd.saveCustomer(c);
			if(res>0)
			{
				System.out.println("profile is created");
			}
		
		} catch (SQLException e) {
			System.err.println("your enter data is already exist");
			createCustomer();
			
			
		}
		
	}
	private static boolean customerLogin() throws ClassNotFoundException, SQLException
	{
		System.out.println("enter email");
		String email=s.next();
		System.out.println("enter pwd");
		String pwd=s.next();
		Customer c=new Customer(0,email,pwd);
		boolean b=cd.login(c);
		if(b) {
			cemail=email;
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	private static void customerUpdate(String cemail) throws ClassNotFoundException, SQLException {
		System.out.println("enter your update password");
		String pwd=s.next();
		Customer c=new Customer(0,cemail,pwd);
		int n=cd.customerUpdate(c);
		if(n>0)
		{
			System.out.println("------password updated succesfuly-------");
			
		}
		else
		{
			System.out.println("---pwd not updated give correct password---");
			customerUpdate( cemail);
		}
		
		
	}
	private static void customerDelete(String cemail) throws ClassNotFoundException, SQLException {
		Customer c=new Customer(0,cemail,null);
		
		int n=cd.customerDelete(c);
		if(n>0)
		{
			System.out.println("------deleted succesfuly-------");
			
		}
		else
		{
			System.out.println("-- not deleted---");
			customerDelete(cemail);
			
		}
		
	}
	private static void customerProfile(String cemail) throws ClassNotFoundException, SQLException {
		Customer c=new Customer(0,cemail,null);
		cd.customerProfile(c);
		
	}
	
	

}

