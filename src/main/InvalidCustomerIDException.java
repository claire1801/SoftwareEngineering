package main;

@SuppressWarnings("serial")
public class InvalidCustomerIDException extends Exception{

	public InvalidCustomerIDException(String message) {
		super(message);
	}
}
