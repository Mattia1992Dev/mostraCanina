package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cane {

    @Id
    @Column(length = 10, nullable = false)
    private String codiceCane;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDateTime dataNascita ;

    @Column(nullable = false)
    private byte altezza;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    @Column (nullable = false)
    private BigDecimal peso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_proprietario", nullable = false)
    private Proprietario proprietario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codice_razza", nullable = false)
    private Razza razza;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cane cane)) return false;
        return Objects.equals(codiceCane, cane.codiceCane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceCane);
    }
}
