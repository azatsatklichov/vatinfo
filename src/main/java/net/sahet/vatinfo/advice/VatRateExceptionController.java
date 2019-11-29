package net.sahet.vatinfo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.sahet.vatinfo.exception.VatRateNotFoundException;

@ControllerAdvice
public class VatRateExceptionController {

	@ExceptionHandler(value = VatRateNotFoundException.class)
	public ResponseEntity<Object> exception(VatRateNotFoundException exception) {
		return new ResponseEntity<>("VatRate not found", HttpStatus.NOT_FOUND);
	}
}
