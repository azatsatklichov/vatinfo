package net.sahet.vatinfo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.sahet.vatinfo.domain.VatRate;

public interface VatRateRepository extends MongoRepository<VatRate, String> {

}
