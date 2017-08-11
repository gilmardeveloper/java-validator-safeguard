package br.com.safeguard.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.safeguard.exceptions.SafeguardException;
import br.com.safeguard.interfaces.BaseParam;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.params.Param;
import br.com.safeguard.types.ParametroTipo;
import br.com.safeguard.verifies.ParamVerify;

/**
 * Classe com os métodos funcionais para validação de cadeia de caracteres ou objetos com atributos 
 * anotado com (@Verify), que implementa a interface (Check)
 * 
 * @author Gilmar Carlos
 *
 */
public class SafeguardCheck implements Check {

	private Map<Integer, Param> stringElements;
	private List<Object> objectElements;
	private ParamVerify verify;
	private Integer key;
	
	/**
	 * Construtor padrão
	 */
	public SafeguardCheck() {
		stringElements = new HashMap<Integer, Param>();
		verify = new ParamVerify();
		objectElements = new ArrayList<>();
		key = 0;
	}

	/**
	 * Método que recebe um (String) e um (ParametroTipo) para ser adicionado em um (Map) de elementos
	 * 
	 * @param value Valor a ser validado
	 * @param tipo Tipo usado na validação
	 * @return this retorna a própria classe
	 */
	public SafeguardCheck elementOf(String value, ParametroTipo tipo) {
		stringElements.put(key++, new Param(tipo, value));
		return this;
	}

	/**
	 * Método que recebe um (String) e um (BaseParam) para ser adicionado em um (Map) de elementos
	 * 
	 * @param value Valor a ser validado
	 * @param tipo Tipo usado na validação
	 * @return this retorna a própria classe
	 */
	public SafeguardCheck elementOf(String value, BaseParam tipo) {
		stringElements.put(key++, new Param(tipo, value));
		return this;
	}

	/**
	 * Método que recebe um objeto que tenha atributos da classe anotados com (@Verify) para ser adicionado
	 * em um (List) de elementos
	 * 
	 * @param object Instancia da classe anotada com (@Verify)
	 * @return this retorna a própria classe
	 */
	public SafeguardCheck elementOf(Object object) {
		objectElements.add(object);
		return this;
	}

	/**
	 * O método que faz a validação dos valores passados anteriormente no método {@code elementOf()}, 
	 * e retorna a própria classe 
	 * 
	 * 
	 * @return this retorna a própria classe
	 */
	public SafeguardCheck validate() {
		
		try {
			if (!stringElements.isEmpty()) {
				verify.validate(stringElements);
			}

			if (!objectElements.isEmpty()) {
				verify.validate(objectElements);
			}
		} catch (SafeguardException e) {
			e.printStackTrace();
		}

		return this;
	}
	
	/**
	 * Método que retorna <code>true</code> caso os elementos verificados sejam inválidos,
	 * <code>false</code> caso contrário
	 * 
	 * @return Boolean retorna true se houver erros
	 */
	public Boolean hasError() {
		return verify.hasError();
	}

	/**
	 *Método que retorna uma lista de elementos inválidos
	 * 
	 * @return List<String> retorna uma lista de elementos inválidos
	 */
	public List<String> getInvalidElements() {
		return verify.getInvalidElements();
	}


	/**
	 *Método que retorna uma lista de elementos válidos
	 * 
	 * @return List<String> retorna uma lista de elementos válidos
	 */
	public List<String> getValidElements() {
		return verify.getValidElements();
	}
}
