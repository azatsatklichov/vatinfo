package net.sahet.vatinfo.exception;

public class RateNotFoundException extends RuntimeException {

	public RateNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = -8551300427268757457L;
}
