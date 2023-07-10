package com.benfica.repository;

import com.benfica.model.Cliente;
import com.benfica.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.benfica.model.ContatoCliente;

@Repository
public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Long> {

    @Modifying
    void deleteByClienteId(Long id);
}
