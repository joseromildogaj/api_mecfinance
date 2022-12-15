package com.jrga.api_mecfinance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrga.api_mecfinance.models.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
    
}
