package com.project.model;

import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 



public class Student {

	private Integer student_id;
	
	private String imie;

	private String nazwisko;
	
	private String nr_indeksu;
	
	private String email;
	
	private Boolean stacjonarny;
	
	private Set<Projekt> projekty;
	
	public Set<Projekt> getProjekty() {
		return projekty;
	}

	public void setProjekty(Set<Projekt> projekty) {
		this.projekty = projekty;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNr_indeksu() {
		return nr_indeksu;
	}

	public void setNr_indeksu(String nr_indeksu) {
		this.nr_indeksu = nr_indeksu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStacjonarny() {
		return stacjonarny;
	}

	public void setStacjonarny(Boolean stacjonarny) {
		this.stacjonarny = stacjonarny;
	}

	public Student() {}

	public Student(String imie, String nazwisko, String nr_indeksu, Boolean stacjonarny) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nr_indeksu = nr_indeksu;
		this.stacjonarny = stacjonarny;
	}

	public Student(String imie, String nazwisko, String nr_indeksu, String email, Boolean stacjonarny) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nr_indeksu = nr_indeksu;
		this.email = email;
		this.stacjonarny = stacjonarny;
	}
	

}
