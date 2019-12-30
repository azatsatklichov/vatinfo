package net.sahet.vatinfo.domain.mongo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "kino")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Movie {

	@Id
	public Long id;

	private String name;

	private String sazy;

	public List<String> actors;

}
