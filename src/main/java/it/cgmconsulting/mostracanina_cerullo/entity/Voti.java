package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.BigIntegerType;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Check(constraints = "voto > 0 AND voto < 10")
public class Voti {

    @EmbeddedId
    private VotiId votiId;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=1, fraction=2)
    @Column (nullable = false)
    private BigDecimal voto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voti voti)) return false;
        return Objects.equals(votiId, voti.votiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votiId);
    }
}
