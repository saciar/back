package com.crm.hsExtras.controller;

import com.crm.hsExtras.dto.OperadorDto;
import com.crm.hsExtras.model.Operador;
import com.crm.hsExtras.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operadores")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @GetMapping("/listar")
    public List<OperadorDto> listarTodos(){
        return operadorService.listarOperadores();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Operador crearOperador(@RequestBody Operador operador){
        return operadorService.crearOActualizar(operador);
    }



}
