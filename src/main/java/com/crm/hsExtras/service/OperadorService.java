package com.crm.hsExtras.service;

import com.crm.hsExtras.dto.OperadorDto;
import com.crm.hsExtras.model.Operador;
import com.crm.hsExtras.repository.IOperadoresRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperadorService {

    @Autowired
    private IOperadoresRepository operadoresRepository;

    public Operador crearOActualizar(Operador operador){
        return operadoresRepository.save(operador);
    }

    public List<OperadorDto> listarOperadores(){
        ObjectMapper mapper = new ObjectMapper();
        List<OperadorDto> operadorDtos = new ArrayList<>();
        List<Operador> operadores = operadoresRepository.findOperadoresActivos("S");
        for(Operador p : operadores){
            OperadorDto pacienteDto = mapper.convertValue(p, OperadorDto.class);
            operadorDtos.add(pacienteDto);
        }
        return operadorDtos;
    }

    public Operador getOperadorById(Short id){
        Optional<Operador> optional = operadoresRepository.findById(id);
        Operador operador = null;
        if(!optional.isEmpty()){
            operador = optional.get();
        }
        return operador;
    }
}
