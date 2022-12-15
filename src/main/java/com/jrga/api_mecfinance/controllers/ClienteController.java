package com.jrga.api_mecfinance.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrga.api_mecfinance.models.Cliente;
import com.jrga.api_mecfinance.services.ClienteService;

@RestController
@RequestMapping(value = "mecfinance/clientes")
public class ClienteController {

    @Autowired
	public ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes = clienteService.findAll();
		//List<Cliente> list = clienteService.findAll();
		if (listaClientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listaClientes);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> pesquisaContato(@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		clienteService.save(cliente);		
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		Optional<Cliente> optional = clienteService.findById(id);
		if(optional.isPresent()){
			Cliente clienteAlterado = clienteService.update(id, cliente);
			return ResponseEntity.ok().body(clienteAlterado);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removeById(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		if (cliente.isPresent()) {
			clienteService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		clienteService.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

    
}
