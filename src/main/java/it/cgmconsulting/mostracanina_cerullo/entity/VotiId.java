package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotiId implements Serializable{

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="nome_mostra", referencedColumnName = "nomeMostra"),
            @JoinColumn(name="anno", referencedColumnName = "anno")
    })
    private MostraCanina mostraCanina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_giudice", nullable = false)
    private Giudice giudice;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codice_cane", nullable = false)
    private Cane cane;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VotiId votiId)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(giudice, votiId.giudice) && Objects.equals(cane, votiId.cane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), giudice, cane);
    }
}
