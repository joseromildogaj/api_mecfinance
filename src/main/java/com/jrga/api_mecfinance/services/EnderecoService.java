package com.jrga.api_mecfinance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrga.api_mecfinance.models.Endereco;
import com.jrga.api_mecfinance.repositories.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public void deleteById(Integer id) {
		enderecoRepository.deleteById(id);
	}

	public void deleteAll() {
		enderecoRepository.deleteAll();
	}

	public Optional<Endereco> findById(Integer id) {
		return enderecoRepository.findById(id);
	}

	public Endereco update(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

    
}
