package com.laCheleria.model;
import jakarta.persistence.*;



@Entity
@Table(name="detalle_pedido")
public class detalle_pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;



	@Column(name = "idcliente")
	private Integer clientes;

	@Column(name = "id")
	private Integer productos;

	private String fecha;
	private double cantidad;
	private String unidad;
	private double precio_unitario;
	private double subtotal;
	private String fecha_entrega;

	@Transient
	private Producto producto;

	@Transient
	private Clientes cliente;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getClientes() {
		return clientes;
	}

	public void setClientes(Integer clientes) {
		this.clientes = clientes;
	}

	public Integer getProductos() {
		return productos;
	}

	public void setProductos(Integer productos) {
		this.productos = productos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
}
