package com.sandip.beans;

import java.util.ArrayList;
import java.util.List;

import com.sandip.daos.CandidateDao;
import com.sandip.daos.CandidateDaoImpl;
import com.sandip.entities.Candidate;

public class Result {
	private List<Candidate> candList;

	public Result() {
		candList=new ArrayList<>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	
	public void fetchCandidate() {
		
		try(CandidateDao cnDao=new CandidateDaoImpl()){
			candList=cnDao.findAll();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
throw new RuntimeException(e);
		}
		
		
	}

}
