package com.example.SitePGE.controllers;

import com.example.SitePGE.DTO.LoginDTO;
import com.example.SitePGE.entities.Procurador;
import com.example.SitePGE.response.LoginResponse;
import com.example.SitePGE.service.ProcuradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("SitePGE/api")
public class ControllerProcurador {
    @Autowired
    private ProcuradorService procuradorService;

    @PostMapping(path="/register")
    public ResponseEntity<?> register(@RequestBody Procurador procurador){
        String nome = procuradorService.addProcurador(procurador);
        return ResponseEntity.ok("Procurador " + nome + " registrado com sucesso!");

    }

    @PostMapping(path="/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = procuradorService.loginProcurador(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
