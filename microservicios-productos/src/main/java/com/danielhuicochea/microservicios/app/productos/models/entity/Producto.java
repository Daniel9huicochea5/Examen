package com.danielhuicochea.microservicios.app.productos.models.entity;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import com.danielhuicochea.microservicios.app.productos.request.ProductoRequest;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {

	@Id
	private String id;

	private String nombre;

	
	private BigDecimal precio;

	private String descripcion;

	
	private int cantidad;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Producto update(ProductoRequest facturaRequest) {
	 	this.nombre = facturaRequest.getNombre();
	 	this.descripcion = facturaRequest.getDescripcion();
	 	this.precio = facturaRequest.getPrecio();
	 	this.cantidad = facturaRequest.getCantidad();
		return this;
	}
	
	public Producto newProducto(ProductoRequest facturaRequest) {
		this.nombre = facturaRequest.getNombre();
	 	this.descripcion = facturaRequest.getDescripcion();
	 	this.precio = facturaRequest.getPrecio();
	 	this.cantidad = facturaRequest.getCantidad();
		return this;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
