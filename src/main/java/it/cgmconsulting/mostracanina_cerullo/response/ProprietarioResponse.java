package it.cgmconsulting.mostracanina_cerullo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProprietarioResponse {

    private int id;
    private String nome;
    private String cognome ;
}
