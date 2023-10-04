package com.danielhuicochea.microservicios.app.productos.services;

import java.util.Optional;

import com.danielhuicochea.microservicios.app.productos.models.entity.Producto;

import java.util.List;


public interface ProductoService {
	public Producto create(Producto producto);
	public Optional<Producto> getById(Long id);
	public List<Producto> findAll();
	public Producto update(Producto producto);	
	public void delete(Producto producto);
}
