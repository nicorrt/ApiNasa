package com.anramirez.nasaApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NasaApiApplicationTests {
	
	@LocalServerPort
	private int port = 8080;

	@Test
	void contextLoads() {
	}

}
