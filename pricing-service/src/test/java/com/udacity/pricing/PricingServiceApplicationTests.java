package com.udacity.pricing;

import com.netflix.discovery.shared.Application;
import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
//@SpringBootTest
@ContextConfiguration(classes= Application.class)
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	PricingService pricingService;

	private static final String VALID_ID = "1";
	private static final String INVALID_ID = "a1";
	@Test
	public void contextLoads() {
	}

	@Test
	public void getRequest() throws Exception{
		mockMvc.perform(get("/services/price?vehicleId="+VALID_ID))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}


//	@Test
//	public void testGetRequest() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders
//						.get("/services/price?vehicleId="+VALID_ID)
//						.accept(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	public void getPriceInvalidVehicleId() throws Exception {
//		mockMvc.perform(
//						get(new URI("/services/price?vehicleId=1"+INVALID_ID))
//								.contentType(MediaType.APPLICATION_JSON)
//								.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotFound());
//	}

}
