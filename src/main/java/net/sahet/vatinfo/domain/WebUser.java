package net.sahet.vatinfo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WebUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
}
