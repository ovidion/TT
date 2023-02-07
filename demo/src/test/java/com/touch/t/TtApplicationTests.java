package com.touch.t;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sachag
 *
 */
@SpringBootTest
class TtApplicationTests  {
	
	@Autowired
	private JukeboxService jukeboxService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void jukeboxApiTest1() {
		Collection<Jukebox> jukeboxes = jukeboxService.getValidJukeboxes("e9869bbe-887f-4d0a-bb9d-b81eb55fbf0a", null, 0, 0);
		assertEquals(0, jukeboxes.size());
	}
	
	@Test
	public void jukeboxApiTest2() {
		Collection<Jukebox> jukeboxes = jukeboxService.getValidJukeboxes("2321763c-8e06-4a31-873d-0b5dac2436da", null, 0, 0);
		assertEquals(2, jukeboxes.size());
	}
	
	@Test
	public void jukeboxApiTest3() {
		Collection<Jukebox> jukeboxes = jukeboxService.getValidJukeboxes("b43f247a-8478-4f24-8e28-792fcfe539f5", null, 0, 0);
		assertEquals(1, jukeboxes.size());
	}
	
	
	
	@Test
	public void jukeboxApiModelTest4() {
		Collection<Jukebox> jukeboxes = jukeboxService.getValidJukeboxes("922a8e2b-6278-498a-a54a-fd92206ace67", null, 0, 0);
		assertEquals(30, jukeboxes.size());
		
		jukeboxes = jukeboxService.getValidJukeboxes("922a8e2b-6278-498a-a54a-fd92206ace67", "fusion", 0, 0);
		assertEquals(10, jukeboxes.size());
	}
	
	@Test
	public void jukeboxApiOffsetAndLimitTest5() {
		Collection<Jukebox> jukeboxes = jukeboxService.getValidJukeboxes("922a8e2b-6278-498a-a54a-fd92206ace67", null, 4, 16);
		assertEquals(16, jukeboxes.size());
	}
	
	
	@Test
	public void jukeboxApiCompleteTest() {
		Collection<Jukebox> jukeboxes = jukeboxService.getValidJukeboxes("358a044e-decc-47cc-aaf1-e2253a00998e", "fusion", 1, 2);
		assertEquals(2, jukeboxes.size());
	}

}