package com.danielhuicochea.microservicios.app.cursos.services;

import java.util.Optional;

import com.danielhuicochea.microservicios.app.cursos.models.entity.Curso;

import java.util.List;


public interface CursoService {
	public Curso create(Curso curso);
	public Optional<Curso> getById(Long id);
	public List<Curso> findAll();
	public Curso update(Curso curso);	
	public void delete(Curso curso);
}
