package com.laCheleria.service;

import java.util.List;
import com.laCheleria.model.proveedor;
public interface IntProveedorService {
	public  List<proveedor> listar();
	public void guardar(proveedor proveedor);
	public void actualizar(proveedor proveedor);
	public void eliminar(Integer idproveedor);
	public proveedor buscar(Integer idproveedor);
	public int totalProductos();

}
