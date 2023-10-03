package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.BankAccount;

public class AccountDao {
	
	public Connection setupconnection() {
		
		Connection con=null;
		
      String url="jdbc:mysql://localhost:3307/bankaccounts";
		
		
		String user="root";
		
		String pwd="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url,user,pwd);
			
			System.out.println("Connection is successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
			
	}
	public List<BankAccount> displayaccount(){
		
		List<BankAccount> accounts=new ArrayList<>();
		
         Connection con=setupconnection();
		
		String sql="select*from accounts";
		
		try {
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				BankAccount account =new BankAccount(rs.getInt("account_id"),
				rs.getString("account_type"),rs.getString("accountHolderName"),	rs.getString("accountHolderContact"),rs.getString("accountBalance"),rs.getDate("accountSetupDate"));
				
				accounts.add(account);
			}
			System.out.println(accounts);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}
	//Method for inserting data
	 
	public int insertRec(BankAccount account) {
		
		int status=0;
		Connection con=setupconnection();
		
		String sql="insert into accounts(account_id,account_type,accountHolderName,accountHolderContact,accountBalance,accountSetupDate) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, account.getAccount_id());
			
			pstmt.setString(2, account.getAccont_type());
			
			pstmt.setString(3, account.getAccountHolderName());
			
			pstmt.setString(4, account.getAccountHolderContact());
			
			pstmt.setString(5, account.getAccountBalance());
			
			pstmt.setDate(6, account.getAccountSetupDate());
			
        		   status=pstmt.executeUpdate();
			
			if(status>0) {
				
				System.out.println("Account record added successfully");
				
				displayaccount();
			}
			else {
				System.out.println("Try again some error occured!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	// Create delete method for deleting the record
	
	public void deleteRec(int account_id) {
		
		Connection con=setupconnection();
		
		String sql="Delete from accounts where account_id=?";
		
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			
			pstmt.setInt(1, account_id);
			
			int result=pstmt.executeUpdate();
			
			if(result>0) {
				
				System.out.println("*****Account information is deleted successfully!!!*****");
				
				displayaccount();
			}
			else {
				System.out.println("*****There is an error. So account information is not deleted.!!!*****");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Update the record based on id
	
	public void updateRec(BankAccount account,int id) {
		
		Connection con=setupconnection();
		
		String sql="Update accounts set account_id=?,account_type=?,accountHolderName=?,accountHolderContact=?,accountBalance=?,accountSetupDate=? where account_id=?";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, account.getAccount_id());
			
			pstmt.setString(2, account.getAccont_type());
			
			pstmt.setString(3, account.getAccountHolderName());
			
			pstmt.setString(4, account.getAccountHolderContact());
			
			pstmt.setString(5, account.getAccountBalance());
			
			pstmt.setDate(6, account.getAccountSetupDate());
			
			pstmt.setInt(7, id);
			
			int result =pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("****The information of account is updated successfully!!!***");
				
				displayaccount();
			}
			else {
				
				System.out.println("****There is an error. Please try again to update account information!!!****");
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//get record by id
	public BankAccount getrecord(int account_id) {
		
		BankAccount account=null;
		
		Connection con=setupconnection();
		
		String sql="Select * from accounts where account_id=?";
		
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			
			pstmt.setInt(1, account_id);
			
			ResultSet rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				account=new BankAccount(rs.getInt("account_id"),rs.getString("account_type"),rs.getString("accountHolderName"),rs.getString("accountHolderContact"),rs.getString("accountBalance"),rs.getDate("accountSetupDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
		
	}

}
