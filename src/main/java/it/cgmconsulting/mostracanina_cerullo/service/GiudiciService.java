package it.cgmconsulting.mostracanina_cerullo.service;

import it.cgmconsulting.mostracanina_cerullo.repository.GiudiceRepository;
import it.cgmconsulting.mostracanina_cerullo.response.GiudiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;
import it.cgmconsulting.mostracanina_cerullo.entity.Giudice;

@Service
public class GiudiciService {

    @Autowired
    GiudiceRepository giudiceRepository;

    public List<Giudice> getGiudiceResponse(LocalDate data, String nomeMostra){

        return giudiceRepository.getGiudiceResponse(data, nomeMostra);
    }
}
