package com.sandip.beans;

import com.sandip.daos.CandidateDao;
import com.sandip.daos.CandidateDaoImpl;

public class delcnd {
	
	private int id;
	private int count;
	public delcnd() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void delete() {
		try(CandidateDao cnDao=new CandidateDaoImpl()){
			count=cnDao.deleteById(id);
			String mag="Candidate deleted"+count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}
