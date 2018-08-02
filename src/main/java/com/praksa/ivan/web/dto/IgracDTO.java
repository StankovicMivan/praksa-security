package com.praksa.ivan.web.dto;


public class IgracDTO {


	private Long id;	
	private String ime;	
	private String prezime;
	private String pozicija;
	private Long klubId;
	private String klubNaziv;
	
	
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
	public Long getKlubId() {
		return klubId;
	}
	public void setKlubId(Long klubId) {
		this.klubId = klubId;
	}
	public String getKlubNaziv() {
		return klubNaziv;
	}
	public void setKlubNaziv(String klubNaziv) {
		this.klubNaziv = klubNaziv;
	}

	
}
