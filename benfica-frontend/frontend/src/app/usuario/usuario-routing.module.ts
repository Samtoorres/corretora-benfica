import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { ListaUsuarioComponent } from './lista-usuario/lista-usuario.component';
import { AtualizarUsuarioComponent } from './atualizar-usuario/atualizar-usuario.component';

const routes: Routes = [
  { path: 'lista-usuario', component: ListaUsuarioComponent },
  { path: 'cadastrar-usuario', component: CadastrarUsuarioComponent },
  { path: 'atualizar-usuario/:id', component: AtualizarUsuarioComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
