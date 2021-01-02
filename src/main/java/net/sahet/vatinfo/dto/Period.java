package net.sahet.vatinfo.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
//import net.sahet.vatinfo.common.CustomDateSerializer;

@Getter
@Setter
public class Period {

	// @JsonSerialize(using = CustomDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("effective_from")
	private LocalDate effectiveFrom;

	private Map<String, Double> rates = new HashMap<>();
}
