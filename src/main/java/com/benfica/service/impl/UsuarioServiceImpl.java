package com.benfica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benfica.dto.AtualizarUsuarioDTO;
import com.benfica.dto.UsuarioDTO;
import com.benfica.model.Endereco;
import com.benfica.model.TipoUsuario;
import com.benfica.model.Usuario;
import com.benfica.repository.EnderecoRepository;
import com.benfica.repository.TipoUsuarioRepository;
import com.benfica.repository.UsuarioRepository;
import com.benfica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Usuario buscar(Long id) {
		
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {

		TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(usuarioDTO.getTipoUsuario()).orElse(null);
		Endereco endereco = enderecoRepository.save(usuarioDTO.getEndereco());
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setEndereco(endereco);
		
		usuarioRepository.save(usuario);
		return usuario;
	}

	@Override
	public String atualizarUsuario(AtualizarUsuarioDTO atualizarUsuarioDTO) {

		Usuario usuario = usuarioRepository.findById(atualizarUsuarioDTO.getId()).orElse(null);
		usuario.setNome(atualizarUsuarioDTO.getNome());
		
		usuarioRepository.save(usuario);
		return "Atualizado";
	}

	@Override
	public String excluirUsuario(Long id) {

		usuarioRepository.deleteById(id);
		return "Deletado";
	}

}
