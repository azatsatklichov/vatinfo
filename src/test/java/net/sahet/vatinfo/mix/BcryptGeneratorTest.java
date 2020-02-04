package net.sahet.vatinfo.mix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGeneratorTest {

	/**
	 * Bcrypt encoder mechanism provide by spring security as it is the best encoder
	 * available.In the mean time, we will be using Spring boot to avoid common
	 * configurations.
	 * 
	 * Of course, there are also other encoding mechanism like MD5PasswordEncoder
	 * and ShaPasswordEncoder but these encoders are already deprecated.
	 * 
	 * What is Bcrypt Encoding
	 * 
	 * As per wiki, bcrypt is a password hashing function designed by Niels Provos
	 * and David Mazières, based on the Blowfish cipher. Bcrypt uses adaptive hash
	 * algorithm to store password.BCrypt internally generates a random salt while
	 * encoding passwords and hence it is obvious to get different encoded results
	 * for the same string.But one common thing is that everytime it generates a
	 * String of length 60.
	 */
	@Test(expected = AssertionError.class)
	public void testDiffMatch() {

		String password = "password";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);

		String enc = "$2a$10$.J318Pza.IOGhjkefFVJdONqNPzP.KmJjFRsjktGzEbVpqQ0/XR7K";
		assertEquals(hashedPassword, enc);
	}

}
