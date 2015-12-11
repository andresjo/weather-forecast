package com.andresjo.weatherforecast.application;

import java.time.LocalDateTime;
import java.util.TimeZone;

import com.andresjo.weatherforecast.models.Forecast;
import com.andresjo.weatherforecast.models.Location;
import com.andresjo.weatherforecast.models.Location.LocationBuilder;
import com.andresjo.weatherforecast.models.Forecast.ForecastBuilder;

public class App {

	public static void main(String[] args) {
		
		final Location location = new LocationBuilder().name("Blindern").type("Byområde").country("Norway").
				timezone(TimeZone.getTimeZone("Europe/Oslo")).latitude(59.9406284402542).longitude(10.7230684724138).altitude(90).build();
		
		Forecast forecast = new ForecastBuilder().location(location).fromTime(LocalDateTime.parse("2015-09-09T12:00:00")).
				toTime(LocalDateTime.parse("2015-09-09T18:00:00")).symbol("3").symbolName("Delvis skyet").precipitation(0).windDirectionName("Sør-sørvest").
				windSpeed(0.8).windName("Flau vind").temperature(18).build();
		
		System.out.println(forecast+ "\n");
		System.out.println(forecast.getLocation().getTimezone().getDisplayName());
		

	}
	
	
	

}
