package net.sahet.vatinfo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.sahet.vatinfo.app.dto.VatRateResponse;
import net.sahet.vatinfo.app.exceptions.DuplicateSpittleException;
import net.sahet.vatinfo.app.service.VatRateService;

@RestController
public class DuplicateSpittleController {

	@Autowired
	VatRateService vatRateService;

	@RequestMapping(value = "/duplicate", method = RequestMethod.GET)
	public String spittle(Model model) {
		VatRateResponse response = vatRateService.duplicate();
		model.addAttribute(response);
		return "spittle";
	}

	@ExceptionHandler(DuplicateSpittleException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "409 Conflict")
	public String handlespittleNFE(DuplicateSpittleException ex) {
		return "Message duplicate: " + ex.getMessage();
	}

}
