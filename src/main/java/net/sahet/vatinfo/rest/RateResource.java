package net.sahet.vatinfo.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import net.sahet.vatinfo.exception.RateNotFoundException;
import net.sahet.vatinfo.exception.RateNotFoundException2;
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
@Slf4j
public class RateResource {

	@Autowired
	private VatRateService vatRateService;

	@RequestMapping(value = "/all_rates", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<VatRateResponse> getRates() {
		VatRateResponse resp = getVatRate();
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<VatRateResponse>(resp, httpHeaders, HttpStatus.OK);

	}

	@ResponseBody
	@RequestMapping(value = "/rates", method = RequestMethod.GET)
	public Map<String, List<String>> getVatRates(
			@RequestParam(name = "count", required = false, defaultValue = "0") int count, Map<String, Object> model) {

		VatRateResponse resp = getVatRate();

		List<Rate> rates = resp.getRates();
		if (rates == null || rates.isEmpty()) {
			String msg = "No Vat Rates found ";
			log.error(msg);
			throw new RateNotFoundException(msg);
		}

		List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
		List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);

		Map<String, List<String>> mapVatRates = new HashMap<>();
		String key1 = "CountriesWithHighestStandardVATRates";
		mapVatRates.put(key1, vatHighestStandardRates);
		String key2 = "CountriesWithLowestStandardVATRates";
		mapVatRates.put(key2, vatLowestStandardRates);

		return mapVatRates;

	}

	@ResponseBody
	@RequestMapping(value = "/ratess", method = RequestMethod.GET)
	public Map<String, List<String>> getVatRates2(
			@RequestParam(name = "count", required = false, defaultValue = "0") int count, Map<String, Object> model) {

		VatRateResponse resp = null; // getVatRate();

		/**
		 * If the getVatRates2() method is called on to handle a request, and the given
		 * ID comes up empty, the RateNotFoundException will (by default) result in a
		 * response with a 500 (Internal Server Error) status code. In fact, in the
		 * event of any exception that isn’t otherwise mapped, the response will always
		 * have a 500 status code. But you can change that by mapping
		 * RateNotFoundException otherwise. When RateNotFoundException is thrown, it’s a
		 * situation where a requested resource isn’t found.
		 * 
		 * The HTTP status code of 404 is precisely the appropriate response status code
		 * when a resource isn’t found. So, let’s use @ResponseStatus to map
		 * SpittleNotFoundException to HTTP status code 404.
		 * 
		 * So, see: RateResource2
		 * 
		 */
		if (resp == null) { // to simulate Not Found
			String msg = "No Vat Rates found ";
			log.error(msg);
			throw new RateNotFoundException(msg);
		}

//		List<Rate> rates = resp.getRates();
//
//		List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
//		List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);
//
		Map<String, List<String>> mapVatRates = new HashMap<>();
//		String key1 = "CountriesWithHighestStandardVATRates";
//		mapVatRates.put(key1, vatHighestStandardRates);
//		String key2 = "CountriesWithLowestStandardVATRates";
//		mapVatRates.put(key2, vatLowestStandardRates);

		return mapVatRates;

	}

	@ResponseBody
	@RequestMapping(value = "/ratesss", method = RequestMethod.GET)
	public Map<String, List<String>> getVatRates3(
			@RequestParam(name = "count", required = false, defaultValue = "0") int count, Map<String, Object> model) {

		// just to simulate no data found
		VatRateResponse resp = null; // getVatRate();

		/**
		 * If the getVatRates2() method is called on to handle a request, and the given
		 * ID comes up empty, the RateNotFoundException will (by default) result in a
		 * response with a 500 (Internal Server Error) status code. In fact, in the
		 * event of any exception that isn’t otherwise mapped, the response will always
		 * have a 500 status code. But you can change that by mapping
		 * RateNotFoundException otherwise. When RateNotFoundException is thrown, it’s a
		 * situation where a requested resource isn’t found.
		 * 
		 * The HTTP status code of 404 is precisely the appropriate response status code
		 * when a resource isn’t found. So, let’s use @ResponseStatus to map
		 * SpittleNotFoundException to HTTP status code 404.
		 * 
		 * So, see: RateResource2
		 * 
		 */
		if (resp == null) { // to simulate not Found, but with correct status-code
			String msg = "No Vat Rates found ";
			log.error(msg);
			throw new RateNotFoundException2();
		}

//		List<Rate> rates = resp.getRates();
//
//		List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
//		List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);
//
		Map<String, List<String>> mapVatRates = new HashMap<>();
//		String key1 = "CountriesWithHighestStandardVATRates";
//		mapVatRates.put(key1, vatHighestStandardRates);
//		String key2 = "CountriesWithLowestStandardVATRates";
//		mapVatRates.put(key2, vatLowestStandardRates);

		return mapVatRates;

	}

	private VatRateResponse getVatRate() {
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
