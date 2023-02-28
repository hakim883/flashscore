package com.example.juin.crocosport.services;

import java.util.List;

import com.example.juin.crocosport.models.Team;

public interface TeamService {
	public Team addTeam(Team t);

	public Team editTeam(Team t);

	public Team getTeamById(Long id);
	
	public void deleteTeamById(Long id);
	
	public List<Team> getAllTeams();
}
