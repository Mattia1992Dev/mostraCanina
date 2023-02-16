package it.cgmconsulting.mostracanina_cerullo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Proprietario {

    @Id
    private int idProprietario;

    @Column(length = 100, nullable = false)
    private String cognome;

    @Column(length = 100, nullable = false)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proprietario that)) return false;
        return idProprietario == that.idProprietario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProprietario);
    }
}
