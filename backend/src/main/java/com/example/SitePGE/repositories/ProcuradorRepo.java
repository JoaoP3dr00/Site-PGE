package com.example.SitePGE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SitePGE.entities.Procurador;

import java.util.Optional;

public interface ProcuradorRepo extends JpaRepository<Procurador, Integer>{
    Optional<Procurador> findOneByEmailAndPassword(String email, String password);
    Optional<Procurador> findByEmail(String email);
}
