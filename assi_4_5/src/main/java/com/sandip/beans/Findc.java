package com.sandip.beans;

import com.sandip.daos.CandidateDao;
import com.sandip.daos.CandidateDaoImpl;
import com.sandip.entities.Candidate;

public class Findc {
	private int candId;
	private Candidate cand;
	public Findc() {
		
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public Candidate getCand() {
		return cand;
	}
	public void setCand(Candidate cand) {
		this.cand = cand;
	}
	
	public void find() {
		try(CandidateDao canDao=new CandidateDaoImpl()){
			this.cand	=canDao.findById(candId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
