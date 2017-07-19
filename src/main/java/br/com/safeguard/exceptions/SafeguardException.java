package br.com.safeguard.exceptions;

/**
 * Classe que especifica uma exceção do tipo checked para evitar erros de compilação
 * 
 * @author Gilmar Carlos
 *
 */
public class SafeguardException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Contrutor padrão que lança uma exceção genérica
	 */
	public SafeguardException() {
		super();
	}
	
	/**
	 * 
	 * Construtor que recebe uma mensagem (String) com detalhes sobre a exceção
	 * 
	 * @param message Mensagem de erro
	 */
	public SafeguardException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * Construtor que recebe um (Throwable) com detalhes sobre a causa da exceção
	 * 
	 * @param cause Causa do erro
	 */
	public SafeguardException(Throwable cause) {
		super(cause);
	}

	/**
	 *
	 * Construtor que recebe uma mesnagem (String) e um (Throwable) com detalhes sobre a causa da exceção
	 * 
	 * @param message Mensagem de erro
	 * @param cause Causa do erro
	 */
	public SafeguardException(String message, Throwable cause) {
		super(message, cause);
	}
}
