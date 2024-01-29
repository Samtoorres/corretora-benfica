import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Cliente } from '../shared/entidade/cliente';
import { Seguro } from '../shared/entidade/seguro';
import { ContatoCliente } from '../shared/entidade/contatoCliente';
import { ClienteService } from '../shared/service/cliente.service';
import { Automovel } from '../shared/entidade/automovel';
import { Imovel } from '../shared/entidade/imovel';
import { ActivatedRoute, Router } from '@angular/router';
import { Vida } from '../shared/entidade/vida';

@Component({
  selector: 'app-cadastrar-cliente',
  templateUrl: './cadastrar-cliente.component.html',
  styleUrls: ['./cadastrar-cliente.component.scss']
})
export class CadastrarClienteComponent implements OnInit {

  cliente = new Cliente();
  seguro = new Seguro();
  contatoCliente = new ContatoCliente();
  automovel = new Automovel();
  imovel = new Imovel()
  vida = new Vida();
  mostrarDiv = 0;

  constructor(private clienteService: ClienteService, private cdr: ChangeDetectorRef, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  public cadastrarCliente() {
    this.cliente.seguro.push(this.seguro);
    this.cliente.contatoCliente.push(this.contatoCliente);
    this.clienteService.cadastrarCliente(this.cliente).subscribe(() => {

      if(this.cliente.tipoSeguro == 1) {
        this.cadastrarSeguroAutomovel();
      }

      if(this.cliente.tipoSeguro == 2) {
        this.cadastrarSeguroImovel();
      }

      if(this.cliente.tipoSeguro == 3) {
        this.cadastrarSeguroVida();
      }

      this.recarregarComponente();
      alert("Cliente cadastrado com sucesso");
      this.router.navigate(["/lista-cliente"]);
    },
    (error) => {
      alert("Erro ao cadastrar o cliente");
    });
  }

  public cadastrarSeguroAutomovel() {
    this.clienteService.cadastrarSeguroAutomovel(this.cliente.cpf, this.automovel).subscribe();
  }

  public cadastrarSeguroImovel() {
    this.clienteService.cadastrarSeguroImovel(this.cliente.cpf, this.imovel).subscribe();
  }

  public cadastrarSeguroVida() {
    this.clienteService.cadastrarSeguroVida(this.cliente.cpf, this.vida).subscribe();
  }

  public mostrarDivCadastroSeguro(a : number) {
    if(a == 1) {
      this.mostrarDiv = 1;
    }
    if(a == 2) {
      this.mostrarDiv = 2;
    }
    if(a == 3) {
      this.mostrarDiv = 3;
    }
  }

  recarregarComponente(): void {
    this.cliente = new Cliente();
    this.seguro = new Seguro();
    this.contatoCliente = new ContatoCliente();
    this.automovel = new Automovel();
    this.imovel = new Imovel()
    this.cdr.detectChanges();
  }
}
