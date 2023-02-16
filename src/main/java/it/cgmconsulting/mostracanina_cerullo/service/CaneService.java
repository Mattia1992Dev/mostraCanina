package it.cgmconsulting.mostracanina_cerullo.service;

import it.cgmconsulting.mostracanina_cerullo.repository.CaneRepository;
import it.cgmconsulting.mostracanina_cerullo.response.CaneResponse;
import it.cgmconsulting.mostracanina_cerullo.response.CaneResponseRazza;
import it.cgmconsulting.mostracanina_cerullo.response.CaneVincitore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CaneService {

    @Autowired
    CaneRepository caneRepository;

    public List<CaneResponse> getCaneResponse(){
        return caneRepository.getCaneResponse();
    }

    public Optional<CaneVincitore> getVincitoreResponse(LocalDate anno, String nomeMostra){
        return caneRepository.getVincitoreResponse(anno, nomeMostra);
    }

    public List<CaneResponse> getCaneYounger(){
        return caneRepository.getCaneYounger();
    }

    public List<CaneResponseRazza> getCaneNoMostra(){
        return caneRepository.getCaneNoMostra();
    }

}
