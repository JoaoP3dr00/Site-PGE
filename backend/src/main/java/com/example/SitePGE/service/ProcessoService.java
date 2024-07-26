package com.example.SitePGE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SitePGE.entities.Processo;
import com.example.SitePGE.repositories.ProcessoRepo;

@Service
public class ProcessoService {
    @Autowired
    private ProcessoRepo processoRepo;

    public String addProcesso(Processo processo){
        Processo processo1 = new Processo(
            processo.getId(),
            processo.getNumeroProcesso(),
            processo.getValorDivida(),
            processo.getJuiz(),
            processo.getVara(),
            processo.getExecutado(),
            processo.getDataDistribuicao(),
            processo.getDataPrescricao(),
            processo.getStatusPrescricao(),
            processo.getTipoAssunto(),
            processo.getDescricao()
        );
        processoRepo.save(processo1);

        return processo1.getNumeroProcesso();
    }    
}
