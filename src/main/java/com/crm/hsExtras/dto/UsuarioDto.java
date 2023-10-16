package com.crm.hsExtras.dto;

import com.crm.hsExtras.model.Operador;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {

    private Long id;

    private String email;

    private String username;

    private Operador operador;

}
