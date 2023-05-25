import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { CdkTableModule } from '@angular/cdk/table';
import { UsuarioRoutingModule } from './usuario-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { ListaUsuarioComponent } from './lista-usuario/lista-usuario.component';
import { MatTableModule } from '@angular/material/table';
import { AtualizarUsuarioComponent } from './atualizar-usuario/atualizar-usuario.component';

@NgModule({
  declarations: [CadastrarUsuarioComponent, ListaUsuarioComponent, AtualizarUsuarioComponent ],
  imports: [
    CommonModule,
    FormsModule,
    CdkTableModule,
    UsuarioRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    ToastrModule.forRoot(),
    MatTableModule
  ]
})
export class UsuarioModule { }
