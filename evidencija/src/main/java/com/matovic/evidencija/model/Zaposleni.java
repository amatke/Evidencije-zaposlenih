package com.matovic.evidencija.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="zaposleni")
public class Zaposleni {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="id")
	private Long id;
	private String firstName;
	private String lastName;
	private String JMBG;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="POZICIJE_id", referencedColumnName="id")
	@NotNull
	private Pozicije position;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJEKTI_id", referencedColumnName="id")
	private Projekti project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="timovi_id", referencedColumnName="id")
	private Timovi team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public Pozicije getPosition() {
		return position;
	}

	public void setPosition(Pozicije position) {
		this.position = position;
	}

	public Projekti getProject() {
		return project;
	}

	public void setProject(Projekti project) {
		this.project = project;
	}

	public Timovi getTeam() {
		return team;
	}

	public void setTeam(Timovi team) {
		this.team = team;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Zaposleni [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", JMBG=");
		builder.append(JMBG);
		builder.append(", position=");
		builder.append(position);
		builder.append(", project=");
		builder.append(project);
		builder.append(", team=");
		builder.append(team);
		builder.append("]");
		return builder.toString();
	}
	
	
}
