package br.com.safeguard.constraint.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;

/**
 * 
 * Classe usada para validar objetos anotados com (@Verify), é chamada por um
 * provedor de validação compatível com (javax.validation.ConstraintValidator)
 * 
 * @author Gilmar Carlos
 *
 */
public class VerifyValidator implements ConstraintValidator<Verify, String>{

	private Check check;
	private List<ParametroTipo> parametros;

	@Override
	public void initialize(Verify verify) {
			parametros = Arrays.asList(verify.value());	
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return false;
		}
		
		check = new SafeguardCheck();
		parametros.forEach((parametro) -> check.elementOf(value, parametro).Validate());
		
		if(check.hasError()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("(" + value + ") contém caracteres inválidos ")
			.addConstraintViolation(); 
		}
		
		return !check.hasError();
	}
	
	

}
