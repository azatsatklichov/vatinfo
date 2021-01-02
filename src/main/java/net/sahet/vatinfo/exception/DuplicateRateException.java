package net.sahet.vatinfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Vat Rates found")
public class DuplicateRateException extends RuntimeException {

	public DuplicateRateException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = -8551300427268757457L;
}
