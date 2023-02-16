package it.cgmconsulting.mostracanina_cerullo.controller;

import it.cgmconsulting.mostracanina_cerullo.response.CaneResponse;
import it.cgmconsulting.mostracanina_cerullo.response.CaneVincitore;
import it.cgmconsulting.mostracanina_cerullo.service.CaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cane")
public class CaneController {

    @Autowired
    CaneService caneService;

    @GetMapping("lista")
    public ResponseEntity<?> getListaCane(){

        return new ResponseEntity<>(caneService.getCaneResponse(), HttpStatus.OK);
    }

    @GetMapping("vincitore")
    public ResponseEntity<?> vincitoreCane(@RequestParam @NotBlank int anno, String nomeMostra){

        //List vincitore = caneService.getVincitoreResponse(anno, nomeMostra);
        //return new ResponseEntity<>(vincitore, HttpStatus.OK);

            LocalDate inputDate = LocalDate.of(anno, 01, 01);
        Optional<CaneVincitore> c= caneService.getVincitoreResponse(inputDate, nomeMostra);
        List <String> caneVincitore=new ArrayList<>();
        caneVincitore.add("codice cane: "+c.get().getCodiceCane());
        caneVincitore.add("nome cane: "+c.get().getNome());
        caneVincitore.add("media: "+c.get().getAvg());
            return new ResponseEntity<>(caneVincitore, HttpStatus.OK);
        }


    @GetMapping("giovane")
    public ResponseEntity<?> getCaneYounger(){

        List<CaneResponse> caneGiovane= caneService.getCaneYounger();
        if (caneGiovane.isEmpty()){
            return new ResponseEntity<>("Cani non trovati", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(caneGiovane.get(0), HttpStatus.OK);
    }

    @GetMapping("noMostra")
    public ResponseEntity<?> getCaneNoMostra(){

        return new ResponseEntity<>(caneService.getCaneNoMostra(), HttpStatus.OK);
    }
}
