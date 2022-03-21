package com.equitherapieBack.equitherapieBack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Photo {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String src;
	
	@JsonIgnore
	@OneToOne(mappedBy = "photo")
	private Therapeute therapeute;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Therapeute getTherapeute() {
		return therapeute;
	}

	public void setTherapeute(Therapeute therapeute) {
		this.therapeute = therapeute;
	}
	
	
}
