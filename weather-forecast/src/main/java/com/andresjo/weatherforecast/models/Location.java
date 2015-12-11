package com.andresjo.weatherforecast.models;

import java.util.TimeZone;

public class Location {
	
	private String name;
	private String type;
	private String country;
	
	private TimeZone timezone;
	
	private double latitude;
	private double longitude;
	private double altitude;
	
	private  Location(
			final String newName, final String newType, 
			final String newCountry, final TimeZone newTimezone, 
			final double newLatitude, final double newLongitude, 
			final double newAltitude){
		
		this.name = newName;
		this.type = newType;
		this.country = newCountry;
		this.timezone = newTimezone;
		this.latitude = newLatitude;
		this.longitude = newLongitude;
		this.altitude = newAltitude;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getCountry() {
		return country;
	}

	public TimeZone getTimezone() {
		return timezone;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public static class LocationBuilder{
		private String nestedName;
		private String nestedType;
		private String nestedCountry;
		
		private TimeZone nestedTimezone;
		
		private double nestedAltitude;
		private double nestedLatitude;
		private double nestedLongitude;
		
		public LocationBuilder name(final String name){
			this.nestedName = name;
			return this;
		}
		
		public LocationBuilder type(final String type){
			this.nestedType = type;
			return this;
		}
		
		public LocationBuilder country(final String country){
			this.nestedCountry = country;
			return this;
		}
		
		public LocationBuilder timezone(final TimeZone timezone){
			this.nestedTimezone = timezone;
			return this;
		}
		
		public LocationBuilder altitude(final double altitude){
			this.nestedAltitude= altitude;
			return this;
		}
		
		public LocationBuilder latitude(final double latitude){
			this.nestedLatitude = latitude;
			return this;
		}
		
		public LocationBuilder longitude(final double longitude){
			this.nestedLongitude = longitude;
			return this;
		}
		
		public Location build(){
			return new Location(
					nestedName, nestedType, 
					nestedCountry, nestedTimezone, 
					nestedLatitude, nestedLongitude, 
					nestedAltitude);
		}
		
	}

}
