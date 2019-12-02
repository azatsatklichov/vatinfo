package net.sahet.vatinfo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents incoming request via like json file(request) http://jsonvat.com/
 *
 */
@Getter
@Setter
public class VatRateResponse {

	private String details;

	private String version;

	private List<Rate> rates;

}
