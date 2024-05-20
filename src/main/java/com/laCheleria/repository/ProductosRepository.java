package com.laCheleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laCheleria.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer>{

}
