package it.cgmconsulting.mostracanina_cerullo.repository;

import it.cgmconsulting.mostracanina_cerullo.entity.Proprietario;
import it.cgmconsulting.mostracanina_cerullo.response.CaneResponse;
import it.cgmconsulting.mostracanina_cerullo.response.ProprietarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

    @Query(value = "SELECT p.id_proprietario, p.nome, p.cognome "
           +"FROM cane c, proprietario p"
           +" WHERE p.id_proprietario=c.id_proprietario AND c.nome= :nomeCane",nativeQuery = true
    )
    List getProprietarioResponse(@Param("nomeCane") String nomeCane);
}
