package br.ce.wcaquino.databuilders;

import br.ce.wcaquino.entidades.Filme;

public class FilmeBuilder {

	private Filme filme;
	
	private FilmeBuilder() {};
	
	//Somente a classe de entrada precisa ser static
	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setEstoque(2);
		builder.filme.setNome("Avengers");
		builder.filme.setPrecoLocacao(4.0);
		return builder;
		 	
	}
	
	public FilmeBuilder semEstoque() {
		filme.setEstoque(0);
		return this;
	}
	
	public FilmeBuilder valorDiferente() {
		filme.setPrecoLocacao(5.0);
		return this;
	}
	
	public Filme agora() {
		return filme;
	}
}
