package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;

public class LoginDao {
	
	Connection con;
    PreparedStatement ps;
    
	public LoginDao() {
		
	}
	
	public Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","123456789");
	
		}
		catch(ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return con;

	}
	
	public boolean validate(Login l){
		getConnection();
		boolean b=false;
		
		try
		{
			ps=con.prepareStatement("select * from UserDetails where uname=? AND password=?");
			ps.setString(1,l.getUname());
			ps.setString(2,l.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				b=true;
			}
			else
			{
				b=false;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
	}
	
	/*public String GetSalt(String uname){
		String salt = null;
		getConnection();
		try{
			ps=con.prepareStatement("select salt from UserDetails where uname=?");
			ps.setString(1,uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				salt = rs.getString(1);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return salt;
	}*/

}
