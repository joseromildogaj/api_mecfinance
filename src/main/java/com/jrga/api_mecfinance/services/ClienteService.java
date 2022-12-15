package com.jrga.api_mecfinance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrga.api_mecfinance.models.Cliente;
import com.jrga.api_mecfinance.repositories.ClienteRepositorio;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepository;


    public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteById(Integer id) {
		clienteRepository.deleteById(id);
	}

	public void deleteAll() {
		clienteRepository.deleteAll();
	}

	public Optional<Cliente> findById(Integer id) {
		return clienteRepository.findById(id);
	}

	public Cliente update(int id, Cliente clienteAlterado) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteAlterado.getId());
		cliente.setCpf(clienteAlterado.getCpf());
		cliente.setNome(clienteAlterado.getNome());
		cliente.setTelefone(clienteAlterado.getTelefone());
		cliente.setEndereco(clienteAlterado.getEndereco());
		cliente.setVeiculos(clienteAlterado.getVeiculos());
		return cliente;
	}
   
}
