package com.crm.hsExtras.service;

import com.crm.hsExtras.dto.SmsGetDTO;
import com.crm.hsExtras.model.Operador;
import com.crm.hsExtras.model.Sms;
import com.crm.hsExtras.repository.IOperadoresRepository;
import com.crm.hsExtras.repository.ISmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsService {

    @Autowired
    private ISmsRepository smsRepository;

   @Autowired
   private IOperadoresRepository operadoresRepository;
    public List<Sms> listarSms(Short id_operador){
        Operador operador = operadoresRepository.findById(id_operador).get();
        return smsRepository.findSmsByOperador(operador);
    }

    public List<Sms> listarSmsXOperadorFecha(SmsGetDTO datos){
        Operador operador = operadoresRepository.findById(datos.getOperadorId()).get();
        return smsRepository.findSmsByOperadorAndStartDateBetween(operador,datos.getFechaDesde(), datos.getFechaHasta());

    }

    public Sms crearSms(Sms sms){
        return smsRepository.save(sms);
    }
}
