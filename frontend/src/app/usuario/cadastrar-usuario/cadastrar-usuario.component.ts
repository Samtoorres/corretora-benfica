
import { Component, OnInit } from '@angular/core';
import { Usuario } from '../shared/entidade/usuario';
import { UsuarioService } from '../shared/service/usuario.service';
import { ToastrService } from 'ngx-toastr';

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

  constructor(private usuarioService: UsuarioService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  public cadastrarUsuario() {
    this.usuarioService.cadastrarUsuario(this.usuario).subscribe();

    console.log(this.resposta)

    if(this.objetoVazio(this.resposta)) {
      console.log(this.mensagemRetorno)
    } else {
      alert(this.mensagemRetorno);
    }
  }

  public objetoVazio(obj: any) {
    for (var prop in obj) {
      if (obj.hasOwnProperty(prop)) return false;
    }
    return true;
  }
}
