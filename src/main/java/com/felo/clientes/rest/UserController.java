package com.felo.clientes.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felo.clientes.model.entities.User;
import com.felo.clientes.model.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
	
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody @Valid User usuario) {
		repository.save(usuario);
	}
}
