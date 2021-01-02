package net.sahet.vatinfo.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;
import net.sahet.vatinfo.JsonTest;
import net.sahet.vatinfo.dto.Rate;
import net.sahet.vatinfo.dto.VatRateResponse;
import net.sahet.vatinfo.exception.VatRateNotFoundException;
import net.sahet.vatinfo.service.VatRateService;

@RestController
@Slf4j
public class RateResource3 {

	@Autowired
	private VatRateService vatRateService;

	@ResponseBody
	@RequestMapping(value = "/rates3", method = RequestMethod.GET)
	public Map<String, List<String>> getVatRates(
			@RequestParam(name = "count", required = false, defaultValue = "0") int count, Map<String, Object> model) {

		VatRateResponse resp = getVatRate(count);
		List<Rate> rates = resp.getRates();

		List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
		List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);

		Map<String, List<String>> mapVatRates = new HashMap<>();
		String key1 = "CountriesWithHighestStandardVATRates";
		mapVatRates.put(key1, vatHighestStandardRates);
		String key2 = "CountriesWithLowestStandardVATRates";
		mapVatRates.put(key2, vatLowestStandardRates);

		return mapVatRates;
	}

	private VatRateResponse getVatRate(int count) {
		// just to simulate NOT found
		if (count > 5) {
			throw new VatRateNotFoundException();
		}
		VatRateResponse rate = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		InputStream inputStream = JsonTest.class.getResourceAsStream("/vat.json");
		try {
			rate = mapper.readValue(inputStream, VatRateResponse.class);
		} catch (IOException e) {
			System.out.println("Issue with vat.json file" + e.getMessage());
		}
		return rate;
	}

}
