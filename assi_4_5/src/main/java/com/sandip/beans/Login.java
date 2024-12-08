package com.sandip.beans;

import com.sandip.daos.UserDao;
import com.sandip.daos.UserDaoImpl;
import com.sandip.entities.User;

public class Login {
String email;
String pass;
User u;
boolean status=false;

{
u=new User();	
}

public Login() {
	
}

public Login(String email, String pass, User u) {
	
	this.email = email;
	this.pass = pass;
	this.u = u;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public User getU() {
	return u;
}

public void setU(User u) {
	this.u = u;
}



public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}

@Override
public String toString() {
	return "Login [email=" + email + ", pass=" + pass + ", u=" + u + "]";
}

public void validate() {

	try(UserDao uDao=new UserDaoImpl()){

		User u1=	uDao.findByEmail(this.email);

		if(u1!=null && u1.getPassword().equals(this.pass)) {
			this.u=u1;
		}else {
			this.u=null;
		}
		
		
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		throw new RuntimeException(e);
	}
	
	}
	



}
