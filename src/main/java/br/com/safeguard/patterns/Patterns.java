package br.com.safeguard.patterns;

import br.com.safeguard.interfaces.BasePattern;

/**
 * Enum que determina o tipo dos padrões que vão ser utilizados pelos validadores.
 * 
 * O Enum implementa a interface (BasePattern), e retorna o padrão correspondente ao validador registrado em (ParametroTipo)
 *   
 * @author Gilmar Carlos
 *
 */
public enum Patterns implements BasePattern{

	DEFAULT									   							(new String("[\\u0020-\\u00FC]+")),
	DEFAULT_SEM_SIMBOLO_DE_MAIOR			   							(new String("[\\u0020-\\u00FC&&[^>]]+")),
	DEFAULT_SEM_SIMBOLO_DE_MENOR			   							(new String("[\\u0020-\\u00FC&&[^<]]+")),
	DEFAULT_SEM_SIMBOLO_DE_MENOR_E_MAIOR	   							(new String("[\\u0020-\\u00FC&&[^<>]]+")),
	DEFAULT_SEM_SIMBOLO_DE_CHAVES			   							(new String("[\\u0020-\\u00FC&&[^\\{\\}]]+")),
	DEFAULT_SEM_SIMBOLO_DE_COLCHETES			   						(new String("[\\u0020-\\u00FC&&[^\\[\\]]]+")),
	DEFAULT_SEM_SIMBOLO_DE_PARENTESES			   						(new String("[\\u0020-\\u00FC&&[^\\(\\)]]+")),
	DEFAULT_SEM_SIMBOLO_DE_ASTERISCO			   						(new String("[\\u0020-\\u00FC&&[^*]]+")),
	DEFAULT_SEM_SIMBOLO_DE_ARROBA			   							(new String("[\\u0020-\\u00FC&&[^@]]+")),
	DEFAULT_SEM_SIMBOLO_DE_HASHTAG			   							(new String("[\\u0020-\\u00FC&&[^#]]+")),
	DEFAULT_SEM_SIMBOLO_DE_SIFRAO			   							(new String("[\\u0020-\\u00FC&&[^$]]+")),
	DEFAULT_SEM_SIMBOLO_DE_PORCENTAGEM		   							(new String("[\\u0020-\\u00FC&&[^%]]+")),
	DEFAULT_SEM_SIMBOLO_DE_TREMA			   							(new String("[\\u0020-\\u00FC&&[^¨]]+")),
	DEFAULT_SEM_SIMBOLO_DE_E_COMERCIAL		   							(new String("[\\u0020-\\u00FC&&[^&]]+")),
	DEFAULT_SEM_SIMBOLO_DE_UNDERLINE		   							(new String("[\\u0020-\\u00FC&&[^_]]+")),
	DEFAULT_SEM_SIMBOLO_DE_HIFEM			   							(new String("[\\u0020-\\u00FC&&[^\\-]]+")),
	DEFAULT_SEM_SIMBOLO_DE_MAIS				   							(new String("[\\u0020-\\u00FC&&[^+]]+")),
	DEFAULT_SEM_SIMBOLO_DE_ASPAS_SIMPLES	   							(new String("[\\u0020-\\u00FC&&[^\']]+")),
	DEFAULT_SEM_SIMBOLO_DE_ASPAS_DUPLA		   							(new String("[\\u0020-\\u00FC&&[^\"]]+")),
	DEFAULT_SEM_SIMBOLO_DE_PONTO			   							(new String("[\\u0020-\\u00FC&&[^.]]+")),
	DEFAULT_SEM_SIMBOLO_DE_VIRGULA			   							(new String("[\\u0020-\\u00FC&&[^,]]+")),
	DEFAULT_SEM_SIMBOLO_DE_DOIS_PONTOS		   							(new String("[\\u0020-\\u00FC&&[^:]]+")),
	DEFAULT_SEM_SIMBOLO_DE_PONTO_E_VIRGULA	   							(new String("[\\u0020-\\u00FC&&[^;]]+")),
	DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_EXCLAMACAO	  						(new String("[\\u0020-\\u00FC&&[^!]]+")),
	DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_INTERROGACAO  						(new String("[\\u0020-\\u00FC&&[^?]]+")),
	DEFAULT_SEM_PONTUACAO						  						(new String("[\\u0020-\\u00FC&&[^!?.,:;]]+")),
	DEFAULT_SEM_NUMEROS							  						(new String("[\\u0020-\\u00FC&&[^\\d]]+")),
	DEFAULT_SEM_SINAIS_MATEMATICOS			   							(new String("[\\u0020-\\u00FC&&[^/*\\-+=]]+")),
	DEFAULT_SEM_CARACTERES_ESPECIAIS		   							(new String("[\\u0020-\\u00FC&&[^\\p{Punct}]]+")),
	
	TEXTO_SEM_CARACTERES_ESPECIAIS			   							(new String("[\\u0020-\\u00FC&&[^\\d\\p{Punct}\\u007F-\\u00BF]]+")),
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM							(new String("[\\u0020-\\u00FC&&[\\sa-zA-Z\\-\\u00C0-\\u00FC]]+")),
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE						(new String("[\\u0020-\\u00FC&&[\\sa-zA-Z_\\u00C0-\\u00FC]]+")),
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA							(new String("[\\u0020-\\u00FC&&[\\sa-zA-Z,\\u00C0-\\u00FC]]+")),
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO						(new String("[\\u0020-\\u00FC&&[\\sa-zA-Z!?.,:;\\u00C0-\\u00FC]]+")),
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE		(new String("[\\u0020-\\u00FC&&[\\sa-zA-Z!?.,:;_\\-\\u00C0-\\u00FC]]+")),
	
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS	   							(new String("[\\u0020-\\u00FC&&[^\\p{Punct}\\u007F-\\u00BF]]+")),
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM						(new String("[\\u0020-\\u00FC&&[\\d\\sa-zA-Z\\-\\u00C0-\\u00FC]]+")),
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE					(new String("[\\u0020-\\u00FC&&[\\d\\sa-zA-Z_\\u00C0-\\u00FC]]+")),
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA					(new String("[\\u0020-\\u00FC&&[\\d\\sa-zA-Z,\\u00C0-\\u00FC]]+")),
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO					(new String("[\\u0020-\\u00FC&&[\\d\\sa-zA-Z!?.,:;\\u00C0-\\u00FC]]+")),
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE	(new String("[\\u0020-\\u00FC&&[\\d\\sa-zA-Z!?.,:;_\\-\\u00C0-\\u00FC]]+")),
	TEXTO_NUMERO_VIRGULA_HIFEM_UNDERLINE_SEM_PONTUACAO					(new String("[^<>`´~^'¬¢£³²¹!?@#$%¨&*+=§/\\|\\^\\]\\[\\{\\}\\(\\)\"]+")),
	
	NUMERO																(new String("[^\\D]+")),
	
	EMAIL																(new String("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")),
	
	CEP																	(new String("[^\\D]{8}")),
	CEP_FORMATADO														(new String("\\d{5}-\\d{3}")),
	
	PLACA_DE_VEICULO_BRASIL	 											(new String("[A-Z]{3}\\d{4}")),
	PLACA_DE_VEICULO_FORMATADO_BRASIL									(new String("[A-Z]{3}\\-\\d{4}")),
	
	TELEFONE															(new String("([0]{1}(12|15|21|31|41|43))?[1-9]{2}[9]?[\\d]{8}")),
	TELEFONE_FORMATADO_BRASIL											(new String("([0]{1}(12|15|21|31|41|43))?\\([1-9]{2}\\)[9]?[\\d]{4}\\-[\\d]{4}")),
	TELEFONE_FORMATADO_INTERNACIONAL									(new String("\\+[\\d]{1,3}\\s[1-9]{2}\\s[9]?[\\d]{4}\\-[\\d]{4}"));
	
	private String pattern;

	private Patterns(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String getPattern() {
		return pattern;
	}
		
}
