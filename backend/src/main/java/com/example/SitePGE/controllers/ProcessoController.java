package com.example.SitePGE.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SitePGE.entities.Processo;
import com.example.SitePGE.repositories.ProcessoRepo;
import com.example.SitePGE.service.ProcessoService;

@RestController
@RequestMapping("SitePGE/api/home/processos")
public class ProcessoController {
    @Autowired
    private ProcessoService processoService;

    @Autowired
    private ProcessoRepo processoRepo;

    @PostMapping(path="/registrar-processo")
    public ResponseEntity<?> registerProcess(@RequestBody Processo processo){
        String numero = processoService.addProcesso(processo);
        return ResponseEntity.ok("Processo de numero " + numero + " registrado com sucesso!");
    }

    @CrossOrigin(origins={"http://localhost:3000"})
    @GetMapping(path="/processo")
    public ResponseEntity<?> getProcess(@RequestParam String numeroProcesso){
        Processo processo = processoRepo.findByNumeroProcesso(numeroProcesso);

        if(processo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Processo não encontrado!");
        }

        return ResponseEntity.ok(processo);
    }

    @GetMapping(path="/procurar-processo-por-numero")
    public List<Processo> procurarProcesso(@RequestParam(required = false) String numeroProcesso){
        List<Processo> listaProcessos;

        if(numeroProcesso == null || numeroProcesso.trim().isEmpty()){
            listaProcessos = processoRepo.findAll();
        } else {
            listaProcessos = processoRepo.findByNumeroProcessoContainingIgnoreCase(numeroProcesso);  
        }

        return listaProcessos;
    }
}
