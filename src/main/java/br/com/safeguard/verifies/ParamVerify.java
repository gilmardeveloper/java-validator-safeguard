package br.com.safeguard.verifies;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.caelum.stella.validation.InvalidStateException;
import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.exceptions.SafeguardException;
import br.com.safeguard.interfaces.BaseParam;
import br.com.safeguard.params.Param;

/**  
 *  Classe de verificação genérica para uma cadeia de caracteres formatados ou não, os dados podem ser
 *  validados a partir de uma (Map) com chaves do tipo (String) e valores de tipos (ParametroTipo) que implementam 
 *  a interface (BaseParam)
 *  
 *  @author Gilmar Carlos
 *
 */
public class ParamVerify {
		
	private List<String> validElements;
	private List<String> invalidElements;

	/**
	 * Construtor padrão, que inicializa a implementação de (List)  
	 */
	public ParamVerify() {
		this(new ArrayList<String>(), new ArrayList<String>());
	}
	
	/**
	 * Construtor secundário, que recebe a implementação de (List)
	 * 
	 *   @param validElements Lista de elementos válidos
	 *   @param invalidElements Lista de elementos inválidos
	 *   
	 */
	public ParamVerify(List<String> validElements, List<String> invalidElements) {
		this.validElements = validElements;
		this.invalidElements = invalidElements;
	}
		
	/**
	 * Método public que recebe um (Map) de elementos, verifica se a coleção não está vazia, percorre os elementos e
	 * chama o método {@code void assertValid(String value, BaseParam param)} para cada interação
	 * 
	 * @param elements Uma coleção de elementos
	 * @throws SafeguardException se o (Map) estiver vazio 
	 * 
	 */
	public void validate(Map<Integer, Param> elements) throws SafeguardException {
		if(elements.isEmpty()) {
			throw new SafeguardException("The map can not be empty");
		}
		elements.forEach((Integer, param) -> assertValid(param.getValue(), param.getType()));
	}
	
	/**
	 * Método public que recebe um (List) de elementos, verifica se a coleção não está vazia, percorre os elementos e
	 * chama o método {@code void validate(Object object)} para cada interação
	 * 
	 * @param elements Uma lista de elementos
	 * @throws SafeguardException se o (List) estiver vazio 
	 * 
	 */
	public void validate(List<Object> elements) throws SafeguardException{
		if(elements.isEmpty()) {
			throw new SafeguardException("The list can not be empty");
		}
		elements.forEach( element -> validate(element));
	}
	
	/**
	 * Método public booleano que verifica se a (List) de elementos inválidos não está vazia
	 * 
	 * @return boolean  <code>false</code> se a lista estiver vazia, indicando que não há erros de validação
	 * 		   			<code>true</code> caso contrário		
	 */
	public boolean hasError() {
		if (invalidElements.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Método public que retorna uma lista de elementos inválidos
	 * 
	 * @return List Lista de elementos inválidos
	 */	
	public List<String> getInvalidElements() {
		return invalidElements;
	}
	
	/**
	 * Método public que retorna uma lista de elementos válidos
	 * 
	 * @return List Lista de elementos válidos
	 */	
	public List<String> getValidElements() {
		return validElements;
	}
	
	/**
	 * Método private que valida um objeto que tem atributos anotados com <code>@Verify</code>. 
	 * <p>Percorre um laço para verificar se cada atributo está anotado</p>
	 *  
	 * @param object Instancia da classe anotada com (@Verify)
	 */
	private void validate(Object object) {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (isVerifiable(field)) {
				validate(object, field);
			}
		}
	}	
	
	/**
	 * Método private que valida um objeto que tem atributos anotados com <code>@Verify</code>
	 * <p>Pega o valor do atributo da classe e da anotação</p>
	 * 
	 * @param object Instancia da classe anotada com (@Verify)
	 * @param field Atributos da classe anotadas com (@Verify)
	 * 
	 * @throws InvalidStateException caso o valor do elemento seja inválido
	 * @throws IllegalArgumentException olha java doc
	 * @throws IllegalAccessException olhar java doc
	 * 
	 * @see
	 * <ul>
	 * <li>https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalAccessException.html</li>
	 * <li>https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html</li>
	 * </ul>
	 */
	private void validate(Object object, Field field) {
		try {
			for(BaseParam param : field.getAnnotation(Verify.class).value()) {
				String value = String.valueOf(field.get(object));
				assertValid(value, param);
			}
		} catch (InvalidStateException e) {
			System.err.println(field.getName() + " isn't valid ");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método private que valida um objeto que tem atributos anotados com <code>@Verify</code>
	 * <p>Verifica se o atributo da classe é acessível e está anotado</p>
	 * 
	 * @param field Atributos da classe anotadas com (@Verify)
	 * @return boolean <code>true</code> se for acessível e estiver anotado
	 * 		 		   <code>false</code> caso contrário
	 */
	private boolean isVerifiable(Field field) {
		
		field.setAccessible(true);
		if (field.isAccessible() && field.isAnnotationPresent(Verify.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método private que faz a validação do valor baseado no tipo do paramentro especificado
	 * 	
	 * @param value Valor a ser validado
	 * @param param Tipo que contém o padrão para validação
	 * 
	 * @throws InvalidStateException e caso o elemento tenha seu valor inválido
	 */
	private void assertValid(String value, BaseParam param) {
		try {
			param.getType().assertValid(value);
			validElements.add(value);
		} catch (InvalidStateException e) {
			invalidElements.add(value);
			e.printStackTrace();
		}
	}
	
}
