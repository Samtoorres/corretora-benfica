package com.benfica.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benfica.dto.AtualizarUsuarioDTO;
import com.benfica.dto.UsuarioDTO;
import com.benfica.model.Usuario;
import com.benfica.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping("/{id}")
	public ResponseEntity<?> buscarUsuario(@PathVariable("id") Long id) {
		Usuario usuario = usuarioServiceImpl.buscar(id);
		
		if(Objects.nonNull(usuario)) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
		
		try {
			Usuario usuario = usuarioServiceImpl.cadastrarUsuario(usuarioDTO);
			return ResponseEntity.ok(usuario);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível criar o usuário");
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizarUsuario(@RequestBody AtualizarUsuarioDTO atualizarUsuarioDTO) {
		try {			
			String retorno = usuarioServiceImpl.atualizarUsuario(atualizarUsuarioDTO);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível atualizar o usuário");
		}
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirUsuario(@PathVariable("id") Long id) { 
		try {
			String retorno = usuarioServiceImpl.excluirUsuario(id);			
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
			
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível excluir o usuário");
		}
	}
}
