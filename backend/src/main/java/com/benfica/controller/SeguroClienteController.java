package com.benfica.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benfica.dto.SeguroImovelDTO;
import com.benfica.dto.SeguroVeiculoDTO;
import com.benfica.model.Cliente;
import com.benfica.model.Seguro;
import com.benfica.service.impl.ClienteServiceImpl;
import com.benfica.service.impl.ImovelServiceImpl;
import com.benfica.service.impl.VeiculoServiceImpl;

@RestController
@RequestMapping("/seguro")
public class SeguroClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@Autowired
	private VeiculoServiceImpl veiculoServiceImpl;
	
	@Autowired	
	private ImovelServiceImpl imovelServiceImpl;
	
	@PostMapping("/veiculo/{cpfCliente}")
	public ResponseEntity<String> cadastrarSeguroVeiculo(@PathVariable("cpfCliente") String cpfCliente, @RequestBody SeguroVeiculoDTO seguroVeiculoDTO) {
		
		try {
			Cliente cliente = new Cliente();
			Long idSeguro = null;
			cliente = clienteServiceImpl.buscarPorCpf(cpfCliente);
			
			List<Seguro> listaSeguros = cliente.getSeguro();
			
			for(Seguro seguro : listaSeguros) {
				if(seguro.getTipoSeguro().getId() == 1 && seguro.isAtivo() == true) {
					idSeguro = seguro.getId();
				}
			}
			
			String retorno = veiculoServiceImpl.cadastrar(seguroVeiculoDTO, idSeguro);
			return  new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao cadastrar o seguro do veículo do cliente");
		}
	}
	
	@PostMapping("/imovel/{cpfCliente}")
	public ResponseEntity<String> cadastrarSeguroImovel(@PathVariable("cpfCliente") String cpfCliente, @RequestBody SeguroImovelDTO seguroImovelDTO) {
		
		try {
			Cliente cliente = new Cliente();
			Long idSeguro = null;
			cliente = clienteServiceImpl.buscarPorCpf(cpfCliente);
			
			List<Seguro> listaSeguros = cliente.getSeguro();
			
			for(Seguro seguro : listaSeguros) {
				if(seguro.getTipoSeguro().getId() == 2 && seguro.isAtivo() == true) {
					idSeguro = seguro.getId();
				}
			}
			
			String retorno = imovelServiceImpl.cadastrar(seguroImovelDTO, idSeguro);
			return  new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao cadastrar o seguro do imóvel do cliente");
		}
	}
}
