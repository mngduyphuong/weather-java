package performio.weather_app.service;

// dependencies
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// model, config
import performio.weather_app.config.OpenWeatherConfig;
import performio.weather_app.model.WeatherModel;

@Service
public class WeatherService {
    private final OpenWeatherConfig openWeatherConfig;
    private final RestTemplate restTemplate;

    public WeatherService(OpenWeatherConfig openWeatherConfig) {
        this.openWeatherConfig = openWeatherConfig;
        this.restTemplate = new RestTemplate();
    }

    public WeatherModel getWeather(String location) {
        // sanitising location param: remove whitespace and extra double quotes
        location = location.replaceAll("[\"\\s]", "");
        // api call format: https://api.openweathermap.org/data/2.5/weather?q={location
        // name}&appid={API key}&<addition formats>
        String url = String.format("%s?q=%s&appid=%s&units=metric", openWeatherConfig.getUrl(), location,
                openWeatherConfig.getKey());
        return restTemplate.getForObject(url, WeatherModel.class);
    }
}
