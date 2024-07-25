package com.example.SitePGE.service;

import com.example.SitePGE.DTO.LoginDTO;
import com.example.SitePGE.entities.Procurador;
import com.example.SitePGE.repositories.ProcuradorRepo;
import com.example.SitePGE.response.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProcuradorService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProcuradorRepo procuradorRepo;

    public String addProcurador(Procurador procurador){
        Procurador procurador1 = new Procurador(
            procurador.getProcuradorid(), 
            procurador.getProcuradorname(), 
            procurador.getProcuradoremail(), 
            this.passwordEncoder.encode(procurador.getProcuradorpassword())
        );
        procuradorRepo.save(procurador1);

        return procurador.getProcuradorname();
    }

    public LoginResponse loginProcurador(LoginDTO loginDTO) {
        Procurador procurador = procuradorRepo.findByEmail(loginDTO.getEmail());

        if(procurador != null){
            String password = loginDTO.getPassword();
            String encodePassword = procurador.getProcuradorpassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if(isPwdRight){
                Optional<Procurador> procurador1 = procuradorRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
                if(procurador1.isPresent()){
                    return new LoginResponse("Login efetuado com sucesso!", true);
                }else{
                    return new LoginResponse("Login falhou!", false);
                }
            }
        } else {
            return new LoginResponse("Email não existe!", false);
        }
        return null;
    }
}
