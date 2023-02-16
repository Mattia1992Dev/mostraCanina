package it.cgmconsulting.mostracanina_cerullo.controller;

import it.cgmconsulting.mostracanina_cerullo.response.ProprietarioResponse;
import it.cgmconsulting.mostracanina_cerullo.service.CaneService;
import it.cgmconsulting.mostracanina_cerullo.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("proprietario")
public class ProprietarioController {

    @Autowired
    ProprietarioService proprietarioService;

    @GetMapping("cerca")
    public ResponseEntity<?> getListaCane(@RequestParam @NotBlank String nomeCane){

        List<ProprietarioResponse> proprietario= proprietarioService.getProprietarioResponse(nomeCane);
        if (proprietario.isEmpty()){
            return new ResponseEntity<>("Proprietario non trovato", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proprietarioService.getProprietarioResponse(nomeCane), HttpStatus.OK);
    }

}
