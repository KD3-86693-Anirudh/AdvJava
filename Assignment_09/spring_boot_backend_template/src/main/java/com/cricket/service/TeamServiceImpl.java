package com.cricket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.dao.TeamDao;
import com.cricket.dto.ApiResponce;
import com.cricket.dto.TeamReqDTO;
import com.cricket.dto.TeamRespDTO;
import com.cricket.pojos.Team;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public ApiResponce addTeam(TeamReqDTO t) {
		
		Team team = modelMapper.map(t, Team.class);
		
		Team newTeam = teamDao.save(team);
		return new ApiResponce("Owner name of the team is "+newTeam.getOwner());
	}

	@Override
	public List<TeamRespDTO> getAllTeam() {
		
		return teamDao.findAll().stream().map(team -> modelMapper.map(team, TeamRespDTO.class)).collect(Collectors.toList());
	}

}
