import { MatTableDataSource } from '@angular/material/table';
import { Cliente } from '../shared/entidade/cliente';
import { ClienteService } from './../shared/service/cliente.service';
import { Component, OnInit } from '@angular/core';
import { ClienteRetornoCompletoDTO } from '../shared/entidade/clienteRetornoCompletoDTO';
import { MatDialog } from '@angular/material/dialog';
import { PopupContatoComponent } from '../popup-contato/popup-contato.component';
import { ContatoCliente } from '../shared/entidade/contatoCliente';
import { PopupSeguroComponent } from '../popup-seguro/popup-seguro.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-cliente',
  templateUrl: './lista-cliente.component.html',
  styleUrls: ['./lista-cliente.component.scss']
})
export class ListaClienteComponent implements OnInit{

  displayedColumns: string[] = ['nome', 'cpf', 'contatoCliente', 'endereco', 'seguros', 'acoes'];
  dataSource = new MatTableDataSource<ClienteRetornoCompletoDTO>();

  constructor(private clienteService: ClienteService, private dialog: MatDialog, private router: Router) {
    this.listarClientes();
  }

  ngOnInit(): void {

  }

  public listarClientes() {
    this.clienteService.listarClientes().subscribe((response) => {
      this.dataSource = response
      console.log(response)
    });
    console.log(this.dataSource)
  }

  public excluirCliente(cliente: Cliente) {
    console.log(cliente.cpf)
    this.clienteService.excluirCliente(cliente).subscribe(() => {
      location.reload();
    },
    (error) => {
      location.reload();
    });
  }

  enviarObjeto(cliente: Cliente) {
    const objetoString = JSON.stringify(cliente);
    this.router.navigate(['/atualizar-cliente'], { queryParams: { objeto: objetoString } });
  }

  openPopupContato(contatoCliente: any[], cpf: String): void {

    const data = {
        contatoCliente: contatoCliente,
        cpf: cpf
      }

    const dialogRef = this.dialog.open(PopupContatoComponent, {
      data: data,
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log('Pop-up fechado', result);
    });
  }

  openPopupSeguro(objetoSeguro: any, cpf: String): void {

    const data = {
      objetoSeguro: objetoSeguro,
        cpf: cpf
      }

    const dialogRef = this.dialog.open(PopupSeguroComponent, {
      data: data,
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log('Pop-up fechado', result);
    });
  }
}
