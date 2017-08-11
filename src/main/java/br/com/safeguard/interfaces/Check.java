package br.com.safeguard.interfaces;

import java.util.List;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.types.ParametroTipo;

/**
 * Interface com os métodos funcionais para validação de cadeia de caracteres ou objetos com atributos 
 * anotado com (@Verify), que deve ser implementado pela as classes funcionais   
 * 
 * @author Gilmar Carlos
 *
 */
public interface Check {

	/**
	 * Método que recebe um (String) e um (ParametroTipo) para ser adicionado em um (Map) de elementos
	 * 
	 * @param value Valor a ser validado
	 * @param tipo  Padrão usado na validação
	 * @return this retorna a própria classe
	 */
	SafeguardCheck elementOf(String value, ParametroTipo tipo);
	
	
	/**
	 * Método que recebe um (String) e um (BaseParam) para ser adicionado em um (Map) de elementos
	 * 
	 * @param value Valor a ser validado
	 * @param tipo Padrão usado na validação
	 * @return this retorna a própria classe
	 */
	SafeguardCheck elementOf(String value, BaseParam tipo);
	
	/**
	 * Método que recebe um objeto que tenha atributos da classe anotados com (@Verify) para ser adicionado
	 * em um (List) de elementos
	 * 
	 * @param object Instancia da classe anotada com (@Verify)
	 * @return this retorna a própria classe
	 */
	SafeguardCheck elementOf(Object object);
	
	/**
	 * O método que faz a validação dos valores passados anteriormente no método {@code elementOf()}, 
	 * e retorna a própria classe 
	 * 
	 * @see
	 * 
	 * Para implementação do método
	 *  
	 * <p>
	 * Deve passar um (List) de objects que tenha atributos anotados com (@Verify) e/ou um (Map) de elementos com 
	 * chave (String), que representa o valor a ser validado, e um valor do tipo (Enum) que implemente a interface
	 * (BaseParam)
	 * </p>
	 * 
	 * <p>
	 *  As coleções devem ser passadas ao método {@code void validate(Map<String, BaseParam> elements) throws SafeguardException} da
	 *  da classe (ParamVerify), a chamada do método lança uma exceção do tipo checked para garantir que a coleção
	 *  passada não esteja vazia 
	 *  </p>  
	 * 
	 * @return this retorna a própria classe
	 */
	SafeguardCheck validate();
	
	/**
	 * Deve retornar o resultado do método {@code Boolean hasError()} da classe (ParamVerify)
	 * 
	 * @return Boolean retorna true se houver erros de validação
	 */
	Boolean hasError();
	
	/**
	 * Deve retornar uma lista de elementos inválidos chamando o método {@code List<String> getInvalidElements()} da classe (ParamVerify)
	 * 
	 * @return List<String> Lista de lementos inválidos
	 */
	List<String> getInvalidElements();
	
	/**
	 * Deve retornar uma lista de elementos válidos chamando o método {@code List<String> getValidElements()} da classe (ParamVerify)
	 * 
	 * @return List<String> Lista de elementos válidos
	 */
	List<String> getValidElements();
	
}
