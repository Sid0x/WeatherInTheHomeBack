package skayev.WeatherInTheHomeBack.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import skayev.WeatherInTheHomeBack.service.WeatherService;

@RestController
@AllArgsConstructor
public class SensorDataApi {

    private WeatherService weatherService;

    @PostMapping("/save-weather-data")
    private Object saveWeatherData() {
        weatherService.save();
        return "test";
    }
}
