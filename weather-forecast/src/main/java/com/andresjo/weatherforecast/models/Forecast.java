package com.andresjo.weatherforecast.models;

import java.time.LocalDateTime;

public class Forecast {
	private Location location;
	
	private LocalDateTime fromTime;
	private LocalDateTime toTime;
	
	private String symbol;
	private String symbolName;
	
	private double precipitation;
	
	private String windDirectionCode;
	private String windDirectionName;
	
	private double windSpeed; 
	private String windSpeedName;
	
	private String temperatureUnit;
	private double temperature;
	
	private Forecast(
			Location location, LocalDateTime fromTime, 
			LocalDateTime toTime, String symbol,
			String symbolName, double precipitation,
			String windDirectionCode,
			String windDirectionName, double windSpeed, 
			String windName, String temperatureUnit,
			double temperature){
		
		this.location = location;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.symbol = symbol;
		this.symbolName = symbolName;
		this.precipitation = precipitation;
		this.windDirectionCode = windDirectionCode;
		this.windDirectionName = windDirectionName;
		this.windSpeed = windSpeed;
		this.windSpeedName = windName;
		this.temperatureUnit = temperatureUnit;
		this.temperature = temperature;
		
	}

	public Location getLocation() {
		return location;
	}

	public LocalDateTime getFromTime() {
		return fromTime;
	}

	public LocalDateTime getToTime() {
		return toTime;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public String getSymbolName(){
		return symbolName;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public String getWindDirectionCode() {
		return windDirectionCode;
	}
	
	public String getWindDirectionName() {
		return windDirectionName;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public String getWindName() {
		return windSpeedName;
	}
	
	public String getTemperatureUnit(){
		return temperatureUnit;
	}

	public double getTemperature() {
		return temperature;
	}
	
	public String toString(){
		String res = "";
		
		res += "Værmelding for "+location.getName()+ ", "+location.getCountry()+".\n";
		res += symbolName+ ", "+windDirectionName+" "+windSpeedName+".\n";
		res += temperature+" grader, "+precipitation+"mm nedbør.";
		
		return res;
	}

	public static class ForecastBuilder{
		private Location nestedLocation;
		private LocalDateTime nestedFromTime;
		private LocalDateTime nestedToTime;
		private String nestedSymbol;
		private String nestedSymbolName;
		private double nestedPrecipitation;
		private String nestedWindDirectionCode;
		private String nestedWindDirectionName;
		private double nestedWindSpeed;
		private String nestedWindName;
		private String nestedTemperatureUnit;
		private double nestedTemperature;
		
		public ForecastBuilder location(Location location){
			this.nestedLocation = location;
			return this;
		}
		
		public ForecastBuilder fromTime(LocalDateTime fromTime){
			this.nestedFromTime = fromTime;
			return this;
		}
		
		public ForecastBuilder toTime(LocalDateTime toTime){
			this.nestedToTime = toTime;
			return this;
		}
		
		public ForecastBuilder symbol(String symbol){
			this.nestedSymbol = symbol;
			return this;
		}
		
		public ForecastBuilder symbolName(String symbolName){
			this.nestedSymbolName = symbolName;
			return this;
		}
		
		public ForecastBuilder precipitation(double precipitation){
			this.nestedPrecipitation = precipitation;
			return this;
		}
		
		public ForecastBuilder windDirectionCode(String windDirectionCode){
			this.nestedWindDirectionCode = windDirectionCode;
			return this;
		}
		
		public ForecastBuilder windDirectionName(String windDirectionName){
			this.nestedWindDirectionName = windDirectionName;
			return this;
		}
		
		public ForecastBuilder windSpeed(double windSpeed){
			this.nestedWindSpeed = windSpeed;
			return this;
		}
		
		public ForecastBuilder windName(String windName){
			this.nestedWindName = windName;
			return this;
		}
		
		public ForecastBuilder temperatureUnit(String temperatureUnit){
			this.nestedTemperatureUnit = temperatureUnit;
			return this;
		}
		
		public ForecastBuilder temperature(double temperature){
			this.nestedTemperature = temperature;
			return this;
		}
		
		public Forecast build(){
			return new Forecast(
					nestedLocation, nestedFromTime, 
					nestedToTime, nestedSymbol, nestedSymbolName,
					nestedPrecipitation, nestedWindDirectionCode, 
					nestedWindDirectionName, nestedWindSpeed, 
					nestedWindName, nestedTemperatureUnit, 
					nestedTemperature);
		}
	}
	
}
