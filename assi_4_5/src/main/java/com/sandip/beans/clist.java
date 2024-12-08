package com.sandip.beans;

import java.util.ArrayList;
import java.util.List;

import com.sandip.daos.CandidateDao;
import com.sandip.daos.CandidateDaoImpl;
import com.sandip.entities.Candidate;

public class clist {
	private List<Candidate> candList;

	public clist() {
		this.candList = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fechCandidates() {
		
		try(CandidateDao cd=new CandidateDaoImpl()){
			this.candList=cd.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		throw new RuntimeException(e);
		}
		
		
	}
	
	
}
