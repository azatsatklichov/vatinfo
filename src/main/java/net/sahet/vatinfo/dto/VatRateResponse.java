package net.sahet.vatinfo.dto;

import java.util.List;

/**
 * Represents incoming request via like json file(request) http://jsonvat.com/
 *
 */
public class VatRateResponse {

	private String details;

	private String version;

	private List<Rate> rates;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}
