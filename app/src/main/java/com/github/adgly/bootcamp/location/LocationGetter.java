package com.github.adgly.bootcamp.location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.github.adgly.bootcamp.LocationService;

public class LocationGetter implements LocationListener, LocationService {

    public LocationGetter(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        android.location.Location location = locationManager.getLastKnownLocation(locationManager.getProviders(true).get(0));
        assert location != null;
        Location.latitude = location.getLatitude();
        Location.longitude = location.getLongitude();
    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        Location.longitude = location.getLongitude();
        Location.latitude = location.getLatitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    @Override
    public double getLatitude() {
        return Location.latitude;
    }

    @Override
    public double getLongitude() {
        return Location.longitude;
    }
}
