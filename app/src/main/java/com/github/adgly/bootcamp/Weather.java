package com.github.adgly.bootcamp;

import com.github.adgly.bootcamp.location.LocationGetter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import android.content.Context;

public class Weather implements WeatherService {

    @SuppressWarnings("unused")
    @Override
    public WeatherData getWeather(LocationGetter location, String key) throws IOException, JSONException {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        String queryURL = "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude +
                "&units=metric" + "&appid=" + key;
        URL url = new URL(queryURL);
        HttpsURLConnection connection;

        connection = (HttpsURLConnection) url.openConnection();
        connection.setReadTimeout(3000);
        connection.setConnectTimeout(3000);
        connection.setRequestMethod("GET");

        // Already true by default but setting just in case; needs to be true since this request
        // is carrying an input (response) body.
        connection.setDoInput(true);

        //noinspection unused
        int responseCode = connection.getResponseCode();
        // Do something with responseCode

        InputStream stream = connection.getInputStream();

        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (stream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }

        String test = textBuilder.toString();

        JSONObject json = new JSONObject(test);
        double temp = json.getJSONObject("current").getDouble("temp");
        stream.close();
        connection.disconnect();
        return new WeatherData(temp);
    }
}
