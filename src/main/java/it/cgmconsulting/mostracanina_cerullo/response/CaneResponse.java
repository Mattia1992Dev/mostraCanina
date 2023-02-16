package it.cgmconsulting.mostracanina_cerullo.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaneResponse {


        private String codiceCane;
        private String nome;
        private LocalDateTime dataNascita ;
}
