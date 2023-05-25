import { Component, OnInit } from '@angular/core';
import { Usuario } from '../shared/entidade/usuario';
import { UsuarioService } from '../shared/service/usuario.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-atualizar-usuario',
  templateUrl: './atualizar-usuario.component.html',
  styleUrls: ['./atualizar-usuario.component.scss']
})
export class AtualizarUsuarioComponent implements OnInit {

  usuario = new Usuario();
  id: string = "";

  constructor(private usuarioService: UsuarioService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id") || "";
    if(this.id != null || this.id != ""){
      this.buscarUsuarioPorId();
    }
  }

  public atualizarUsuario() {
    this.usuarioService.atualizarUsuario(this.usuario).subscribe(val=>{
      this.router.navigate(["/lista-usuario"]);
    });
  }

  public buscarUsuarioPorId(){
    this.usuarioService.buscarUsuarioPorId(+this.id).subscribe((response) => this.usuario = response);
  }
}
