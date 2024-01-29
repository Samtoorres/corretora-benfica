package com.benfica.repository;

import com.benfica.model.Seguro;
import com.benfica.model.Vida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface VidaRepository extends JpaRepository<Vida, Long> {

    @Modifying
    void deleteBySeguro(Seguro seguro);
}
