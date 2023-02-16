package it.cgmconsulting.mostracanina_cerullo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiudiceResponse {

    private String nome;

    private String cognome;

    private BigDecimal avg;



}
