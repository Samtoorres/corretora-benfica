import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../shared/service/usuario.service';
import { Usuario } from '../shared/entidade/usuario';
import { Location } from '@angular/common';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.scss']
})
export class ListaUsuarioComponent implements OnInit {

  displayedColumns: string[] = ['nome', 'cpf', 'tipoUsuario', 'acoes'];
  dataSource = [];

  constructor(private usuarioService: UsuarioService, private location: Location) {
    this.listarUsuarios();
  }

  ngOnInit(): void {
  }

  public listarUsuarios() {
    this.usuarioService.listarUsuarios().subscribe((response) => this.dataSource = response);
  }

  public excluirUsuario(usuario: Usuario) {
    this.usuarioService.excluirUsuario(usuario).subscribe(() => {
      location.reload();
    });
  }
}
