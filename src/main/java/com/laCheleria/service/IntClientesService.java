package com.laCheleria.service;

import java.util.List;

import com.laCheleria.model.Clientes;

public interface IntClientesService {
	public  List<Clientes> listar();
	public void guardar(Clientes cliente);
	public void actualizar(Clientes cliente);
	public void eliminar(Integer idcliente);
	public Clientes buscar(Integer idcliente);
	public int totalProductos();

}
