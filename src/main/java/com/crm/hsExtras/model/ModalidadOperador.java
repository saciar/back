package com.crm.hsExtras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mst_modalidad_operador")
public class ModalidadOperador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mod_op_id")
    private Long id;

    @Column(name = "mod_op_descripcion")
    private String nombre;

    @Column(name = "mod_op_activo")
    private String activo;

    @OneToMany(mappedBy = "modalidadOperador")
    @JsonIgnore
    private Set<Operador> operadores;

}
