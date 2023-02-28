package com.example.juin.crocosport.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.juin.crocosport.models.Team;
import com.example.juin.crocosport.respositories.TeamRepository;
import com.example.juin.crocosport.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	@Override
	public Team addTeam(Team t) {
		// TODO Auto-generated method stub
		return teamRepository.save(t);
	}

	@Override
	public Team editTeam(Team t) {
		// TODO Auto-generated method stub
		return teamRepository.save(t);
	}

	@Override
	public Team getTeamById(Long id) {
		// TODO Auto-generated method stub
		Optional<Team> team= teamRepository.findById(id);
		return team.isPresent() ? team.get() : null;
	}

	@Override
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);
		
	}

	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepository.findAll();
	}

}
