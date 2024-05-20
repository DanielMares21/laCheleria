package com.laCheleria.model;

import jakarta.persistence.*;

@Entity
@Table(name="no_compra")
public class NoCompras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idnum;
	
	@Column(name = "idproveedor")
	private Integer proveedores;
	
	@Column(name = "idcompra")
	private Integer detalle_compras;
	
	private String fecha;
	private double total;
	
	@Transient
	private proveedor proveedor;
	
	@Transient
	private detalle_compra detalle_compra;
	
	public Integer getIdnum() {
		return idnum;
	}
	public void setIdnum(Integer idnum) {
		this.idnum = idnum;
	}
	public Integer getProveedores() {
		return proveedores;
	}
	public void setProveedores(Integer proveedores) {
		this.proveedores = proveedores;
	}
	public Integer getDetalle_compras() {
		return detalle_compras;
	}
	public void setDetalle_compras(Integer detalle_compras) {
		this.detalle_compras = detalle_compras;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public detalle_compra getDetalle_compra() {
		return detalle_compra;
	}
	public void setDetalle_compra(detalle_compra detalle_compra) {
		this.detalle_compra = detalle_compra;
	}
	
	
}
