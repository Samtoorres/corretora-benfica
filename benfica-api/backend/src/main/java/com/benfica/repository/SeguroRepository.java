package com.benfica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benfica.model.Seguro;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {

}
