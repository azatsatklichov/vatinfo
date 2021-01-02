package net.sahet.vatinfo.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sahet.vatinfo.dto.VatRateResponse;
import net.sahet.vatinfo.exception.DuplicateRateException;
import net.sahet.vatinfo.service.VatRateService;

@RestController
public class RateResource2 {

	@Autowired
	private VatRateService vatRateService;

	@ResponseBody
	@RequestMapping(value = "/rates2", method = RequestMethod.GET)
	public String getVatRates(@RequestParam(name = "id", required = false, defaultValue = "0") int id,
			Map<String, Object> model) {
		// just to simulate save case
		VatRateResponse resp = saveVatRate(id);
		return "successfuly saved";

	}

	@ExceptionHandler(DuplicateRateException.class)
	public String handleRateDuplication() {
		return "fail - duplication found during save";

	}

	// just to simulate save case
	private VatRateResponse saveVatRate(int id) {

		// dummy simulation to show duplication case
		if (id > 2) {
			throw new DuplicateRateException("Rate Duplication. RAte exists already with this ID");
		}

		// TODO return saved object
		return null;
	}

}
