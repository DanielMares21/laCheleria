package com.laCheleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laCheleria.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

}
