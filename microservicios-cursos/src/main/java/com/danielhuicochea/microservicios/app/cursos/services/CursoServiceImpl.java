package com.danielhuicochea.microservicios.app.cursos.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.danielhuicochea.microservicios.app.cursos.models.entity.Curso;
import com.danielhuicochea.microservicios.app.cursos.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	private final CursoRepository cursoRepository;
	
	public CursoServiceImpl(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	public Curso create(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Optional<Curso> getById(Long id) {
		return cursoRepository.findById(id);
	}

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso update(Curso curso) {
		return create(curso);
	}

	@Override
	public void delete(Curso curso) {
		cursoRepository.delete(curso);		
	}


}
