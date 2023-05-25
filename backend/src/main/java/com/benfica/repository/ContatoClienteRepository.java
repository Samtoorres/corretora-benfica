package com.benfica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benfica.model.ContatoCliente;

@Repository
public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Long> {

}
