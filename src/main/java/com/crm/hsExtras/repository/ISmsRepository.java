package com.crm.hsExtras.repository;

import com.crm.hsExtras.model.Operador;
import com.crm.hsExtras.model.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ISmsRepository extends JpaRepository<Sms, Long> {

    @Query(value = "SELECT s FROM Sms s WHERE operador=?1")
    public List<Sms> findSmsByOperador(Operador operador);

    @Query(value = "SELECT s FROM Sms s WHERE operador=?1 AND fechaEntrada BETWEEN ?2 AND ?3")
    public List<Sms> findSmsByOperadorAndStartDateBetween(Operador operador, LocalDateTime fechaDesde, LocalDateTime fechaHasta);
}
