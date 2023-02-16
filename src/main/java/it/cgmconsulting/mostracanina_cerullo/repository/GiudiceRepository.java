package it.cgmconsulting.mostracanina_cerullo.repository;


import it.cgmconsulting.mostracanina_cerullo.entity.Giudice;
import it.cgmconsulting.mostracanina_cerullo.response.GiudiceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface GiudiceRepository extends JpaRepository<Giudice, Integer> {

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_cerullo.response.GiudiceResponse("
            + "g.nome, "
            + "g.cognome,"
            + "AVG(v.voto)"
            + ") FROM Giudice g "
            + "INNER JOIN Voti v ON g.idGiudice=v.votiId.giudice.idGiudice "
            + "WHERE v.votiId.mostraCanina.mostraCaninaId.nomeMostra= :nomeMostra AND"
            + " v.votiId.mostraCanina.mostraCaninaId.anno= :anno "
            + "ORDER BY AVG(v.voto)"
    )
    List<GiudiceResponse> getGiudiceResponse(@Param("anno") LocalDate anno, @Param("nomeMostra") String nomeMostra);
}
