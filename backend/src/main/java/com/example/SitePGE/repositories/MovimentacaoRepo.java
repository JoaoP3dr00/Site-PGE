package com.example.SitePGE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SitePGE.entities.Movimentacao;

public interface MovimentacaoRepo extends JpaRepository<Movimentacao, Integer> {
    
}
