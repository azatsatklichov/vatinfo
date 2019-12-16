package net.sahet.vatinfo.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "domain")
public class Domain {

	@Id
	private long id;

	@Indexed(unique = true)
	private String domain;

	private boolean displayAds;

	@Override
	public String toString() {
		return "Domain{" + "id=" + id + ", domain='" + domain + '\'' + ", displayAds=" + displayAds + '}';
	}
}
