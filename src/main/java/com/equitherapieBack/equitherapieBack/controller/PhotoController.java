package com.equitherapieBack.equitherapieBack.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equitherapieBack.equitherapieBack.repository.PhotoRepository;
import com.equitherapieBack.equitherapieBack.service.FilesStorageService;


@RestController
@CrossOrigin
@RequestMapping("/photos")
public class PhotoController {

	
	@Autowired
	FilesStorageService storageService;
	
	@Autowired
	PhotoRepository photoRepository;
	
	@GetMapping("/{filename:.+}")
	public ResponseEntity<Resource> get(@PathVariable String filename) throws IOException {
		Resource file =  storageService.load(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
		
	}
}
