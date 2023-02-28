package com.example.juin.crocosport.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.juin.crocosport.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
