package com.github.adgly.bootcamp;

import com.github.adgly.bootcamp.location.LocationGetter;

import org.json.JSONException;

import java.io.IOException;

public interface WeatherService {
    WeatherData getWeather(LocationGetter location, String key) throws IOException, JSONException;
}
