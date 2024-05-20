package com.laCheleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laCheleria.model.NoCompras;
import com.laCheleria.repository.NoCompraRepository;

@Service
public class NoComprasService implements IntNoCompraService {
	
	@Autowired
	private NoCompraRepository Norepo;

	@Override
	public List<NoCompras> listar() {
		return Norepo.findAll();
	}

	@Override
	public void guardar(NoCompras NoCompras) {
		Norepo.save(NoCompras);

	}

	@Override
	public void actualizar(NoCompras NoCompras) {
		Norepo.save(NoCompras);

	}

	@Override
	public void eliminar(Integer idnum) {
		Norepo.deleteById(idnum);

	}

	@Override
	public NoCompras buscar(Integer idnum) {
		Optional<NoCompras> num = Norepo.findById(idnum);

		if (num.isEmpty())
			return null;
		else
			return num.get();
	}

	@Override
	public int totalProductos() {
       return (int) Norepo.count();
	}

}
