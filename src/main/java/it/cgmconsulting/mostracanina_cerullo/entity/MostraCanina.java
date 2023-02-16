package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MostraCanina {

    @EmbeddedId
    MostraCaninaId mostraCaninaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MostraCanina that)) return false;
        return Objects.equals(mostraCaninaId, that.mostraCaninaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mostraCaninaId);
    }
}
