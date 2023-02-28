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

import com.example.juin.crocosport.models.Player;
import com.example.juin.crocosport.services.PlayerService;

@CrossOrigin("*")
@RequestMapping("api/players")
@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping
	public Player addPlayer(@RequestBody Player p) {
		return playerService.addPlayer(p);
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable Long id) {
		return playerService.getPlayerById(id);
	}

	@GetMapping
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}

	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable Long id) {
		playerService.deletePlayerById(id);
	}

	@PutMapping("/{id}")
	public Player editPlayer(@RequestBody Player p) {
		return playerService.editPlayer(p);
	}
}
