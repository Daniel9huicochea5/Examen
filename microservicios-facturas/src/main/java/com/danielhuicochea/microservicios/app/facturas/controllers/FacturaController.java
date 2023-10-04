package com.danielhuicochea.microservicios.app.facturas.controllers;

import org.springframework.beans.factory.annotation.Value;
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

import com.danielhuicochea.microservicios.app.facturas.models.entity.Factura;
import com.danielhuicochea.microservicios.app.facturas.request.FacturaRequest;
import com.danielhuicochea.microservicios.app.facturas.services.FacturaService;

@RestController
public class FacturaController {

	private final FacturaService facturaService;

	public FacturaController(FacturaService facturaService) {
		this.facturaService = facturaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		Optional<Factura> curso = facturaService.getById(id);
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(curso.get()); 
	}

	@GetMapping
	public ResponseEntity findAll() {
		return ResponseEntity.ok(facturaService.findAll());
	}

	@PostMapping
	public ResponseEntity create(@RequestBody FacturaRequest facturaRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.create(new Factura().newFactura(facturaRequest)));

	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id, @RequestBody FacturaRequest facturaRequest) {
		Optional<Factura> curso = facturaService.getById(id);
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.update(curso.get().update(facturaRequest)));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		Optional<Factura> curso = facturaService.getById(id);
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		facturaService.delete(curso.get());
		return ResponseEntity.ok().build();
	}

}
