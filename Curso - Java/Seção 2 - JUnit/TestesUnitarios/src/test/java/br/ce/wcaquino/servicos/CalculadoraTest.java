package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoDevePermitirMultiplicarASendoZero;
import br.ce.wcaquino.exceptions.NaoDevePermitirMultiplicarBSendoZero;
import br.ce.wcaquino.exceptions.NaoDevePermitirSubtrairBSendoMaiorQueA; 
import br.ce.wcaquino.exceptions.naoDeveDividirPorZero;

public class CalculadoraTest {
	
	private Calculadora calc;
	
	@Before
	public void setup() {
		
		calc = new Calculadora();
		
	}
	
	@Test
	public void deveSomarDoisValores() {
		//cenario
		int a = 10;
		int b = 5;
		
		//acao
		int resultado = calc.somar(a, b);
		
		//verificacao
		Assert.assertEquals(15, resultado);
		
	}
	
	@Test
	public void deveSubtrairaDoisValoresTest() throws NaoDevePermitirSubtrairBSendoMaiorQueA{
		//cenario
		int a = 100;
		int b = 50;
		
		//acao
		int resultado = calc.Subtrair(a, b);
		
		//verificacao
		Assert.assertEquals(50, resultado);
		
	}
	
	@Test(expected = NaoDevePermitirSubtrairBSendoMaiorQueA.class)
	public void lancarExcecaoAoSubtrairBSendoMaiorQueA() throws NaoDevePermitirSubtrairBSendoMaiorQueA {
		//cenario
		int a = 10;
		int b = 100;
		
		//acao
		int resultado = calc.Subtrair(a,  b);
		
	}
	
	@Test
	public void deveDividirDoisValores() throws naoDeveDividirPorZero {
		//cenario
		int a = 100;
		int b = 10;
		
		//acao
		double resultado = calc.Dividir(a, b);
		
		//verificacao
		Assert.assertEquals(10, resultado, 0.10);
		
	}
	
	@Test(expected = naoDeveDividirPorZero.class)
	public void lancarExcecaoAoDividirPorZero() throws naoDeveDividirPorZero {
		//cenario
		int a = 10;
		int b = 0;
		
		//acao
		double resultado = calc.Dividir(a, b);
	}

	@Test
	public void deveMultiplicarDoisValores() throws NaoDevePermitirMultiplicarBSendoZero, NaoDevePermitirMultiplicarASendoZero {
		//cenario
		int a = 10;
		int b = 50;
		
		//acao
		int resultado = calc.Multiplicar(a, b);
		
		//verificacao
		Assert.assertEquals(500, resultado);
		Assert.assertNotEquals(1000, 500);

	}
	
	@Test(expected = NaoDevePermitirMultiplicarBSendoZero.class)
	public void lancarExcecaoAoMultiplicarBPorZero() throws NaoDevePermitirMultiplicarBSendoZero, NaoDevePermitirMultiplicarASendoZero {
		//cenario
		int a = 10;
		int b = 0;
		
		//acao
		int resultado = calc.Multiplicar(a, b);
		
	}
	
	@Test(expected = NaoDevePermitirMultiplicarASendoZero.class)
	public void lancarExcecaoAoMultiplicarAPorZero() throws NaoDevePermitirMultiplicarBSendoZero, NaoDevePermitirMultiplicarASendoZero {
		//cenario
		int a = 0;
		int b = 10;
		
		//acao
		int resultado = calc.Multiplicar(a, b);
		
	}
	
}
