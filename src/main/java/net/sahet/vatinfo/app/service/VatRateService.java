package net.sahet.vatinfo.app.service;

import java.util.List;

import net.sahet.vatinfo.app.dto.Rate;
import net.sahet.vatinfo.app.dto.VatRateResponse;

public interface VatRateService {

	VatRateResponse process();
	
	VatRateResponse demo();
	
	VatRateResponse duplicate();

	/**
	 * 
	 * @param rates
	 * @param highestVat - true to choose highest standard rates, false for lowest
	 *                   rates
	 * @param count      - how many item to list out
	 * @return
	 */
	List<String> getVatStandardRates(List<Rate> rates, boolean highestVat, int count);

}
