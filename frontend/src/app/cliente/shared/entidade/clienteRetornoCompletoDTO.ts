import { Endereco } from "src/app/usuario/shared/entidade/endereco";
import { Seguro } from "./seguro";
import { ContatoCliente } from "./contatoCliente";

export class ClienteRetornoCompletoDTO {

  constructor(){
    this.id = 0;
    this.nome = '';
    this.cpf = '';
    this.endereco = new Endereco();
    this.seguro = [];
    this.contatoCliente = [];
    this.tipoSeguro = 0;
    this.objetoSeguro = new Object();
  }

  id: number;
  nome: string;
  cpf: string;
  seguro: Seguro[];
  contatoCliente: ContatoCliente[];
  endereco: Endereco;
  tipoSeguro: number;
  objetoSeguro: object;
}
