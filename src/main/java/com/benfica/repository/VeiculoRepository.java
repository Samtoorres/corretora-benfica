package com.benfica.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.benfica.model.Seguro;
import com.benfica.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Modifying
	//@Query("DELETE FROM veiculo WHERE SEGURO_ID = :id")
	void deleteBySeguro(Seguro seguro);

}
