package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.model.Dinamica;
import com.example.demo.service.IDinamicaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DinamicaRestController {

	@Autowired
	private IDinamicaService dinamicaService;

	@GetMapping("/mostrar")
	public List<Dinamica> listar() {
		return dinamicaService.findAll();
	}

	@GetMapping("/mostrar/{id}")
	public Dinamica find(@PathVariable Long id) {
		return this.dinamicaService.findById(id);
	}

	@PostMapping("/mostrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Dinamica crear(@RequestBody Dinamica dinamica ) {
		this.dinamicaService.save(dinamica);
		return dinamica;
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Dinamica actualizar(@RequestBody Dinamica dinamica, @PathVariable Long id) {
		Dinamica currentDinamica = this.dinamicaService.findById(id);
		currentDinamica.setMentor(dinamica.getMentor());
		currentDinamica.setMentorizado(dinamica.getMentorizado());
		currentDinamica.setCarrera(dinamica.getCarrera());
		this.dinamicaService.save(currentDinamica);
		return currentDinamica;
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		Dinamica currentDinamica = this.dinamicaService.findById(id);
		this.dinamicaService.delete(currentDinamica);
	}
	
}
