import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ClienteService } from '../shared/service/cliente.service';
import { Router } from '@angular/router';
import { ContatoCliente } from '../shared/entidade/contatoCliente';

@Component({
  selector: 'app-popup-contato',
  templateUrl: './popup-contato.component.html',
  styleUrls: ['./popup-contato.component.scss']
})
export class PopupContatoComponent {

  dados: any;

  constructor(public dialogRef: MatDialogRef<PopupContatoComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private clienteService: ClienteService, private router: Router) {}

  close(): void {
    this.dialogRef.close();
  }

  atualizarContato(contato: ContatoCliente) {
    const objetoString = JSON.stringify(contato);
    this.router.navigate(['/atualizar-contato'], { queryParams: { objeto: objetoString } });
    this.close();
  }
}
