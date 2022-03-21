package com.equitherapieBack.equitherapieBack.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TherapeuteDto {

	@NotNull
	@Size(min=2, max=10)
	private String nom;
	
	@NotNull
	@Size(min=5, max=800)
	private String description;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
}
