package net.sahet.vatinfo.domain.mongo;

import java.util.List;

import org.springframework.data.annotation.Id;

public class VatRate {

	@Id
	public String id;
 
	public List<String> vatRates;
 

	public VatRate() {
	}
	public VatRate(String id, List<String> vatRates) {
		this.id = id;
		this.vatRates = vatRates;
	}

	@Override
	public String toString() {
		return String.format("VateRate[id=%s, vatRates='%s']", id, vatRates);
	}

}
