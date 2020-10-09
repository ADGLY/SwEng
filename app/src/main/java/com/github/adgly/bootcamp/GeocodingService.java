package com.github.adgly.bootcamp;

import com.github.adgly.bootcamp.location.LocationGetter;

import java.io.IOException;

public interface GeocodingService {
    String posToAddress(LocationGetter location) throws IOException;
}
