package com.service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService{
	
	static List<Product> plist = new ArrayList<>();

	@Override
	public void addProduct(Product prod) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root","2332");
			//
			
			String sql="insert into product(name,company,price)values('"+prod.getName()+"','"+prod.getCompany()+"','"+prod.getPrice()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			
			
			
		} catch (Exception e) {
			
			
			
			e.printStackTrace();
		}
		
//		plist.add(prod);
//		System.out.println("-------------added success---------size = "+plist.size());
	
	}

	@Override
	public void deleteProduct(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root","2332");
			String sql =" delete from product  where id ='"+id+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			con.close();
			System.out.println("Success");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		//plist.remove(index);
		
		
		
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root","2332");
			//
			
			String sql="select * from product";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			 
		 while(rs.next()) {
			 System.out.println("Id"+rs.getInt("id"));
			 System.out.println("Name="+rs.getString("name"));
			 System.out.println("Company="+rs.getString("company"));
			 System.out.println("price="+rs.getInt("price"));
		 }
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public void updateproduct(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root","2332");
			
			
			String sql =" update product set company='lenovo' where id =5";
			Statement stm = con.createStatement();
			stm.execute(sql);
			con.close();
			System.out.println("Done");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	

}
