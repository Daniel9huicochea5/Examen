package com.danielhuicochea.microservicios.app.cursos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.danielhuicochea.microservicios.app.cursos.models.entity.Curso;
import com.danielhuicochea.microservicios.app.cursos.request.CursoRequest;
import com.danielhuicochea.microservicios.app.cursos.services.CursoService;

@RestController
public class CursoController {

	private final CursoService cursosService;

	public CursoController(CursoService cursosService) {
		this.cursosService = cursosService;
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		Optional<Curso> curso = cursosService.getById(id);
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(curso.get()); 
	}

	@GetMapping
	public ResponseEntity findAll() {
		return ResponseEntity.ok(cursosService.findAll());
	}

	@PostMapping
	public ResponseEntity create(@RequestBody CursoRequest cursoRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cursosService.create(new Curso().newCurso(cursoRequest)));

	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id, @RequestBody CursoRequest cursoRequest) {
		Optional<Curso> curso = cursosService.getById(id);
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(cursosService.update(curso.get().update(cursoRequest)));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		Optional<Curso> curso = cursosService.getById(id);
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cursosService.delete(curso.get());
		return ResponseEntity.ok().build();
	}

}
