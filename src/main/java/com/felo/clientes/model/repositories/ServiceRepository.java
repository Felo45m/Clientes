package com.felo.clientes.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.clientes.model.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer>{

}
