package br.com.safeguard.interfaces;

import br.com.caelum.stella.validation.Validator;

/**
 * Interface que deve ser implementada por um (Enum) de validadores (ParametroTipo)
 *  para ser usado como um (Enum) que retorna instacias da classe (br.com.caelum.stella.validation.Validator)
 * 
 * 
 * @see 
 * <ul>
 * <li>Exemplo de implementação</li> 
 * </ul>
 *  <p> 		
 *	{@code TIPO_DO_PADRAO(new Class<? extends Validator>)) 	}<br><br>
 *	{@code private Validator<String> tipo;                  }<br><br>
 *	{@code private Patterns(Validator<String> tipo)		    }<br>
 *	{@code this.tipo = tipo;      			         		}<br><br>
 *	{@code @Override                       					}<br>
 *	{@code public String getType()     						}<br>
 *	{@code return tipo;      				   				}<br>
 * 	</p>
 * 
 * @author Gilmar Carlos
 *
 */
public interface BaseParam {
	
	 Validator<String> getType();

}
