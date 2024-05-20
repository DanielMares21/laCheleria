package com.laCheleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laCheleria.model.detalle_pedido;
import com.laCheleria.repository.detalle_pedidoRepository;

@Service
public class Detalles_pedidoService implements IntDetalles_pedidoService {
	
	@Autowired
	private detalle_pedidoRepository repoDetalle;

	@Override
	public List<detalle_pedido> listar() {
		return repoDetalle.findAll();
	}

	@Override
	public void guardar(detalle_pedido detalle_pedido) {
		repoDetalle.save(detalle_pedido);

	}

	@Override
	public void eliminar(Integer idDetalle_pedido) {
		repoDetalle.deleteById(idDetalle_pedido);

	}

	@Override
	public detalle_pedido buscar(Integer idDetalle_pedido) {
		Optional<detalle_pedido> detalle = repoDetalle.findById(idDetalle_pedido);

		if (detalle.isEmpty())
			return null;
		else
			return detalle.get();
	}

	@Override
	public int totalProductos() {
		return (int) repoDetalle.count();
	}

	@Override
	public void actualizar(detalle_pedido detalle_pedido) {
		repoDetalle.save(detalle_pedido);
		
	}

}
