package net.sahet.vatinfo;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import net.sahet.vatinfo.dto.VatRateResponse;

public class JsonTest {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		InputStream inputStream = JsonTest.class.getResourceAsStream("/vat.json");
		try {
			VatRateResponse readValue = mapper.readValue(inputStream, VatRateResponse.class);
			System.out.println(readValue.getRates());
		} catch (IOException e) {
			System.out.println("Unable to save users: " + e.getMessage());
		}
	}

}
