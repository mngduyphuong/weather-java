package performio.weather_app.controller;

// dependencies
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import performio.weather_app.model.WeatherModel;
import performio.weather_app.service.WeatherService;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    // url endpoint "/weather", apply business logic in WeatherModel
    public WeatherModel getWeather(@RequestParam String location) {
        return weatherService.getWeather(location);
    }
}
