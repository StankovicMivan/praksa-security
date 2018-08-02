package com.praksa.ivan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Klub {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	
	@OneToMany(mappedBy="klub")
	private List<Igrac> igraci = new ArrayList<Igrac>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}
	
	public void addIgrac(Igrac igrac) {
		this.igraci.add(igrac);
		
		if(igrac.getKlub() != this) {
			igrac.setKlub(this);
		}
	}
}
