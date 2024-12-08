package com.sandip.beans;

import com.sandip.daos.CandidateDao;
import com.sandip.daos.CandidateDaoImpl;
import com.sandip.daos.UserDao;
import com.sandip.daos.UserDaoImpl;
import com.sandip.entities.User;

public class Vote {

	private int candId;
	private boolean success;
	private int userId;
	public Vote() {
		
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public boolean setSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void vote() {
		
		this.success=false;
		//increment candidate vote
		try(CandidateDao cd=new CandidateDaoImpl()){
			 int count=cd.incrVote(this.candId);
			 if(count==1) {
				 
				 //find the current usr status in db
		try(UserDao ud=new UserDaoImpl()){
		User user=ud.findById(userId);
		if(user !=null) {
			
			//update current user status as voted
			user.setStatus(1);
			count=ud.update(user);
			if(count==1) {
				this.success=true;
			}}
		}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
