package net.sahet.vatinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import net.sahet.vatinfo.common.CustomDateSerializer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Period {

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("effective_from")
    private LocalDate effectiveFrom;

    private Map<String, Double> rates = new HashMap<>();
}
