package com.crm.hsExtras.controller;

import com.crm.hsExtras.dto.SmsGetDTO;
import com.crm.hsExtras.model.Sms;
import com.crm.hsExtras.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/{id}")
    public List<Sms> listarTodos(@PathVariable(name = "id") Short operador_id){
        return smsService.listarSms(operador_id);
    }

    @GetMapping
    public List<Sms> listarTodosxoepradorFechas(@RequestBody SmsGetDTO datos){
        return smsService.listarSmsXOperadorFecha(datos);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Sms crearSms(@RequestBody Sms sms){
        return smsService.crearSms(sms);
    }
}
