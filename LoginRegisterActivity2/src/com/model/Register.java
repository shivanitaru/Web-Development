package com.model;

public class Register {
	private String name;
	private long mbno;
	private String email;
	private String uname;
	private String pass;
	//private String salt;
	
	public Register() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMbno() {
		return mbno;
	}
	public void setMbno(long mbno) {
		this.mbno = mbno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	/*public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}*/

	
}
