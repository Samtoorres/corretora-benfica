
import { Component, OnInit } from '@angular/core';
import { Usuario } from '../shared/entidade/usuario';
import { UsuarioService } from '../shared/service/usuario.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.scss'],
  providers: [UsuarioService]
})
export class CadastrarUsuarioComponent implements OnInit {

  usuario = new Usuario();
  resposta = {};
  mensagemRetorno: string = "";

  constructor(private usuarioService: UsuarioService, private toastr: ToastrService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  public cadastrarUsuario() {
    this.usuarioService.cadastrarUsuario(this.usuario).subscribe((response) => {
      alert('Usuário cadastrado com sucesso!');
      this.router.navigate(["/lista-usuario"]);
    },
    (error) => {
      alert('Erro ao cadastrar');
    });
  }
}
