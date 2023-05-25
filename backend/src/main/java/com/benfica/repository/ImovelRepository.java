package com.benfica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benfica.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

}
