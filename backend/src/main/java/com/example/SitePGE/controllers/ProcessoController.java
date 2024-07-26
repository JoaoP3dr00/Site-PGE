package com.example.SitePGE.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.SitePGE.entities.Processo;
import com.example.SitePGE.repositories.ProcessoRepo;
import com.example.SitePGE.service.ProcessoService;


@RestController
@RequestMapping("SitePGE/api/home")
public class ProcessoController {
   @Autowired
   private ProcessoService processoService;


   @Autowired
   private ProcessoRepo processoRepo;


   @PostMapping(path="/registrar-processo")
   public ResponseEntity<?> registerProcess(@RequestBody Processo processo){
       String nome = processoService.addProcesso(processo);
       return ResponseEntity.ok("Processo " + nome + "registrado com sucesso!");
   }


   @PostMapping(path="/procurar-processo-por-numero")
   public List<Processo> procurarProcesso(@RequestParam(required = false) String numeroProcesso){
       List<Processo> listaProcessos;


       if(numeroProcesso == null || numeroProcesso.trim().isEmpty()){
           listaProcessos = processoRepo.findAll();
       } else {
           listaProcessos = processoRepo.findByNumeroProcessoContainingIgnoreCase(numeroProcesso);  
       }


       return listaProcessos;
   }
   // GET TODOS OS PROCESSOS
}
