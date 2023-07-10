import { Component, OnInit } from '@angular/core';
import { Cliente } from '../shared/entidade/cliente';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../shared/service/cliente.service';

@Component({
  selector: 'app-atualizar-cliente',
  templateUrl: './atualizar-cliente.component.html',
  styleUrls: ['./atualizar-cliente.component.scss']
})
export class AtualizarClienteComponent implements OnInit {

  cliente = new Cliente();

  constructor(private clienteService: ClienteService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      if (params['objeto']) {
        const seuObjeto = JSON.parse(params['objeto']);
        this.cliente = seuObjeto;
      }
    });
  }

  public atualizarCliente() {
    console.log(this.cliente)
    this.clienteService.atualizarCliente(this.cliente).subscribe(() =>{
      this.router.navigate(["/lista-usuario"]);
    });
  }
}
