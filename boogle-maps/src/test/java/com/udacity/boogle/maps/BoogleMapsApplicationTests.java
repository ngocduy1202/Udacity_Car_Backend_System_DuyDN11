package com.udacity.boogle.maps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoogleMapsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getVehiclePrice() throws Exception{
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		//lat = latitude
		map.add("lat", "150.70");
		//lon = longitude
		map.add("lon", "140.60");

		mockMvc.perform(
						get(new URI("/maps"))
								.params(map)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
