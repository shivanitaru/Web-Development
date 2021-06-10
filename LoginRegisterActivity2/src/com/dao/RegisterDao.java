package com.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
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
			//ps.setString(6,r.getSalt());
		
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
	
	public String HashMD5(String Password){ //staru12
		//byte[] salt = Salt.getBytes();
		String SecurePass = null;
		try {
			// Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(Password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            SecurePass = sb.toString();   //16-bit hash value
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        //System.out.println(SecurePass);
		return SecurePass;
	}
	
	/*public String GetSalt() throws NoSuchAlgorithmException,NoSuchProviderException{
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	    //Create array for salt
	    byte[] salt = new byte[16];
	    //Get a random salt
	    sr.nextBytes(salt);
	    //convert byte array into string
	    String Salt = new String(salt);
	    //return salt
	    System.out.println(Salt);
	    return Salt;
	} */
      
}
