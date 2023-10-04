package com.danielhuicochea.microservicios.app.productos.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.danielhuicochea.microservicios.app.productos.models.entity.Producto;
import com.danielhuicochea.microservicios.app.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Producto create(Producto factura) {
		return productoRepository.save(factura);
	}

	@Override
	public Optional<Producto> getById(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto update(Producto factura) {
		return create(factura);
	}

	@Override
	public void delete(Producto factura) {
		productoRepository.delete(factura);		
	}


}
