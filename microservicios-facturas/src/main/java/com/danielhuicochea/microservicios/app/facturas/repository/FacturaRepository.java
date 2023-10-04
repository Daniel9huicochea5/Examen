package com.danielhuicochea.microservicios.app.facturas.repository;

import com.danielhuicochea.microservicios.app.facturas.models.entity.Factura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
