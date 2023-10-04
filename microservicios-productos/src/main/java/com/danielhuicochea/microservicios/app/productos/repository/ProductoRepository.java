package com.danielhuicochea.microservicios.app.productos.repository;

import com.danielhuicochea.microservicios.app.productos.models.entity.Producto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, Long> {
}
