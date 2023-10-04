package com.danielhuicochea.microservicios.app.facturas.models.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.danielhuicochea.microservicios.app.facturas.request.FacturaRequest;

@Entity
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	private String noOrden;
	
	private String compra;

	private String descripcion;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	private BigDecimal total;

	private BigDecimal subTotal;

	private BigDecimal iva;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Factura update(FacturaRequest facturaRequest) {
	 	this.nombre = facturaRequest.getNombre();
	 	this.noOrden = facturaRequest.getNoOrden();
	 	this.compra = facturaRequest.getCompra();
	 	this.descripcion = facturaRequest.getDescripcion();
	 	this.total = facturaRequest.getTotal();
	 	this.subTotal = facturaRequest.getSubTotal();
	 	this.iva = facturaRequest.getIva();
		return this;
	}
	
	public Factura newFactura(FacturaRequest facturaRequest) {
		this.nombre = facturaRequest.getNombre();
	 	this.noOrden = facturaRequest.getNoOrden();
	 	this.compra = facturaRequest.getCompra();
	 	this.descripcion = facturaRequest.getDescripcion();
	 	this.total = facturaRequest.getTotal();
	 	this.subTotal = facturaRequest.getSubTotal();
	 	this.iva = facturaRequest.getIva();
		return this;
	}

	public String getNoOrden() {
		return noOrden;
	}

	public void setNoOrden(String noOrden) {
		this.noOrden = noOrden;
	}

	public String getCompra() {
		return compra;
	}

	public void setCompra(String compra) {
		this.compra = compra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	
}
