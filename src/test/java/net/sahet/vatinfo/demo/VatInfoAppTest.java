package net.sahet.vatinfo.demo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import net.sahet.vatinfo.base.AbstractTest;

public class VatInfoAppTest extends AbstractTest {

    @Test
    public void testVatInfoFor3Countries() {

        Map<String, List<String>> result = (new RestTemplate()).getForObject(VATINFO_URI, Map.class);
        // two sets of criterias
        Assert.assertEquals(2, result.size());
        // number of countries
        Assert.assertEquals(0, result.get("CountriesWithHighestStandardVATRates").size());
        Assert.assertEquals(0, result.get("CountriesWithLowestStandardVATRates").size());

        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        writeResponseToFile(result.toString(), "testVatInfoFor3Countries");
    }

    @Test
    public void testVatInfoFor5Countries() {
        Map<String, List<String>> result = (new RestTemplate()).getForObject(VATINFO_URI + "/?count=5", Map.class);
        // two sets of criterias
        Assert.assertEquals(2, result.size());
        // number of countries
        Assert.assertEquals(5, result.get("CountriesWithHighestStandardVATRates").size());
        Assert.assertEquals(5, result.get("CountriesWithLowestStandardVATRates").size());

        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        writeResponseToFile(result.toString(), "testVatInfoFor5Countries");

    }

}