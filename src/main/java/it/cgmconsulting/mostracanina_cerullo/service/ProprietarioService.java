package it.cgmconsulting.mostracanina_cerullo.service;

import it.cgmconsulting.mostracanina_cerullo.repository.ProprietarioRepository;
import it.cgmconsulting.mostracanina_cerullo.response.ProprietarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietarioService {

    @Autowired
    ProprietarioRepository proprietarioRepository;
    public List<ProprietarioResponse> getProprietarioResponse(String nomeCane){

        return proprietarioRepository.getProprietarioResponse(nomeCane);

    }
}
