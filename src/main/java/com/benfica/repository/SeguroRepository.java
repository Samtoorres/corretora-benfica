package com.benfica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benfica.model.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

}
