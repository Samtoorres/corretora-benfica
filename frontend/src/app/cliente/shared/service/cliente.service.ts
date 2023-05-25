import { ContatoCliente } from './../entidade/contatoCliente';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../entidade/cliente';
import { Automovel } from '../entidade/automovel';
import { Imovel } from '../entidade/imovel';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  public cadastrarCliente(clienteDTO: Cliente) {
    return this.http.post<any>("http://localhost:8080/cliente/cadastrar", clienteDTO);
  }

  public cadastrarSeguroAutomovel(cpfCliente: string, seguroVeiculoDTO: Automovel) {
    return this.http.post<any>("http://localhost:8080/seguro/veiculo/"+cpfCliente, seguroVeiculoDTO);
  }

  public cadastrarSeguroImovel(cpfCliente: string, seguroImovelDTO: Imovel) {
    return this.http.post<any>("http://localhost:8080/seguro/imovel/"+cpfCliente, seguroImovelDTO);
  }

  public listarClientes() {
    return this.http.get<any>("http://localhost:8080/cliente/buscar/lista");
  }

  public excluirCliente(cliente : Cliente) {
    return this.http.delete<any>("http://localhost:8080/cliente/excluir/"+cliente.cpf);
  }

  public atualizarCliente(cliente : Cliente) {
    return this.http.put<any>("http://localhost:8080/cliente/atualizar/", cliente);
  }

  public atualizarContato(contatoCliente : ContatoCliente) {
    return this.http.put<any>("http://localhost:8080/cliente/atualizar/contato", contatoCliente);
  }
}
