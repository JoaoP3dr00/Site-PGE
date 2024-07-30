package com.example.SitePGE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SitePGE.entities.Movimentacao;
import com.example.SitePGE.entities.Processo;
import com.example.SitePGE.repositories.ProcessoRepo;
import com.example.SitePGE.service.MovimentacaoService;

@RestController
@RequestMapping("SitePGE/api/home/processo/{numero_processo}/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ProcessoRepo processoRepo;

    @PostMapping(path="/registrar-movimentacao")
    public ResponseEntity<?> registrarMovimentacao(@PathVariable String numero_processo, @RequestBody Movimentacao movimentacao){
        Processo processo = processoRepo.findByNumeroProcesso(numero_processo);

        if(processo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado!");

        String tipo = movimentacaoService.addMovimentacao(movimentacao, processo);

        return ResponseEntity.ok("Movimentacao do tipo " + tipo + " para o processo " + processo.getVara() + " registrada com sucesso!");
    }
}
