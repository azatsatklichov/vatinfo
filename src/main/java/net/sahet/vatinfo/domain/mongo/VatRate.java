package net.sahet.vatinfo.domain.mongo;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VatRate {

    @Id
    private String id;

    private List<String> vatRates;

    public VatRate(String id, List<String> vatRates) {
        this.id = id;
        this.vatRates = vatRates;
    }

    @Override
    public String toString() {
        return String.format("VateRate[id=%s, vatRates='%s']", id, vatRates);
    }

}
