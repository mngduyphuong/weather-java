package performio.weather_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// config for OpenWeatherMap API
@Configuration
@ConfigurationProperties(prefix = "openweather.api")
public class OpenWeatherConfig {
    private String url;

    @Value("${OPENWEATHER_API_KEY}")
    private String key;

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
