package com.crm.hsExtras.service;

import com.crm.hsExtras.model.ModalidadOperador;
import com.crm.hsExtras.repository.IModalidadOperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadOperadorService {

    @Autowired
    private IModalidadOperadorRepository modalidadOperadorRepository;

    public List<ModalidadOperador> listarModalidadesOperadores(){
        return modalidadOperadorRepository.findAll();
    }
}
