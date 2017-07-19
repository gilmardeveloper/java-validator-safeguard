package br.com.safeguard.interfaces;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * Interface que extende de (br.com.caelum.stella.validation) que deve ser
 * implementada por um (Enum) de padrões (Pattern) para ser usado em um (Enum) que implementa a interface (BaseParam)
 * 
 * 
 * @see 
 * <ul>
 * <li>https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html</li>
 * <li>Exemplo de implementação</li> 
 *  </ul>
 *  <p> 		
 *	{@code TIPO_DO_PADRAO(new String("[pattern]"))  }<br><br>
 *	{@code private String pattern;                  }<br><br>
 *	{@code private Patterns(String pattern)		    }<br>
 *	{@code this.pattern = pattern;           		}<br><br>
 *	{@code @Override                       			}<br>
 *	{@code public String getPattern()     			}<br>
 *	{@code return pattern;      				    }<br>
 * 	</p>
 * 
 * @author Gilmar Carlos
 *
 */
public interface BasePattern extends InvalidValue {

	String getPattern();

}
