package net.sahet.vatinfo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.sahet.vatinfo.domain.VatRate;
import net.sahet.vatinfo.dto.Rate;
import net.sahet.vatinfo.dto.VatRateResponse;
import net.sahet.vatinfo.repository.mongo.VatRateRepository;

@Service
public class VatRateServiceImpl implements VatRateService {

	@Value("${vat.json.source.url}")
	private String vatSourceFromUrl;

	@Autowired
	private VatRateRepository vatRateService;

	@Override
	public VatRateResponse process() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(vatSourceFromUrl, VatRateResponse.class);
	}

	@Override
	public List<String> getVatStandardRates(List<Rate> rates, boolean highestVat, int count) {

		if (rates == null) {
			return Collections.emptyList();
		}

		if (count < rates.size()) {
			if (highestVat) {
				return rates.stream().sorted(Comparator.comparing(Rate::getStandardRate)).limit(count)
						.map(Rate::getName).collect(Collectors.toList());

			} else {
				return rates.stream().sorted((o1, o2) -> o2.getStandardRate().compareTo(o1.getStandardRate()))
						.limit(count).map(Rate::getName).collect(Collectors.toList());
			}
		}

		return rates.stream().map(Rate::getName).collect(Collectors.toList());
	}

	public void addVatRate(VatRate vatRate) {
		vatRateService.save(vatRate);
		System.out.println("-------------------------------");
		List<VatRate> findAll = vatRateService.findAll();
		findAll.stream().forEach(System.out::println);
	}

}
