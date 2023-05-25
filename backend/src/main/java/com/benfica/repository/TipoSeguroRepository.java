package com.benfica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benfica.model.TipoSeguro;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSeguroRepository extends JpaRepository<TipoSeguro, Long> {

}
