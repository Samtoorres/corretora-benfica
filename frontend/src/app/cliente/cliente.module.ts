import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CdkTableModule } from '@angular/cdk/table';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { CadastrarClienteComponent } from './cadastrar-cliente/cadastrar-cliente.component';
import { ClienteRoutingModule } from './cliente-routing.module';
import { MatRadioModule } from '@angular/material/radio';
import { ListaClienteComponent } from './lista-cliente/lista-cliente.component';
import { PopupContatoComponent } from './popup-contato/popup-contato.component';
import { MatDialogModule } from '@angular/material/dialog';
import { PopupSeguroComponent } from './popup-seguro/popup-seguro.component';
import { AtualizarClienteComponent } from './atualizar-cliente/atualizar-cliente.component';
import { ContatoComponent } from './atualizar-cliente/contato/contato.component'
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [CadastrarClienteComponent, ListaClienteComponent, PopupContatoComponent, PopupSeguroComponent, AtualizarClienteComponent, ContatoComponent],
  imports: [
    CommonModule,
    FormsModule,
    CdkTableModule,
    MatInputModule,
    MatIconModule,
    MatFormFieldModule,
    MatButtonModule,
    MatTableModule,
    ClienteRoutingModule,
    MatRadioModule,
    MatDialogModule,
    MatGridListModule,
    MatCardModule
  ]
})
export class ClienteModule { }
