package performio.weather_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
// import and enable config
import performio.weather_app.config.OpenWeatherConfig;

@EnableConfigurationProperties(OpenWeatherConfig.class)
@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

}
