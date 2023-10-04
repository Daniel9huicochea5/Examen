package com.danielhuicochea.microservicios.app.productos.controllers;

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

import com.danielhuicochea.microservicios.app.productos.models.entity.Producto;
import com.danielhuicochea.microservicios.app.productos.request.ProductoRequest;
import com.danielhuicochea.microservicios.app.productos.services.ProductoService;

@RestController
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		Optional<Producto> producto = productoService.getById(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto.get()); 
	}

	@GetMapping
	public ResponseEntity findAll() {
		return ResponseEntity.ok(productoService.findAll());
	}

	@PostMapping
	public ResponseEntity create(@RequestBody ProductoRequest productoRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.create(new Producto().newProducto(productoRequest)));

	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id, @RequestBody ProductoRequest productoRequest) {
		Optional<Producto> producto = productoService.getById(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.update(producto.get().update(productoRequest)));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		Optional<Producto> producto = productoService.getById(id);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.delete(producto.get());
		return ResponseEntity.ok().build();
	}

}
