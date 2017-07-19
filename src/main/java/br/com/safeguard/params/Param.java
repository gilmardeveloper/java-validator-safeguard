package br.com.safeguard.params;

import java.io.Serializable;

import br.com.safeguard.interfaces.BaseParam;

/**
 * 
 * Classe pojo usada para servir de bind para validação de paramentros
 * 
 * @author Gilmar Carlos
 *
 */
public class Param implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BaseParam type;
	private String value;
		
	public Param(BaseParam type, String value) {
		this.type = type;
		this.value = value;
	}
	public BaseParam getType() {
		return type;
	}
	public void setType(BaseParam type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	

}
