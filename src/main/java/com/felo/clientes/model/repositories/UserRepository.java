package com.felo.clientes.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felo.clientes.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
