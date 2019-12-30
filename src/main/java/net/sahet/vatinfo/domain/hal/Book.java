package net.sahet.vatinfo.domain.hal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(columnDefinition = "VARCHAR", length = 100)
	private String title;

	@NotNull
	@Column(columnDefinition = "VARCHAR", length = 100)
	private String author;

	@Column(columnDefinition = "VARCHAR", length = 1000)
	private String blurb;

}
