package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class MostraCaninaId implements Serializable {

    @Column(length = 100)
    private String nomeMostra;

    @Column(nullable = false, columnDefinition = "YEAR")
    private LocalDate anno;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MostraCaninaId that)) return false;
        return Objects.equals(nomeMostra, that.nomeMostra) && Objects.equals(anno, that.anno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMostra, anno);
    }
}
