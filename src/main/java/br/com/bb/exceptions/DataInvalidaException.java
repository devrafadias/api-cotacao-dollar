package br.com.bb.exceptions;

public class DataInvalidaException extends RuntimeException {

	private static final long serialVersionUID = -6963351705608214490L;

	public DataInvalidaException(String message) {
        super(message);
    }
	
}
