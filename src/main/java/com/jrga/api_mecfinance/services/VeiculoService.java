package com.jrga.api_mecfinance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrga.api_mecfinance.models.Veiculo;
import com.jrga.api_mecfinance.repositories.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public void deleteById(Integer id) {
		veiculoRepository.deleteById(id);
	}

	public void deleteAll() {
		veiculoRepository.deleteAll();
	}

	public Optional<Veiculo> findById(Integer id) {
		return veiculoRepository.findById(id);
	}

	public Veiculo update(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

    
}
