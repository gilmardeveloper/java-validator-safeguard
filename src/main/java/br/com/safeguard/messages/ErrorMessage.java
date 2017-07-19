package br.com.safeguard.messages;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleValidationMessage;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.InvalidValue;

/**
 * Faz a busca de mensagens de erros nas validações
 * 
 * implementa a interface {@link br.com.caelum.stella.MessageProducer}
 *  
 * @author Gilmar Carlos
 *
 */
public class ErrorMessage implements MessageProducer {

	@Override
	public ValidationMessage getMessage(InvalidValue invalidValue) {
		String simpleName = invalidValue.getClass().getSimpleName();
        String errorName = invalidValue.name();
        String key = simpleName + "." + " O VALOR NÃO CORRESPONDE AO PADRÃO DO TIPO " + errorName;
        String message;
        message = key.replaceFirst("[.]", " : ").replaceAll("_", " ");
        return new SimpleValidationMessage(message);
	}
	
	

}
