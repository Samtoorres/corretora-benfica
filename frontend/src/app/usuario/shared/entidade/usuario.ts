import { Endereco } from "./endereco";

export class Usuario {

  constructor(){
    this.id = 0;
    this.nome = '';
    this.cpf = '';
    this.endereco = new Endereco();
  }

  id: number;
  nome: string;
  cpf: string;
  endereco: Endereco;
}
