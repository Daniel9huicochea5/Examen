package com.danielhuicochea.microservicios.app.cursos.repository;

import com.danielhuicochea.microservicios.app.cursos.models.entity.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
