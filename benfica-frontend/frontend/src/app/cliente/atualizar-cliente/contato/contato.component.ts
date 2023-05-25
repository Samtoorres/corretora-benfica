import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../../shared/service/cliente.service';
import { ContatoCliente } from './../../shared/entidade/contatoCliente';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.scss']
})
export class ContatoComponent implements OnInit {

  contatoCliente = new ContatoCliente();

  constructor(private clienteService: ClienteService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      if (params['objeto']) {
        const seuObjeto = JSON.parse(params['objeto']);
        this.contatoCliente = seuObjeto;
      }
    });
    console.log(this.contatoCliente)
  }

  atualizarContato() {
    console.log(this.contatoCliente)
    this.clienteService.atualizarContato(this.contatoCliente).subscribe();
  }
}
