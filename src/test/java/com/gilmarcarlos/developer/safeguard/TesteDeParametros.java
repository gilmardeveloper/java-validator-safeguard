package com.gilmarcarlos.developer.safeguard;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteDeParametros {

	@Test
	public void loads() {
		
		Check check = new SafeguardCheck();
		
		String textoPadraoSemCaracteresEspeciais = "Você pode digita apenas letras ou números";
		String apenasTexto = "Apenas texto sem caracteres especiais ou números";
		String apenasNumeros = "1234567890";
		String textoEnumero = "texto com números 1234567890";
		String textoEnumeroComPontuacao = "texto com números 1234567890 ?!.:;";
		
		/*Testando varios parametros*/
		boolean temErro1 = check.elementOf(textoPadraoSemCaracteresEspeciais, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
		          			   .elementOf(apenasTexto, ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
							   .elementOf(apenasNumeros, ParametroTipo.NUMERO)
							   .elementOf(textoEnumero, ParametroTipo.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS)
							   .elementOf(textoEnumeroComPontuacao, ParametroTipo.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO)
							   .validate()
							   .hasError();
		
		/*
		 * Testando o mesmo paramentro
		 * 
		 * O mesmo parametro pode ser testado com algumas opções do tipo Default, seguindo uma determinada ordem.
		 * 
		 * Obs.: Apenas opções do tipo Default são validas para testar o mesmo parametro, o uso de outras opções
		 * podem gerar erros de teste por negação de opções 
		 * 
		 */
		
		
		/*As duas validações abaixo são equivaletnes a usar o tipo (ParametroTipo.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS)*/
		apenasTexto = "Apenas texto sem caracteres especiais ou números";
		boolean temErro2 = check
				.elementOf(apenasTexto, ParametroTipo.DEFAULT_SEM_NUMEROS)
				.elementOf(apenasTexto, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
				.validate()
				.hasError();

		
		apenasTexto = "Apenas texto, uso de caracteres especiais ou números não é permitido ex: <,90?!{";
		boolean temErro3 = check
								.elementOf(apenasTexto, ParametroTipo.DEFAULT_SEM_NUMEROS)
								.elementOf(apenasTexto, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
								.validate()
								.hasError();
		
		
		
		Assert.assertEquals(false, temErro1);
		Assert.assertEquals(false, temErro2);
		Assert.assertEquals(true, temErro3);
		
	}

	
}