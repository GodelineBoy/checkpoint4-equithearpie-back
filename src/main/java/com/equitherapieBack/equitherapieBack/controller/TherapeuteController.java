package com.equitherapieBack.equitherapieBack.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.equitherapieBack.equitherapieBack.Dto.TherapeuteDto;
import com.equitherapieBack.equitherapieBack.entity.Photo;
import com.equitherapieBack.equitherapieBack.entity.Therapeute;
import com.equitherapieBack.equitherapieBack.repository.PhotoRepository;
import com.equitherapieBack.equitherapieBack.repository.TherapeuteRepository;
import com.equitherapieBack.equitherapieBack.service.FilesStorageService;



@RestController
@CrossOrigin
@RequestMapping("/therapeutes")
public class TherapeuteController {
	
	@Autowired
	TherapeuteRepository therapeuteRepository;
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	FilesStorageService storageService;
	
	//getAll therapeutes
		@GetMapping
		public List<Therapeute> getTherapeute() {
			
			return therapeuteRepository.findAll();
		}
		
		//getById therapeute
		@GetMapping("/{id}")
		public Therapeute get(@PathVariable (required = true) Long id ) {
			
			return therapeuteRepository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		}
		
		//create therapeute
		@PostMapping(consumes = { "multipart/form-data" })
		public Therapeute create(@Valid TherapeuteDto therapeuteDto, @RequestParam(required = false) MultipartFile photo)
				throws IOException {

			Therapeute therapeute = new Therapeute();
			therapeute.setNom(therapeuteDto.getNom());
			therapeute.setDescription(therapeuteDto.getDescription());
			
			if (photo != null && !photo.isEmpty()) {
				// save picture
				String filename = storageService.save(photo);

				Photo photoTherapeute = new Photo();
				photoTherapeute.setSrc(filename);
				therapeute.setPhoto(photoTherapeute);
				photoRepository.save(photoTherapeute);
			}

			return therapeuteRepository.save(therapeute);
		}

		//update therapeute
		@PutMapping(value = "/{id}", consumes = "multipart/form-data")
		public Therapeute update(@PathVariable(required = true) Long id, @Valid TherapeuteDto therapeuteDto,
				@RequestParam(required = false) MultipartFile photo) throws IOException {
			Therapeute therapeute = therapeuteRepository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

				therapeute.setNom(therapeuteDto.getNom());
				therapeute.setDescription(therapeuteDto.getDescription());
			
			// si la photo est nulle dans la fiche, je modif mon therapeute
				if (photo == null) {
				return therapeuteRepository.save(therapeute);

			}
			// je modifie la photo avec un nouveau fichier 
			else if (photo != null && !photo.isEmpty()) {

				Photo photoTherapeute = therapeute.getPhoto();
				// Je supprime la photo 
				if (photoTherapeute != null) {
					storageService.deleteFile(photoTherapeute.getSrc());
				}
				String filename = storageService.save(photo);
				photoTherapeute = new Photo();
				photoTherapeute.setSrc(filename);
				therapeute.setPhoto(photoTherapeute);
			}

			return therapeuteRepository.save(therapeute);
		}
		
			//delete therapeute
			@DeleteMapping("/{id}")
			public void delete(@PathVariable(required = true) long id) throws IOException {
				Therapeute therapeute = therapeuteRepository.findById(id)
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

				// Je verif s'il y a une photo et je la delete si besoin
				if (therapeute.getPhoto() != null) {
					storageService.deleteFile(therapeute.getPhoto().getSrc());
				}

				therapeuteRepository.delete(therapeute);

			}
}
