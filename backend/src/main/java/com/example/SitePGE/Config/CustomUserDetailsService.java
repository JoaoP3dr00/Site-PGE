package com.example.SitePGE.Config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.SitePGE.entities.Procurador;
import com.example.SitePGE.repositories.ProcuradorRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private ProcuradorRepo procuradorRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Procurador procurador = this.procuradorRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Procurador não encontrado!"));

        return new org.springframework.security.core.userdetails.User(procurador.getProcuradoremail(), procurador.getProcuradorpassword(), new ArrayList<>());
    }
}
