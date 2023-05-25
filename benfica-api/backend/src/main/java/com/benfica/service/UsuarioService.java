package com.benfica.service;

import java.util.List;

import com.benfica.dto.AtualizarUsuarioDTO;
import com.benfica.dto.UsuarioDTO;
import com.benfica.model.Usuario;

public interface UsuarioService {

	public Usuario buscar(Long id);
	public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO);
	public String atualizarUsuario(AtualizarUsuarioDTO atualizarUsuarioDTO);
	public String excluirUsuario(Long id);
	public List<Usuario> listarUsuarios();
}
