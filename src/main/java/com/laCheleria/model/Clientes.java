package com.laCheleria.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcliente;

	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String email;
	private String telefono;
	private String direccion;


	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Clientes [idcliente=" + idcliente + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno
				+ ", apellido_materno=" + apellido_materno + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", getIdcliente()=" + getIdcliente() + ", getNombre()=" + getNombre()
				+ ", getApellido_paterno()=" + getApellido_paterno() + ", getApellido_materno()="
				+ getApellido_materno() + ", getEmail()=" + getEmail() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}
