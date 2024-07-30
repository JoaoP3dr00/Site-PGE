package com.example.SitePGE.controllers;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SitePGE.Config.TokenService;
import com.example.SitePGE.DTO.LoginDTO;
import com.example.SitePGE.DTO.ResponseDTO;
import com.example.SitePGE.entities.Procurador;
import com.example.SitePGE.repositories.ProcuradorRepo;
import com.example.SitePGE.service.ProcuradorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/SitePGE/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final ProcuradorRepo procuradorRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final ProcuradorService procuradorService;

    @CrossOrigin    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        Procurador procurador = this.procuradorRepo.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new RuntimeException("Procurador não encontrado!"));
        if(passwordEncoder.matches(loginDTO.getPassword(), procurador.getProcuradorpassword())){
            String token = this.tokenService.generateToken(procurador);
            return ResponseEntity.ok(new ResponseDTO(procurador.getProcuradorname(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @CrossOrigin
    @PostMapping(path="/register")
    public ResponseEntity<?> registerProcurador(@RequestBody Procurador procurador_register){
        Optional<Procurador> procurador = this.procuradorRepo.findByEmail(procurador_register.getProcuradoremail());
        if(procurador.isEmpty()){
            procuradorService.addProcurador(procurador_register);
            String token = this.tokenService.generateToken(procurador_register);
            return ResponseEntity.ok(new ResponseDTO(procurador_register.getProcuradorname(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
