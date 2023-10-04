package com.danielhuicochea.microservicios.app.facturas.services;

import java.util.Optional;

import com.danielhuicochea.microservicios.app.facturas.models.entity.Factura;

import java.util.List;


public interface FacturaService {
	public Factura create(Factura factura);
	public Optional<Factura> getById(Long id);
	public List<Factura> findAll();
	public Factura update(Factura curso);	
	public void delete(Factura factura);
}
