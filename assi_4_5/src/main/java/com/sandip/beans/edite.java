package com.sandip.beans;

import com.sandip.daos.CandidateDao;
import com.sandip.daos.CandidateDaoImpl;
import com.sandip.entities.Candidate;

public class edite {
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	public edite() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void updateCand() {
		Candidate c=new Candidate(id, name, party, votes);
		try(CandidateDao canDao=new CandidateDaoImpl()){
		this.count=	canDao.update(c);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
	}
	
	
}
