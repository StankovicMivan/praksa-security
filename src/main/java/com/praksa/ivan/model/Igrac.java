package com.praksa.ivan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Igrac {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String ime;
	@Column
	private String prezime;
	@Column
	private String pozicija;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Klub klub;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	public Klub getKlub() {
		return klub;
	}

	public void setKlub(Klub klub) {
		this.klub = klub;
		if(klub!=null && !klub.getIgraci().contains(this)) {
			klub.getIgraci().add(this);
		}
	}
	

}
