package performio.weather_app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//additional for testing
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherAppApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetWeather() throws Exception {
		String location = "Melbourne,AU";
		MvcResult result = mockMvc.perform(get("/weather")
				.param("location", location))
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		assertNotNull(content);
		assertTrue(content.contains("main"));
		assertTrue(content.contains("description"));
		assertTrue(content.contains("temp"));
		assertTrue(content.contains("humidity"));
		assertTrue(content.contains("\"name\":\"Melbourne\""));
		assertTrue(content.contains("\"country\":\"AU\""));
	}

	@Test
	public void testGetWeatherMelbourneUS() throws Exception {
		String location = "Melbourne";
		MvcResult result = mockMvc.perform(get("/weather")
				.param("location", location))
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		assertNotNull(content);
		assertTrue(content.contains("main"));
		assertTrue(content.contains("description"));
		assertTrue(content.contains("temp"));
		assertTrue(content.contains("humidity"));
		assertTrue(content.contains("\"name\":\"Melbourne\""));
		assertTrue(content.contains("\"country\":\"US\""));
	}

	@Test
	public void testGetWeatherWithQuotesAndSpace() throws Exception {
		String location = "\" Melbourne , AU \"";
		MvcResult result = mockMvc.perform(get("/weather")
				.param("location", location))
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		assertNotNull(content);
		assertTrue(content.contains("main"));
		assertTrue(content.contains("description"));
		assertTrue(content.contains("temp"));
		assertTrue(content.contains("humidity"));
		assertTrue(content.contains("\"name\":\"Melbourne\""));
		assertTrue(content.contains("\"country\":\"AU\""));
	}
}
