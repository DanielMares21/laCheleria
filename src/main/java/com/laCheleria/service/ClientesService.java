package com.laCheleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laCheleria.model.Clientes;
import com.laCheleria.repository.ClientesRepository;
@Service
public class ClientesService implements IntClientesService {
	
	@Autowired
	private ClientesRepository cliRepo;

	@Override
	public List<Clientes> listar() {
		return cliRepo.findAll();
	}

	@Override
	public void guardar(Clientes cliente) {
		cliRepo.save(cliente);

	}

	@Override
	public void eliminar(Integer id) {
		cliRepo.deleteById(id);

	}

	@Override
	public Clientes buscar(Integer idcliente) {
		Optional<Clientes> cliente = cliRepo.findById(idcliente);

		if (cliente.isEmpty())
			return null;
		else
			return cliente.get();
	
	}

	@Override
	public int totalProductos() {
		return (int) cliRepo.count();
	}
	
	@Override
	public void actualizar(Clientes cliente) {
		cliRepo.save(cliente);
		
	}


}
