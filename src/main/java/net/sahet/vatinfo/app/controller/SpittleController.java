package net.sahet.vatinfo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sahet.vatinfo.app.dto.VatRateResponse;
import net.sahet.vatinfo.app.exceptions.SpittleNotFoundException;
import net.sahet.vatinfo.app.exceptions.SpittleNotFoundException2;
import net.sahet.vatinfo.app.service.VatRateService;

@RestController
public class SpittleController {

	@Autowired
	VatRateService vatRateService;

	@RequestMapping(value = "/spittle", method = RequestMethod.GET)
	public String spittle(Model model) {
		VatRateResponse response = vatRateService.demo();
		if (response == null) {
			throw new SpittleNotFoundException();
		}
		model.addAttribute(response);
		return "spittle";
	}


	@RequestMapping(value = "/spittle2", method = RequestMethod.GET)
	public String spittle2(Model model) {
		VatRateResponse response = vatRateService.demo();
		if (response == null) {
			throw new SpittleNotFoundException2();
		}
		model.addAttribute(response);
		return "spittle";
	} 

}
