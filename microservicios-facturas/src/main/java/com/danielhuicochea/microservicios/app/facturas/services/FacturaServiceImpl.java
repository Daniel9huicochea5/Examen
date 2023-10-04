package com.danielhuicochea.microservicios.app.facturas.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.danielhuicochea.microservicios.app.facturas.models.entity.Factura;
import com.danielhuicochea.microservicios.app.facturas.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {
	
	private final FacturaRepository facturaRepository;
	
	public FacturaServiceImpl(FacturaRepository facturaRepository) {
		this.facturaRepository = facturaRepository;
	}

	@Override
	public Factura create(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public Optional<Factura> getById(Long id) {
		return facturaRepository.findById(id);
	}

	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura update(Factura factura) {
		return create(factura);
	}

	@Override
	public void delete(Factura factura) {
		facturaRepository.delete(factura);		
	}


}
