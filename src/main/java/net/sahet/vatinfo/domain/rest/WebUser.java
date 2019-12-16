package net.sahet.vatinfo.domain.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WebUser {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
}
