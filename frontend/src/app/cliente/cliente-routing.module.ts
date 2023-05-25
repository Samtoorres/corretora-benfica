import { CadastrarClienteComponent } from './cadastrar-cliente/cadastrar-cliente.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaClienteComponent } from './lista-cliente/lista-cliente.component';
import { AtualizarClienteComponent } from './atualizar-cliente/atualizar-cliente.component';
import { ContatoComponent } from './atualizar-cliente/contato/contato.component';

const routes: Routes = [
  { path: 'cadastrar-cliente', component: CadastrarClienteComponent },
  { path: 'lista-cliente', component: ListaClienteComponent },
  { path: 'atualizar-cliente', component: AtualizarClienteComponent },
  { path: 'atualizar-contato', component: ContatoComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class ClienteRoutingModule { }
