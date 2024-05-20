package com.laCheleria.service;

import java.util.List;
import com.laCheleria.model.detalle_pedido;

public interface IntDetalles_pedidoService {
	public  List<detalle_pedido> listar();
	public void guardar(detalle_pedido detalle_pedido);
	public void actualizar(detalle_pedido detalle_pedido);
	public void eliminar(Integer idDetalle_pedido);
	public detalle_pedido buscar(Integer idDetalle_pedido);
	public int totalProductos();

}
