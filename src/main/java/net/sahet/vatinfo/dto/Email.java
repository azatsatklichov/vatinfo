package net.sahet.vatinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Email {

	private String to;
	private String body;

	@Override
	public String toString() {
		return String.format("Email{to=%s, body=%s}", getTo(), getBody());
	}

}