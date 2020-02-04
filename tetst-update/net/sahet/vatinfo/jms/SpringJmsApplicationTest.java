package net.sahet.vatinfo.jms;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringJmsApplicationTest {

	@Autowired
	private Sender sender;

	@Autowired
	private Receiver receiver;

	@Test
	public void testReceive() throws Exception {
		sender.send("outbound.topic", "Salam Dunya!");

		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertEquals(receiver.getLatch().getCount(), 1);
	}
}
