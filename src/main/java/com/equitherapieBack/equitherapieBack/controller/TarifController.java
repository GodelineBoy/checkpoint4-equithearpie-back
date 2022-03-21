package com.equitherapieBack.equitherapieBack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.equitherapieBack.equitherapieBack.Dto.TarifDto;
import com.equitherapieBack.equitherapieBack.entity.Tarif;
import com.equitherapieBack.equitherapieBack.repository.TarifRepository;


@RestController
@RequestMapping("/tarifs")
public class TarifController {

	
	
	@Autowired
	TarifRepository tarifRepository;
	
	//create tarif
	@PostMapping
	public Tarif create(@Valid @RequestBody TarifDto tarifDto) {
		Tarif tarif = new Tarif();
		tarif.setDescription(tarifDto.getDescription());
		tarif.setPrix(tarifDto.getPrix());
		
		return tarifRepository.save(tarif);
		
	}
	
	//getAll tarif
	@GetMapping
	public List <Tarif> getTarifs() {
		
		return tarifRepository.findAll();
	}
	
	//getById tarif
	@GetMapping ("/{id}")
	public Tarif get(@PathVariable (required = true) Long id) {
		
		return tarifRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));		
	}
	
	//updateById tarifs
	@PutMapping("/{id}")
	public Tarif update(@PathVariable (required = true) Long id, @RequestBody TarifDto tarifDto) {
		
		Tarif tarif = tarifRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		tarif.setDescription(tarifDto.getDescription());
		tarif.setPrix(tarifDto.getPrix());
		
		return tarifRepository.save(tarif);
	}
	
	//deleteById tarifs
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (required = true) Long id) {
		
		Tarif tarif = tarifRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		tarifRepository.deleteById(id);
	}
}
