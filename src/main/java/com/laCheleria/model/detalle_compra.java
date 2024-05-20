package com.laCheleria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="detalle_compra")
public class detalle_compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idcompra;
	
	@Column(name = "id")
	private Integer productos;
	
	private double cantidad;
	private String unidad;
	private double precio_unitario;
	private double subtotal;
	
	@Transient
	private Producto producto;

	public Integer getIdcompra() {
		return idcompra;
	}

	public void setIdcompra(Integer idcompra) {
		this.idcompra = idcompra;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getProductos() {
		return productos;
	}

	public void setProductos(Integer productos) {
		this.productos = productos;
	}
	
	
}
