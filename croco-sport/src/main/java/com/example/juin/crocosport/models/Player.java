package com.example.juin.crocosport.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_ID")
	private Long id;
	private String name;
	private int nbr;
	private String position;
	@ManyToOne
	@JoinColumn(name = "TEAM_ID", nullable = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team team;

	private Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Player(Long id, String name, int nbr, String position) {
		super();
		this.id = id;
		this.name = name;
		this.nbr = nbr;
		this.position = position;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nbr
	 */
	public int getNbr() {
		return nbr;
	}

	/**
	 * @param nbr the nbr to set
	 */
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", nbr=" + nbr + ", position=" + position + "]";
	}

}
