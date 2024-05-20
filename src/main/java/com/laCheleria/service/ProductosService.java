package com.laCheleria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laCheleria.model.Producto;
import com.laCheleria.repository.ProductosRepository;

@Service
public class ProductosService implements IntProductosService {
	
	
	 @Autowired
	    private ProductosRepository productosRepository;
	 
	@Override
	public List<Producto> listar() {
		return productosRepository.findAll();
	}

	@Override
	public void guardar(Producto productos) {
		productosRepository.save(productos);

	}

	@Override
	public void eliminar(Integer id) {
		productosRepository.deleteById(id);

	}

	@Override
	public Producto buscar(Integer id) {
		Optional<Producto> producto = productosRepository.findById(id);

		if (producto.isEmpty())
			return null;
		else
			return producto.get();
	}

	@Override
	public int totalProductos() {
	return (int) productosRepository.count();
	

	}
	@Override
	public void actualizar(Producto producto) {
	    productosRepository.save(producto);
	}

}
