package com.laCheleria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laCheleria.model.detalle_compra;
import com.laCheleria.repository.detalle_compraRepository;

@Service
public class Detalle_compraService implements IntDetalle_compraService {
	
	@Autowired
	private detalle_compraRepository repocompra;

	@Override
	public List<detalle_compra> listar() {
		return repocompra.findAll();
		}

	@Override
	public void guardar(detalle_compra detalle_compra) {
		repocompra.save(detalle_compra);

	}

	@Override
	public void actualizar(detalle_compra detalle_compra) {
		repocompra.save(detalle_compra);

	}

	@Override
	public void eliminar(Integer idcompra) {
		repocompra.deleteById(idcompra);

	}

	@Override
	public detalle_compra buscar(Integer idcompra) {
		Optional<detalle_compra> compra = repocompra.findById(idcompra);

		if (compra.isEmpty())
			return null;
		else
			return compra.get();
	}

	@Override
	public int totalProductos() {
		return (int) repocompra.count();
	}

}
