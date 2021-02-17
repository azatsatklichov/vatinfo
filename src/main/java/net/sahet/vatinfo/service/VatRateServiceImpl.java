package net.sahet.vatinfo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import net.sahet.vatinfo.domain.mongo.VatRate;
import net.sahet.vatinfo.dto.Rate;
import net.sahet.vatinfo.dto.VatRateResponse;
import net.sahet.vatinfo.repository.mongo.VatRateRepository;

@Service
@Slf4j
public class VatRateServiceImpl implements VatRateService {

	@Value("${vat.json.source.url}")
	private String vatSourceFromUrl;

	@Autowired
	private VatRateRepository vatRateRepository;

	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public VatRateResponse process() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response,
		// not only application/*json, which is the default behaviour
		// converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		// messageConverters.add(converter);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);

		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.TEXT_HTML);
		mediaTypes.add(MediaType.APPLICATION_JSON);
		converter.setSupportedMediaTypes(mediaTypes);
		messageConverters.add(converter);
		messageConverters.add(new StringHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);

		ResponseEntity<VatRateResponse> forEntity = restTemplate.getForEntity(vatSourceFromUrl, VatRateResponse.class);

		// return restTemplate.getForObject(vatSourceFromUrl, VatRateResponse.class);
		return forEntity.getBody();
	}

	@Override
	public List<String> getVatStandardRates(List<Rate> rates, boolean highestVat, int count) {

		if (rates == null) {
			return Collections.emptyList();
		}

		log.info("Vat rates are under being processed");
		jmsTemplate.convertAndSend("hat-habar-queue", "VAT Rates are processed");

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
		vatRateRepository.save(vatRate);
		System.out.println("-------------------------------");
		List<VatRate> findAll = vatRateRepository.findAll();
		findAll.stream().forEach(System.out::println);
	}

}
