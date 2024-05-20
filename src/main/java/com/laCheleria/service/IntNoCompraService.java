package com.laCheleria.service;

import java.util.List;

import com.laCheleria.model.NoCompras;

public interface IntNoCompraService {
	
	public  List<NoCompras> listar();
	public void guardar(NoCompras NoCompras);
	public void actualizar(NoCompras NoCompras);
	public void eliminar(Integer idnum);
	public NoCompras buscar(Integer idnum);
	public int totalProductos();

}
