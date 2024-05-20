package com.laCheleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idproveedor;
	
	private String fecha;
	private String nombre;
	private String telefono;
	
	
	public Integer getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(Integer idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
