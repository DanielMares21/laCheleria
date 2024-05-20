package com.laCheleria.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private double  precio;
   private String tipo;
   private String marca;
   private double cantidad_disponible;


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public double getCantidad_disponible() {
	return cantidad_disponible;
}
public void setCantidad_disponible(double cantidad_disponible) {
	this.cantidad_disponible = cantidad_disponible;
}
@Override
public String toString() {
	return "Producto [id=" + id + ", precio=" + precio + ", tipo=" + tipo + ", marca=" + marca
			+ ", cantidad_disponible=" + cantidad_disponible + ", getId()=" + getId() + ", getPrecio()=" + getPrecio()
			+ ", getTipo()=" + getTipo() + ", getMarca()=" + getMarca() + ", getCantidad_disponible()="
			+ getCantidad_disponible() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}




}
