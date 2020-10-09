package com.github.adgly.bootcamp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.github.adgly.bootcamp.location.Geocoder;
import com.github.adgly.bootcamp.location.LocationGetter;

import org.json.JSONException;

import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private static LocationGetter location;
    private static Geocoder geocoder;
    private static Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        checkLocationPermission();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        location = new LocationGetter(this);
        geocoder = new Geocoder(this);
        weather = new Weather();

    }

    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }


    public void getMeteoFromPos(@SuppressWarnings("unused") View view) throws IOException, JSONException {
        WeatherData data = weather.getWeather(location, this.getString(R.string.openweather_api_key));
        TextView textView = findViewById(R.id.tempResult);
        textView.setText("" + data.temp + "°C");

        TextView addressFromPos = findViewById(R.id.addressFromPos);
        addressFromPos.setText(geocoder.posToAddress(location));

    }

}