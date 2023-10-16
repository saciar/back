package com.crm.hsExtras.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
        return "accediste con rol de ADMIN";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('USER')")
    public String accessUser(){
        return "accediste con rol de USER";
    }

    @GetMapping("/accessOperator")
    @PreAuthorize("hasRole('OPERATOR')")
    public String accessOperator(){
        return "accediste con rol de OPERATOR";
    }

    @GetMapping("/accessAdminUser")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String accessAdminUser(){
        return "accediste con rol de ADMIN y USER";
    }
}
