package com.example.juin.crocosport.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.juin.crocosport.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}