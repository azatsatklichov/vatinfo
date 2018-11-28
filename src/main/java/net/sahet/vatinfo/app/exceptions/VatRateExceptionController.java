package net.sahet.vatinfo.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VatRateExceptionController {

	@ExceptionHandler(value = VatRateNotFoundException.class)
	public ResponseEntity<Object> exception(VatRateNotFoundException exception) {
		return new ResponseEntity<>("VatRate not found", HttpStatus.NOT_FOUND);
	}

}