package com.felo.clientes.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.clientes.model.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
