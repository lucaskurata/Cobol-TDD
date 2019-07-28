package br.ce.wcaquino.servicos;



import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

public class LocacaoServiceTest {

	private LocacaoService service;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup(){
		service = new LocacaoService();
	}
	
	@Test
	public void devePermitirAlugarFilme() throws Exception {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0));
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filmes);
			
		//verificacao
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void deveLancarExcecaoAoAlugarFilmeSemEstoque() throws Exception{
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 4.0));
		
		//acao
		service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void deveLancarExcecaoAoAlugarFilmeSemUsuario() throws FilmeSemEstoqueException{
		//cenario
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0));
		
		//acao
		try {
			service.alugarFilme(null, filmes);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuario vazio"));
		}
	}

	@Test
	public void deveLancarExcecaoAoAlugarSemFilme() throws FilmeSemEstoqueException, LocadoraException{
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		//acao
		service.alugarFilme(usuario, null);
	}
	
	@Test 
	public void devePagar75PctNoFilme3() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = new Usuario("Armando");
		List<Filme> filmes = Arrays.asList(new Filme("Os Vingadores 1", 2, 5.0), new Filme("Os Vingadores 2", 2, 5.0), new Filme("Os Vingadores - Guerra Infinita", 2, 5.0));
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		//verificacao
		//5 + 5 + 5 = 11,75
		Assert.assertThat(resultado.getValor(), is(13.75));
		
	}
	
	@Test
	public void devePagar75PctNoFilme3Mais50PctNoFilme4() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = new Usuario("Lucas");
		List<Filme> filmes = Arrays.asList(new Filme("Os Vingadores 1", 2, 5.0), 
				new Filme("Os Vingadores 2", 2, 5.0), new Filme("Os Vingadores - Guerra Infinita", 2, 5.0), 
				new Filme("Os Vingadores - Ultimato", 2, 5.0));
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		
		//verificacao
		//5 + 5 + 3.75 + 2.5
		Assert.assertThat(resultado.getValor(), is(16.25));
		
	}
	
	@Test
	public void devePagar75PctNoFilme3Mais50PctNoFilme4Mais75PctNoFilme5() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = new Usuario("Henrique");
		List<Filme> filmes = Arrays.asList(new Filme("Os Vingadores 1", 2, 5.0), 
				new Filme("Os Vingadores 2", 2, 5.0), new Filme("Os Vingadores - Guerra Infinita", 2, 5.0), 
				new Filme("Os Vingadores - Ultimato", 2, 5.0), new Filme("Homem-aranha", 2, 5.0));
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		
		//verificacao
		//5 + 5 + 3.75 + 2.5 + 1.25
		Assert.assertThat(resultado.getValor(), is(17.5));
		
		
	}

	@Test
	public void devePagar75PctNoFilme3Mais50PctNoFilme4Mais75PctNoFilme5Mais100PctNo6Filme() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = new Usuario("Leonilda");
		List<Filme> filmes = Arrays.asList(new Filme("Os Vingadores 1", 2, 5.0), 
				new Filme("Os Vingadores 2", 2, 5.0), new Filme("Os Vingadores - Guerra Infinita", 2, 5.0), 
				new Filme("Os Vingadores - Ultimato", 2, 5.0), new Filme("Homem-aranha", 2, 5.0), 
				new Filme("Pet", 2, 5.0));
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		
		//verificacao
		//5 + 5 + 3.75 + 2.5 + 1.25 + 0
		Assert.assertThat(resultado.getValor(), is(17.75));
		
	}
	
}
