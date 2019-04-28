package com.matovic.evidencija.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Evidencija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private Long id;

	private int utrosenoVreme;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zaposleni_id", referencedColumnName = "id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Zaposleni worker;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROJEKTI_id", referencedColumnName = "id")
	private Projekti project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUtrosenoVreme() {
		return utrosenoVreme;
	}

	public void setUtrosenoVreme(int utrosenoVreme) {
		this.utrosenoVreme = utrosenoVreme;
	}

	public Zaposleni getWorker() {
		return worker;
	}

	public void setWorker(Zaposleni worker) {
		this.worker = worker;
	}

	public Projekti getProject() {
		return project;
	}

	public void setProject(Projekti project) {
		this.project = project;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evidencija [id=");
		builder.append(id);
		builder.append(", utrosenoVreme=");
		builder.append(utrosenoVreme);
		builder.append(", worker=");
		builder.append(worker);
		builder.append(", project=");
		builder.append(project);
		builder.append("]");
		return builder.toString();
	}

}
