package com.laCheleria.service;

import java.util.List;

import com.laCheleria.model.detalle_compra;



public interface IntDetalle_compraService {

	public  List<detalle_compra> listar();
	public void guardar(detalle_compra detalle_compra);
	public void actualizar(detalle_compra detalle_compra);
	public void eliminar(Integer idcompra);
	public detalle_compra buscar(Integer idcompra);
	public int totalProductos();
	
}
