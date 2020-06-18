package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.model.Register;

public class RegisterDao {
	
	Connection con;
    PreparedStatement ps;
    
	public RegisterDao() {
		
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
	
	public int savedata(Register r) {
		int i=0;
		int cnt=0;
		con=getConnection();
		try
		{
			ps=con.prepareStatement("insert into UserDetails values(?,?,?,?,?)");
			ps.setString(1,r.getName());
			ps.setLong(2,r.getMbno());
			ps.setString(3,r.getEmail());
			ps.setString(4,r.getUname());
			ps.setString(5,r.getPass());
		
			i=ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			cnt=1;
		}
		
		return cnt;
		
	}
      
}
