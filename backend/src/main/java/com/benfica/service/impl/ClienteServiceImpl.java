package com.benfica.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.benfica.dto.AtualizarContatoDTO;
import com.benfica.dto.ClienteRetornoCompletoDTO;
import com.benfica.model.*;
import com.benfica.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benfica.dto.AtualizarClienteDTO;
import com.benfica.dto.ClienteDTO;
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

	@Autowired
	private ImovelRepository imovelRepository;
	
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
		
		List<Seguro> listaSeguros = new ArrayList<>();
		
		for(Seguro seguro : clienteDTO.getSeguro()) {
			
			seguro.setTipoSeguro(tipoSeguroRepository.findById(clienteDTO.getTipoSeguro()).orElse(null));
			seguro.setAtivo(true);
			seguroRepository.save(seguro);
			listaSeguros.add(seguro);
		}
		
		cliente.setSeguro(listaSeguros);
		
		Endereco endereco = enderecoRepository.save(clienteDTO.getEndereco());
		cliente.setEndereco(endereco);
		
		clienteRepository.save(cliente);
		
		for(ContatoCliente contatoCliente : clienteDTO.getContatoCliente()) {
			
			contatoCliente.setCliente(cliente);
			contatoClienteRepository.save(contatoCliente);
		}
		
		for(Seguro seguro : listaSeguros) {
			seguro.setCliente(cliente);
			seguroRepository.save(seguro);
		}
		
		return cliente;
	}

	@Override
	public String atualizar(AtualizarClienteDTO atualizarClienteDTO) {
		
		Cliente cliente = clienteRepository.findById(atualizarClienteDTO.getId()).orElse(null);
		cliente.setCpf(atualizarClienteDTO.getCpf());
		cliente.setNome(atualizarClienteDTO.getNome());

		Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getId()).orElse(null);
		endereco.setRua(atualizarClienteDTO.getEndereco().getRua());
		endereco.setLote(atualizarClienteDTO.getEndereco().getLote());
		endereco.setCep(atualizarClienteDTO.getEndereco().getCep());

		enderecoRepository.save(endereco);

		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
		
		return "Dados do Cliente: " + cliente.getNome() + ", atualizados com sucesso!";
	}

	@Override
	@Transactional
	public String excluir(String cpf) {
		
		Cliente cliente = buscarPorCpf(cpf);
		clienteRepository.delete(cliente);

		return "Cliente excluído com sucesso";
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		
		return clienteRepository.findByCpf(cpf);
	}

	@Override
	public List<ClienteRetornoCompletoDTO> buscarLista() {

		List<Cliente> listaClientes = clienteRepository.findAll();
		List<Veiculo> listaVeiculo = veiculoRepository.findAll();
		List<Imovel> listaImovel = imovelRepository.findAll();

		List<ClienteRetornoCompletoDTO> listaClientesDadosCompletos = new ArrayList<>();

		for(Cliente cliente : listaClientes) {

			ClienteRetornoCompletoDTO clienteRetornoCompletoDTO = new ClienteRetornoCompletoDTO();
			clienteRetornoCompletoDTO.setId(cliente.getId());
			clienteRetornoCompletoDTO.setCpf(cliente.getCpf());
			clienteRetornoCompletoDTO.setNome(cliente.getNome());
			clienteRetornoCompletoDTO.setSeguro(cliente.getSeguro());
			clienteRetornoCompletoDTO.setEndereco(cliente.getEndereco());
			clienteRetornoCompletoDTO.setContatoCliente(cliente.getContatoCliente());

			List<Object> objetosSeguros = new ArrayList<>();

			for(Seguro seguro : cliente.getSeguro()) {
				clienteRetornoCompletoDTO.setTipoSeguro(seguro.getTipoSeguro().getId());

				if(seguro.getTipoSeguro().getId() == 1) {
					for(Veiculo veiculo : listaVeiculo) {
						if(veiculo.getSeguro().getId() == seguro.getId()) {
							objetosSeguros.add(veiculo);
							clienteRetornoCompletoDTO.setObjetoSeguro(objetosSeguros);
						}
					}
				}

				if(seguro.getTipoSeguro().getId() == 2) {
					for(Imovel imovel : listaImovel) {
						if(imovel.getSeguro().getId() == seguro.getId()) {
							objetosSeguros.add(imovel);
							clienteRetornoCompletoDTO.setObjetoSeguro(objetosSeguros);
						}
					}
				}
			}

			listaClientesDadosCompletos.add(clienteRetornoCompletoDTO);
		}

		return listaClientesDadosCompletos;
	}

	public String atualizarContato(AtualizarContatoDTO atualizarContatoDTO) {

		ContatoCliente contato = contatoClienteRepository.findById(atualizarContatoDTO.getId()).orElse(null);

		contato.setId(atualizarContatoDTO.getId());
		contato.setEmail(atualizarContatoDTO.getEmail());
		contato.setTelefonePessoal(atualizarContatoDTO.getTelefonePessoal());

		contatoClienteRepository.save(contato);

		return "Contato atualizado com sucesso";
	}

	public String excluirContato(Long id) {

		contatoClienteRepository.deleteById(id);
		return "Contato excluído com sucesso";
	}

}
