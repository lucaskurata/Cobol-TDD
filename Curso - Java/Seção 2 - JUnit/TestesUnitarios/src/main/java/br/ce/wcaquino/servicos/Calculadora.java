package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.NaoDevePermitirMultiplicarASendoZero;
import br.ce.wcaquino.exceptions.NaoDevePermitirMultiplicarBSendoZero;
import br.ce.wcaquino.exceptions.NaoDevePermitirSubtrairBSendoMaiorQueA;
import br.ce.wcaquino.exceptions.naoDeveDividirPorZero;

public class Calculadora {

	public int somar(int a, int b) {
		
		return a + b;
		
	}
	
	public int Subtrair(int a, int b) throws NaoDevePermitirSubtrairBSendoMaiorQueA {
		
		if( b > a) {
			throw new NaoDevePermitirSubtrairBSendoMaiorQueA();
		}
		return a - b;
		
	}
	
	public double Dividir(int a , int b) throws naoDeveDividirPorZero {
		
		if (b == 0) {
			throw new naoDeveDividirPorZero();
		}
		return a / b;
		
	}
	
	public int Multiplicar(int a, int b) throws NaoDevePermitirMultiplicarBSendoZero, NaoDevePermitirMultiplicarASendoZero {
		
		if(b == 0) {
			throw new NaoDevePermitirMultiplicarBSendoZero();
		}
		
		if(a ==0) {
			throw new NaoDevePermitirMultiplicarASendoZero();
		}
		
		return a * b;
		
	}
	
}
