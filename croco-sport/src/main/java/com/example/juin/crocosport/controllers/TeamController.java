package com.example.juin.crocosport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.juin.crocosport.models.Team;
import com.example.juin.crocosport.services.TeamService;

@CrossOrigin("*")
@RequestMapping("api/teams")
@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;

	@PostMapping
	public Team addTeam(@RequestBody Team t) {
		return teamService.addTeam(t);
	}

	@GetMapping("/{id}")
	public Team getTeam(@PathVariable Long id) {
		return teamService.getTeamById(id);
	}

	@GetMapping
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
	}

	@DeleteMapping("/{id}")
	public void deleteTeam(@PathVariable Long id) {
		teamService.deleteTeamById(id);
	}

	@PutMapping("/{id}")
	public Team editTeam(@RequestBody Team t) {
		return teamService.editTeam(t);
	}
}
