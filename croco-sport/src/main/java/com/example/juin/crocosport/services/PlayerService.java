package com.example.juin.crocosport.services;

import java.util.List;

import com.example.juin.crocosport.models.Player;

public interface PlayerService {

	public Player addPlayer(Player p);

	public Player editPlayer(Player p);

	public Player getPlayerById(Long id);
	
	public void deletePlayerById(Long id);
	
	public List<Player> getAllPlayers();
}
