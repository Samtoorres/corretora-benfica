package com.benfica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benfica.dto.SeguroVeiculoDTO;
import com.benfica.model.Cliente;
import com.benfica.service.impl.ClienteServiceImpl;
import com.benfica.service.impl.VeiculoServiceImpl;

@RestController
@RequestMapping("/seguro")
public class SeguroClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@Autowired
	private VeiculoServiceImpl veiculoServiceImpl;
	
	@PostMapping("/veiculo/{cpfCliente}")
	public ResponseEntity<String> cadastrarSeguroVeiculo(@PathVariable("cpfCliente") String cpfCliente, @RequestBody SeguroVeiculoDTO seguroVeiculoDTO) {
		
		try {
			Cliente cliente = new Cliente();
			cliente = clienteServiceImpl.buscarPorCpf(cpfCliente);
			
			String retorno = veiculoServiceImpl.cadastrar(seguroVeiculoDTO, cliente.getSeguro().getId());
			return  new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível excluir os dados do cliente");
		}
	}
}
