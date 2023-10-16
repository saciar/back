package com.crm.hsExtras.repository;

import com.crm.hsExtras.model.ModalidadOperador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModalidadOperadorRepository extends JpaRepository<ModalidadOperador, Long> {
}
