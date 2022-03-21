package com.equitherapieBack.equitherapieBack.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TarifDto {

	
	@NotNull
	@Size(min=5, max=800)
	private String description;
	
	@NotNull
	private Integer prix;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	
	
}
