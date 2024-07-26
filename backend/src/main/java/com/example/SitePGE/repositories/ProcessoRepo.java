package com.example.SitePGE.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SitePGE.entities.Processo;

public interface ProcessoRepo extends JpaRepository<Processo, Integer> {
    List<Processo> findByNumeroProcessoContainingIgnoreCase(String numeroProcesso);
}
