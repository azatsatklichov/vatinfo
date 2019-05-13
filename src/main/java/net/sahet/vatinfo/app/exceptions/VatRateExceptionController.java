package net.sahet.vatinfo.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VatRateExceptionController {

	@ExceptionHandler(value = VatRateNotFoundException.class)
	public ResponseEntity<Object> exception(VatRateNotFoundException exception) {
		return new ResponseEntity<>("VatRate not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = VatRateNotFoundException4.class)
	public ResponseEntity<Error> exception2(VatRateNotFoundException4 exception) {
		Error error = new Error(404, "Message !!!" + exception.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = VatRateNotFoundException5.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Error exception5(VatRateNotFoundException5 exception) {
		return new Error(404, "Message !!!" + exception.getMessage());
	}
	

	/*// in Case you use below method in RestController then no need  @ResponseBody
	 * @ExceptionHandler(value = VatRateNotFoundException5.class)
	 * 
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public Error
	 * exception5(VatRateNotFoundException5 exception) { return new Error(404,
	 * "Message !!!" + exception.getMessage()); }
	 */

}