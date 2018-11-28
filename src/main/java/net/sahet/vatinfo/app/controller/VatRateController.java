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

/**
 * Vat Rate API to get Standard VAT Rates for defined criteria
 * 
 * Prints out three EU countries with the lowest and three EU countries with the
 * highest standard VAT rate as of today within the EU.
 * 
 * 
 * @author azat satklichov
 *
 */
@RestController
public class VatRateController {

    private static final Logger logger = LoggerFactory.getLogger(VatRateController.class);

    @Autowired
    VatRateService vatRateService;

    @ResponseBody
    @RequestMapping(value = "/vatRates", method = RequestMethod.GET)
    public Map<String, List<String>> getVatRates(
            @RequestParam(name = "count", required = false, defaultValue = "3") int count, Map<String, Object> model) {

        VatRateResponse response = vatRateService.process();

        List<Rate> rates = response.getRates();
        if (rates == null || rates.isEmpty()) {
            logger.error("No Vat Rates found ");
            throw new VatRateNotFoundException();
        }

        List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
        List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);

        Map<String, List<String>> mapVatRates = new HashMap<>();
        mapVatRates.put("CountriesWithHighestStandardVATRates", vatHighestStandardRates);
        mapVatRates.put("CountriesWithLowestStandardVATRates", vatLowestStandardRates);

        return mapVatRates;

    }
}
