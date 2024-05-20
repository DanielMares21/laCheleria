package com.laCheleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laCheleria.model.proveedor;
import com.laCheleria.repository.ProveedorRepository;

@Service
public class ProveedorService implements IntProveedorService {
	
	@Autowired
	private ProveedorRepository proverepo;

	@Override
	public List<proveedor> listar() {
		return proverepo.findAll();
	}

	@Override
	public void guardar(proveedor proveedor) {
		proverepo.save(proveedor);

	}

	@Override
	public void actualizar(proveedor proveedor) {
		proverepo.save(proveedor);

	}

	@Override
	public void eliminar(Integer idproveedor) {
		proverepo.deleteById(idproveedor);

	}

	@Override
	public proveedor buscar(Integer idproveedor) {
		Optional<proveedor> proveedor = proverepo.findById(idproveedor);

		if (proveedor.isEmpty())
			return null;
		else
			return proveedor.get();
	}
	

	@Override
	public int totalProductos() {
		return (int) proverepo.count();
	}

}
