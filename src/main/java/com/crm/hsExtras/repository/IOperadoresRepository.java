package com.crm.hsExtras.repository;

import com.crm.hsExtras.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOperadoresRepository extends JpaRepository<Operador, Short> {

    @Query(value = "Select o from Operador o where o.activo=?1 order by o.nombreApellido")
    public List<Operador> findOperadoresActivos(String activo);
}
