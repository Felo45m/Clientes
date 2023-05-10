package com.felo.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felo.clientes.model.entities.Client;
import com.felo.clientes.model.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	private final ClientRepository repository;

	@Autowired
	public ClientController(ClientRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client saveClient(@RequestBody Client client) {
		return repository.save(client);
	}
	
	@GetMapping("{id}")
	public Client findById(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		repository.findById(id).map(client -> {
			repository.delete(client);
			return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
