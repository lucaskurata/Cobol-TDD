package br.ce.wcaquino.databuilders;

import br.ce.wcaquino.entidades.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;
	
	private UsuarioBuilder(){}
	
	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		builder.usuario = new Usuario();
		builder.usuario.setNome("Lucas");
		return builder;
		
	}
	
	public Usuario agora() {
		return usuario;
	}
	
}
