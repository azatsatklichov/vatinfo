package net.sahet.vatinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sahet.vatinfo.domain.mongo.Domain;
import net.sahet.vatinfo.repository.mongo.DomainRepository;
import net.sahet.vatinfo.repository.mongo.DomainRepositoryWithMongoTemplate;

@Service
public class DomainService {
 
	
	@Autowired
	private DomainRepository domainRepository;
	

//	@Autowired
//	private DomainRepositoryWithMongoTemplate domainRepositoryWithMongoTemplate;
	
	

	public void updateDomain(String domain, boolean displayAds) {

		Domain obj = domainRepository.findFirstByDomain(domain);
        System.out.println(obj);

        Domain obj2 = domainRepository.findFirstByDomain("mkyong.com");
        System.out.println(obj2);

        //obj2.setDisplayAds(true);
        //domainRepository.save(obj2);

        //int n = domainRepository.updateDomain("mkyong.com", true);
        //System.out.println("Number of records updated : " + n);

        //Domain obj3 = domainRepository.findOne(2000001L);
        //System.out.println(obj3);

        //Domain obj4 = domainRepository.findCustomByDomain("google.com");
        //System.out.println(obj4);

        //List<Domain> obj5 = domainRepository.findCustomByRegExDomain("google");
        //obj5.forEach(x -> System.out.println(x));                
        
        //domainRepositoryWithMongoTemplate.updateDomain(domain, displayAds);

	}

}
