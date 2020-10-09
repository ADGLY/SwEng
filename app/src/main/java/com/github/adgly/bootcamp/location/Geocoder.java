package com.github.adgly.bootcamp.location;

import android.content.Context;
import android.location.Address;

import com.github.adgly.bootcamp.GeocodingService;

import java.io.IOException;

public class Geocoder implements GeocodingService {

    private final android.location.Geocoder geocoder;

    public Geocoder(Context context) {
        geocoder = new android.location.Geocoder(context);
    }

    @Override
    public String posToAddress(LocationGetter location) throws IOException {
        Address address = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0);
        return address.getAddressLine(0);
    }
}
