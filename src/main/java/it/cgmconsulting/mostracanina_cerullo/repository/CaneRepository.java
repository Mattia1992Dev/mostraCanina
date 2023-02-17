package it.cgmconsulting.mostracanina_cerullo.repository;

import it.cgmconsulting.mostracanina_cerullo.entity.Cane;
import it.cgmconsulting.mostracanina_cerullo.response.CaneResponse;
import it.cgmconsulting.mostracanina_cerullo.response.CaneResponseRazza;
import it.cgmconsulting.mostracanina_cerullo.response.CaneVincitore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CaneRepository extends JpaRepository<Cane, String> {

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_cerullo.response.CaneResponse("
            + "c.codiceCane, "
            + "c.nome,"
            + "c.dataNascita "
            + ") FROM Cane c "
            + "ORDER BY c.dataNascita "
    )
    List<CaneResponse> getCaneResponse();

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_cerullo.response.CaneResponse("
            + "c.codiceCane, "
            + "c.nome,"
            + "c.dataNascita "
            + ") FROM Cane c "
            + "GROUP BY c.dataNascita "
            + "ORDER BY c.dataNascita DESC "

    )
    List<CaneResponse> getCaneYounger();

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_cerullo.response.CaneResponseRazza("
            + "r.codiceRazza "
            + ") FROM Razza r "
            + "LEFT JOIN Cane c ON r.codiceRazza=c.razza.codiceRazza "
            + "LEFT JOIN Voti  v ON c.codiceCane = v.votiId.cane.codiceCane "
            + "LEFT JOIN MostraCanina m ON v.votiId.mostraCanina.mostraCaninaId.nomeMostra = m.mostraCaninaId.nomeMostra "
            + "WHERE m.mostraCaninaId.nomeMostra IS NULL "
    )
    List<CaneResponseRazza> getCaneNoMostra();

   /* @Query(value = "SELECT c.`codice_cane`, c.`nome`, AVG(v.voto) AS punteggio_medio,  ((ABS(r.peso_standard-c.`peso`)/r.peso_standard)*100+(ABS((r.`altezza_standard`-c.`altezza`)/r.`altezza_standard`)*100)) AS percentuale_scostamento " +
            "FROM voti v, razza r, cane c " +
            "WHERE v.`codice_cane`=c.`codice_cane` AND r.`codice_razza`=c.`codice_razza` AND v.anno = :anno AND v.`nome_mostra`= :nomeMostra " +
            "GROUP BY v.codice_cane " +
            "ORDER BY punteggio_medio DESC, percentuale_scostamento LIMIT 5",nativeQuery = true
    )
    List  getVincitoreResponse(@Param("anno") int anno, @Param("nomeMostra") String nomeMostra );*/

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_cerullo.response.CaneVincitore("
            + "c.codiceCane,"
            + "c.nome, "
            + "AVG(v.voto) AS media, "
            + "((ABS(r.pesoStandard-c.peso)/r.pesoStandard)*100+(ABS((r.altezzaStandard-c.altezza)/r.altezzaStandard)*100)) AS scostamento"
            + ") FROM Razza r "
            + "LEFT JOIN Cane c ON r.codiceRazza=c.razza.codiceRazza "
            + "LEFT JOIN Voti v ON c.codiceCane = v.votiId.cane.codiceCane "
            + "WHERE v.votiId.mostraCanina.mostraCaninaId.nomeMostra= :nomeMostra AND"
            + " v.votiId.mostraCanina.mostraCaninaId.anno= :anno "
            + "GROUP BY c.codiceCane "
            + "ORDER BY media DESC, scostamento "
    )
    List<CaneVincitore> getVincitoreResponse(@Param("anno") LocalDate anno, @Param("nomeMostra") String nomeMostra );

}

