package it.cgmconsulting.mostracanina_cerullo.controller;

import it.cgmconsulting.mostracanina_cerullo.response.GiudiceRequest;
import it.cgmconsulting.mostracanina_cerullo.response.GiudiceResponse;
import it.cgmconsulting.mostracanina_cerullo.service.GiudiciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("giudice")
@Validated
public class GiudiciController {

    @Autowired
    GiudiciService giudiciService;

    @GetMapping("votominimo")
    public ResponseEntity<?> giudiceNegativo(@RequestParam @NotBlank int anno, String nomeMostra){
        LocalDate inputDate = LocalDate.of(anno, 01, 01);
        return new ResponseEntity<>(giudiciService.getGiudiceResponse(inputDate, nomeMostra), HttpStatus.OK);
    }
}
