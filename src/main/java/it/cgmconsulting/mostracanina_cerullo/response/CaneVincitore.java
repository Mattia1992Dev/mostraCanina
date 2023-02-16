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
public class CaneVincitore {

    private String codiceCane;
    private String nome;
    private double avg;
    private BigDecimal scostamento;

    public CaneVincitore(String codiceCane, String nome, double avg) {
        this.codiceCane = codiceCane;
        this.nome = nome;
        this.avg = avg;
    }
}
