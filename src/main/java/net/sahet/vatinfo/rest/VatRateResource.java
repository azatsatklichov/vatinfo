package net.sahet.vatinfo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sahet.vatinfo.domain.Customer;
import net.sahet.vatinfo.domain.VatRate;
import net.sahet.vatinfo.dto.Rate;
import net.sahet.vatinfo.dto.VatRateResponse;
import net.sahet.vatinfo.exception.VatRateNotFoundException;
import net.sahet.vatinfo.service.VatRateService;

/**
 * Vat Rate API to get Standard VAT Rates for defined criteria
 * <p>
 * Prints out three EU countries with the lowest and three EU countries with the
 * highest standard VAT rate as of today within the EU.
 *
 * @author azat satklichov
 */
@RestController
public class VatRateResource {

	private static final Logger logger = LoggerFactory.getLogger(VatRateResource.class);

	@Autowired
	VatRateService vatRateService;

	@ResponseBody
	@RequestMapping(value = "/vatRates", method = RequestMethod.GET)
	public Map<String, List<String>> getVatRates(
			@RequestParam(name = "count", required = false, defaultValue = "0") int count, Map<String, Object> model) {

		VatRateResponse response = vatRateService.process();

		List<Rate> rates = response.getRates();
		if (rates == null || rates.isEmpty()) {
			logger.error("No Vat Rates found ");
			throw new VatRateNotFoundException();
		}

		List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
		List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);

		Map<String, List<String>> mapVatRates = new HashMap<>();
		String key1 = "CountriesWithHighestStandardVATRates";
		mapVatRates.put(key1, vatHighestStandardRates);
		String key2 = "CountriesWithLowestStandardVATRates";
		mapVatRates.put(key2, vatLowestStandardRates);

		//save to mongo 
		vatRateService.addVatRate(new VatRate(key1, vatHighestStandardRates));
		vatRateService.addVatRate(new VatRate(key2, vatLowestStandardRates));

		return mapVatRates;

	}

}
