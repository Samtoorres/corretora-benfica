package com.benfica.service;

import java.util.List;

import com.benfica.dto.AtualizarClienteDTO;
import com.benfica.dto.AtualizarContatoDTO;
import com.benfica.dto.ClienteDTO;
import com.benfica.dto.ClienteRetornoCompletoDTO;
import com.benfica.model.Cliente;

public interface ClienteService {

	Cliente buscar(Long id);
	Cliente cadastrar(ClienteDTO clienteDTO);
	String atualizar(AtualizarClienteDTO atualizarClienteDTO);
	String excluir(String cpf);
	Cliente buscarPorCpf(String cpf);
	List<ClienteRetornoCompletoDTO> buscarLista();
	String atualizarContato(AtualizarContatoDTO atualizarContatoDTO);
}
