package com.benfica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benfica.BenficaApiApplication;
import com.benfica.dto.AtualizarClienteDTO;
import com.benfica.dto.ClienteDTO;
import com.benfica.model.Cliente;
import com.benfica.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	private static final Logger LOGGER = Logger.getLogger(BenficaApiApplication.class.getName());
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarCliente(@PathVariable("id") Long id) {
		
		try {
			Cliente cliente = clienteServiceImpl.buscar(id);
			return ResponseEntity.ok(cliente);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		}
	}
	
	@GetMapping("/buscar/lista")
	public ResponseEntity<?> buscarListaClientes() {
		
		try {
			List<Cliente> clientes = new ArrayList<>();
			clientes = clienteServiceImpl.buscarLista();
			return ResponseEntity.ok(clientes);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível buscar a lista de clientes cadastrados");
		}
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
		
		try {
			Cliente cliente = clienteServiceImpl.cadastrar(clienteDTO);
			return ResponseEntity.ok(cliente);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar o cliente");
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizarCliente(@RequestBody AtualizarClienteDTO atualizarUsuarioDTO) {
		
		try {
			String retorno = clienteServiceImpl.atualizar(atualizarUsuarioDTO);
			return  new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível atualizar os dados do cliente");
		}
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirCliente(@PathVariable("id") Long id) {
		
		try {
			String retorno = clienteServiceImpl.excluir(id);
			return  new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível excluir os dados do cliente");
		}
	}
}
