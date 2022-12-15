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

import com.jrga.api_mecfinance.models.Veiculo;
import com.jrga.api_mecfinance.services.VeiculoService;

@RestController
@RequestMapping(value ="mecfinance/veiculos")
public class VeiculoController {

    @Autowired
	public VeiculoService veiculoService;


	@GetMapping
	public ResponseEntity<List<Veiculo>> listarContatos() {
		List<Veiculo> list = veiculoService.findAll();
		if (list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> pesquisaContato(@PathVariable Integer id) {
		Optional<Veiculo> veiculo = veiculoService.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(veiculo);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
		veiculoService.save(veiculo);
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Veiculo veiculo) {
		Optional<Veiculo> vec = veiculoService.findById(id);
		if (vec.isPresent()) {
			veiculoService.save(veiculo);
			return ResponseEntity.ok().body(veiculo);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removeById(@PathVariable("id") Integer id) {
		Optional<Veiculo> veiculo = veiculoService.findById(id);
		if (veiculo.isPresent()) {
			veiculoService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		veiculoService.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
    
}
