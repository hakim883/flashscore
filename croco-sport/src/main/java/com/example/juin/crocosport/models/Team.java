package com.example.juin.crocosport.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TEAM_ID")
	private Long id;
	private String name;
	private int foundation;
	private String owner;
	private String stadium;
	private Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Team(Long id, String name, int foundation, String owner, String stadium) {
		super();
		this.id = id;
		this.name = name;
		this.foundation = foundation;
		this.owner = owner;
		this.stadium = stadium;
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
	 * @return the foundation
	 */
	public int getFoundation() {
		return foundation;
	}
	/**
	 * @param foundation the foundation to set
	 */
	public void setFoundation(int foundation) {
		this.foundation = foundation;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the stadium
	 */
	public String getStadium() {
		return stadium;
	}
	/**
	 * @param stadium the stadium to set
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", foundation=" + foundation + ", owner=" + owner + ", stadium="
				+ stadium + "]";
	}
	
	

}
