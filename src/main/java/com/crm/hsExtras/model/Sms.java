package com.crm.hsExtras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tx_sms_2")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sms_id")
    private Long id;

    @Column(name = "sms_nroppto")
    private Long nroPpto;

    @Column(name = "sms_fecha_envio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fechaEntrada;

    @Column(name = "sms_descripcion")
    private String descripcion;

    @Column(name = "sms_telefono")
    private String telefono;

    @Column(name = "sms_modo")
    private String modo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sms_operador", referencedColumnName = "op_codoper")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Operador operador;

    @Column(name = "sms_fecha_hasta")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fechaSalida;

    @Column(name = "sms_latitud")
    @JsonIgnore
    private Integer latitud;

    @Column(name = "sms_longitud")
    @JsonIgnore
    private Integer longitud;

    @Column(name = "sms_latitud_sal")
    @JsonIgnore
    private Integer latitud_sal;

    @Column(name = "sms_longitud_sal")
    @JsonIgnore
    private Integer longitud_sal;


}
