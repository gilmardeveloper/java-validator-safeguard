package br.com.safeguard.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.Validator;
import br.com.safeguard.interfaces.BasePattern;
import br.com.safeguard.messages.ErrorMessage;
import br.com.safeguard.patterns.Patterns;

/**
 * Classe que verifica uma cadeia de caracteres baseado em padrões (Patterns), implementa 
 * a interface {@link br.com.caelum.stella.validation.Validator} 
 * 
 * @author Gilmar Carlos
 *
 */
public class PatternValidator implements Validator<String> {

	private MessageProducer message;
	private BasePattern pattern;
	
	/**
	 * Construtror padrão que inicializa o pattern default e a classe de mensagens de erros (ErrorMessage)
	 */
	public PatternValidator() {
		
		this.pattern = Patterns.DEFAULT;
		this.message = new ErrorMessage();
	}
	
	/**
	 * Construtror genérico que recebe qualquer padrão que implemente (BasePattern) e inicializa a classe de mensagens de erros
	 * 
	 * @param pattern Instancia do padrão a ser analisado
	 */
	public PatternValidator(BasePattern pattern){
		this.pattern = pattern;
		this.message = new ErrorMessage();
	}
	
	/**
	 * Construtror distinto que recebe padrões do tipo (Patterns) e inicializa a classe de mensagens de erros
	 * 
	 * @param pattern Instancia do padrão a ser analisado
	 */
	public PatternValidator(Patterns pattern) {
		this.pattern = pattern;
		this.message = new ErrorMessage();
	}

	/**
	 * 
	 * Método que adiciona elementos inválidos em um (List) caso sua validação contenha erros
	 * 
	 * @param value Valor a ser analisado
	 * @return List<ValidationMessage> Lista de mensagens de erros
	 */
	private List<ValidationMessage> getInvalidValues(String value) {
		List<ValidationMessage> errors = new ArrayList<>();
		if (!Pattern.matches(pattern.getPattern(), value)) {
			errors.add(message.getMessage(pattern));
		}
		return errors;
	}
	
	@Override
	public void assertValid(String value) {
		List<ValidationMessage> errors = getInvalidValues(value);
		if (!errors.isEmpty()) {
			throw new InvalidStateException(errors);
		}
	}
	
	
	@Override
	public List<ValidationMessage> invalidMessagesFor(String value) {
		return getInvalidValues(value);
	}


	@Override
	public boolean isEligible(String object) {

		if (object != null) {
			return true;
		}

		return false;
	}

}
