package com.benfica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benfica.dto.AtualizarClienteDTO;
import com.benfica.dto.ClienteDTO;
import com.benfica.model.Cliente;
import com.benfica.model.ContatoCliente;
import com.benfica.model.Endereco;
import com.benfica.model.Seguro;
import com.benfica.repository.ClienteRepository;
import com.benfica.repository.ContatoClienteRepository;
import com.benfica.repository.EnderecoRepository;
import com.benfica.repository.SeguroRepository;
import com.benfica.repository.TipoSeguroRepository;
import com.benfica.repository.VeiculoRepository;
import com.benfica.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContatoClienteRepository contatoClienteRepository;
	
	@Autowired
	private SeguroRepository seguroRepository;
	
	@Autowired
	private TipoSeguroRepository tipoSeguroRepository;
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public Cliente buscar(Long id) {

		Cliente cliente = clienteRepository.findById(id).orElse(null);
		return cliente;
	}

	@Override
	public Cliente cadastrar(ClienteDTO clienteDTO) {
		
		Cliente cliente = new Cliente();
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNome(clienteDTO.getNome());
		
		Seguro seguro = clienteDTO.getSeguro();
		seguro.setTipoSeguro(tipoSeguroRepository.findById(clienteDTO.getTipoSeguro()).orElse(null));
		seguroRepository.save(clienteDTO.getSeguro());
		
		Endereco endereco = enderecoRepository.save(clienteDTO.getEndereco());
		
		cliente.setSeguro(seguro);
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
		
		for(ContatoCliente contatoCliente : clienteDTO.getContatoCliente()) {
			
			contatoCliente.setCliente(cliente);
			contatoClienteRepository.save(contatoCliente);
		}
		
		return cliente;
	}

	@Override
	public String atualizar(AtualizarClienteDTO atualizarClienteDTO) {
		
		Cliente cliente = clienteRepository.findById(atualizarClienteDTO.getId()).orElse(null);
		cliente.setCpf(atualizarClienteDTO.getCpf());
		cliente.setNome(atualizarClienteDTO.getNome());
//		cliente.setTelefone(atualizarClienteDTO.getTelefone());
		
		clienteRepository.save(cliente);
		
		return "Dados do Cliente: " + cliente.getNome() + ", atualizados com sucesso!";
	}

	@Override
	@Transactional
	public String excluir(Long id) {
		
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		veiculoRepository.deleteBySeguro(cliente.getSeguro());
		clienteRepository.deleteById(id);
		
		return "Cliente excluído com sucesso";
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		
		return clienteRepository.findByCpf(cpf);
	}

	@Override
	public List<Cliente> buscarLista() {
		
		return clienteRepository.findAll();
	}

}
