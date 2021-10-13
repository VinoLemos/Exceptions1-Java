package model.exceptions;

/* RuntimeException: São exceções que o compilador não obriga você a tratar.
   Exception: São exceções que obrigam você a tratar
*/

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
}
