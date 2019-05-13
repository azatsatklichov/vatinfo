package net.sahet.vatinfo.app.controller;

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

import net.sahet.vatinfo.app.dto.Rate;
import net.sahet.vatinfo.app.dto.VatRateResponse;
import net.sahet.vatinfo.app.exceptions.VatRateNotFoundException;
import net.sahet.vatinfo.app.service.VatRateService;

@RestController
public class ValoController {

	private static final Logger logger = LoggerFactory.getLogger(ValoController.class);

	@Autowired
	VatRateService vatRateService;
 
	@ResponseBody
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Map<String, List<String>> getVatRates(
            @RequestParam(name = "count", required = false, defaultValue = "3") int count, Map<String, Object> model) {

        VatRateResponse response = vatRateService.demo();
        
        if (response == null) {
            logger.error("No Vat Rates found ");
            throw new VatRateNotFoundException();
        }
        
        List<Rate> rates = response.getRates();

        List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
        List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);

        Map<String, List<String>> mapVatRates = new HashMap<>();
        mapVatRates.put("CountriesWithHighestStandardVATRates", vatHighestStandardRates);
        mapVatRates.put("CountriesWithLowestStandardVATRates", vatLowestStandardRates);

        return mapVatRates;

    }
}
