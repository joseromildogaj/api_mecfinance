package com.jrga.api_mecfinance.controllers;

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

import com.jrga.api_mecfinance.models.Endereco;
import com.jrga.api_mecfinance.services.EnderecoService;

@RestController
@RequestMapping(value ="mecfinance/enderecos")
public class EnderecoController {

    @Autowired
	public EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<Endereco>> listarContatos() {
		List<Endereco> list = enderecoService.findAll();
		if (list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> pesquisaContato(@PathVariable Integer id) {
		Optional<Endereco> endereco = enderecoService.findById(id);
		if (endereco.isPresent()) {
			return ResponseEntity.ok(endereco);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
		enderecoService.save(endereco);
		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
		Optional<Endereco> end = enderecoService.findById(id);
		if (end.isPresent()) {
			enderecoService.save(endereco);
			return ResponseEntity.ok().body(endereco);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removeById(@PathVariable("id") Integer id) {
		Optional<Endereco> endereco = enderecoService.findById(id);
		if (endereco.isPresent()) {
			enderecoService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		enderecoService.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
 
    
}
