package net.sahet.vatinfo.dto;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.sahet.vatinfo.common.RateType;

public class Rate {

	private String name;

	private String code;

	@JsonProperty("country_code")
	private String countryCode;

	private List<Period> periods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public Double getStandardRate() {

		Period latest = getPeriods().stream().sorted(Comparator.comparing(Period::getEffectiveFrom))
				.skip(periods.size() - 1).findFirst().get();
		return latest.getRates().get(RateType.STANDARD.getValue());
	}

	public Double getReducedRate() {
		Period latest = getPeriods().stream().sorted(Comparator.comparing(Period::getEffectiveFrom))
				.skip(periods.size() - 1).findFirst().get();
		return latest.getRates().get(RateType.REDUCED.getValue());
	}

}
