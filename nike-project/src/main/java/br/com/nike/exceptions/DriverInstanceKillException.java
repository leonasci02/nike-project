package br.com.nike.exceptions;

public class DriverInstanceKillException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DriverInstanceKillException() {
		super();
	}
	
	public DriverInstanceKillException(String message) {
		super(message);
	}
}
