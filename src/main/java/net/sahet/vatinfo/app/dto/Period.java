package net.sahet.vatinfo.app.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.sahet.vatinfo.app.common.CustomDateSerializer;

public class Period {

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("effective_from")
    private LocalDate effectiveFrom;

    private Map<String, Double> rates = new HashMap<>();

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
