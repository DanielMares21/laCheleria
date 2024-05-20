package com.laCheleria.service;

import java.util.List;

import com.laCheleria.model.Producto;

public interface IntProductosService {
	
	
  	public  List<Producto> listar();
	public void guardar(Producto producto);
	public void actualizar(Producto producto);
	public void eliminar(Integer id);
	public Producto buscar(Integer id);
	public int totalProductos();

}
