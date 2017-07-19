package br.com.safeguard.constraint.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.safeguard.constraint.validators.VerifyValidator;
import br.com.safeguard.types.ParametroTipo;

/**
 * Anotação para atributos de classes que devem ser validados seguindo o tipo específico
 * de validador registrado em um (Enum) que implemente a interface (BaseParam)
 * 
 * <p>Pode ser usada junto a um provedor de validação compativel com (javax.validation.ConstraintValidator)</p>
 * 
 * @see 
 * <ul>
 * <li>Valor default: {@code ParametroTipo.DEFAULT}</li>
 * <li>Exemplo de uso:</li>
 * <ul>
 * <p>
 * {@code @verify}<br>
 * {@code private String nome;}<br>
 * {@code @verify(ParametroTipo.CPF_FORMATADO)}<br>
 * {@code private String cpf;}<br>
 * </p>
 * 
 * @author Gilmar Carlos
 *
 */
@Constraint(validatedBy = VerifyValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Verify {
	
	String message() default "O campo verificado contém caracteres inválidos";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
		
	ParametroTipo[] value() default ParametroTipo.DEFAULT;
	
	@Target({FIELD})
	@Retention(RUNTIME)
	@Documented
	@interface List {

		Verify[] value();
	}
	
}
