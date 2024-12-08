package com.sandip.beans;

import java.sql.Date;

import com.sandip.daos.UserDao;
import com.sandip.daos.UserDaoImpl;
import com.sandip.entities.User;

public class Register {

	
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String dob;
	private String status;
	private String voter;
	private boolean count;
	public boolean getCount() {
		return count;
	}
	public void setCount(Boolean count) {
		this.count = count;
	}
	public Register() {
		
	}
	public Register(String first_name, String last_name, String email, String password, String dob, String status,
			String voter) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.voter = voter;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	
	public void Registeru() {
		
		Date d=Date.valueOf(dob);
		
		User u1=new User(0, last_name, first_name, email, password, d, 0, "voter");
		
		try(UserDao uDao=new UserDaoImpl()){
			int count=0;
			if(u1!=null)
			{			
				count = uDao.save(u1);
			System.out.println(u1);
			}
			
			if(count!=0) {
				
				this.count=true;
				System.out.println("user register suceesfull");
			}else {
				System.out.println("registertion faild");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
		
	}
	
	
	
}
