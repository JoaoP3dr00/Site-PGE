package com.example.SitePGE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SitePGE.entities.Movimentacao;
import com.example.SitePGE.entities.Processo;
import com.example.SitePGE.repositories.MovimentacaoRepo;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepo movimentacaoRepo;
    
    public String addMovimentacao(Movimentacao movimentacao, Processo processo){
        Movimentacao movimentacao1 = new Movimentacao(
            movimentacao.getM_id(),
            movimentacao.getTipo(),
            movimentacao.getDescricao(),
            movimentacao.getDataMovimentacao(),
            processo
        );

        movimentacaoRepo.save(movimentacao1);
        return movimentacao1.getTipo();
    }
}
