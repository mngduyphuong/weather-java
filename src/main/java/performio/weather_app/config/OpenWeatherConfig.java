package performio.weather_app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// config for OpenWeatherMap API
@Configuration
@ConfigurationProperties(prefix = "openweather.api")
public class OpenWeatherConfig {
    private String key;
    private String url;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
