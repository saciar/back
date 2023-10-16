package com.crm.hsExtras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "mst_operadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_codoper")
    private Short id;

    @Column(name = "apynom")
    private String nombreApellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "olvidos")
    private Integer olvidos;

    @Column(name = "activo")
    private String activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modalidad_oper", referencedColumnName = "mod_op_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ModalidadOperador modalidadOperador;

    @OneToMany(mappedBy = "operador")
    @JsonIgnore
    private Set<Sms> mensajes;

}
