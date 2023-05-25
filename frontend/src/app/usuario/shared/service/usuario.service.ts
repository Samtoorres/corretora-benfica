import { Usuario } from './../entidade/usuario';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  public cadastrarUsuario(usuarioDTO: Usuario) {
    return this.http.post<any>("http://localhost:8080/user/cadastrar", usuarioDTO);
  }

  public listarUsuarios() {
    return this.http.get<any>("http://localhost:8080/user/listar");
  }

  public excluirUsuario(usuario: Usuario) {
    return this.http.delete<any>("http://localhost:8080/user/excluir/"+usuario.id)
  }

  public atualizarUsuario(usuario: Usuario) {
    return this.http.put<any>("http://localhost:8080/user/atualizar", usuario);
  }

  public buscarUsuarioPorId(id: number) {
    return this.http.get<any>("http://localhost:8080/user/"+id);
  }
}
