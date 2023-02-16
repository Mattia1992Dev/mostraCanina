package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Razza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte codiceRazza;

    @Column(length = 100, nullable = false)
    private String nomeRazza;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    @Column (nullable = false)
    private BigDecimal pesoStandard;

    @Column(nullable = false)
    private byte altezzaStandard;
}
