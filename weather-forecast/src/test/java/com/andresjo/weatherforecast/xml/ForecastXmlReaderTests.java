package com.andresjo.weatherforecast.xml;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import javax.xml.stream.XMLStreamException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.andresjo.weatherforecast.models.Forecast;

public class ForecastXmlReaderTests {	
	private static final double DELTA = 1e-15;
	static Forecast forecast;
	
	
	@BeforeClass
	public static void buildLocation(){
		try {
			ForecastXmlReader xmlReader = new ForecastXmlReader("src/test/resources/forecasts/varsel.xml", "UTF8");
			forecast = xmlReader.parseForecast();
			
		} catch (FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseForecastXML_GetCorrectLocationName() {
		String expected = "Blindern";
		String actual = forecast.getLocation().getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectLocationType() {
		String expected = "Byområde";
		String actual = forecast.getLocation().getType();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectLocationCountry() {
		String expected = "Norge";
		String actual = forecast.getLocation().getCountry();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectLocationTimeZoneDisplayName() {
		String expected = "Central European Time";
		String actual = forecast.getLocation().getTimezone().getDisplayName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectLocationAltitude() {
		double expected = 90.0;
		double actual = forecast.getLocation().getAltitude();
		
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void parseAndGetCorrectLocationLatitude() {
		double expected = 59.9406284402542;
		double actual = forecast.getLocation().getLatitude();
		
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void parseAndGetCorrectLocationLongitude() {
		double expected = 10.7230684724138;
		double actual = forecast.getLocation().getLongitude();
		
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void parseAndGetCorrectFromTime() {
		String expected = "2015-09-10T12:00";
		String actual = forecast.getFromTime().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectToTime() {
		String expected = "2015-09-10T18:00";
		String actual = forecast.getToTime().toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectSymbol() {
		String expected = "3";
		String actual = forecast.getSymbol();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectSymbolName() {
		String expected = "Delvis skyet";
		String actual = forecast.getSymbolName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectPrecipitation() {
		Double expected = 1.1;
		Double actual = forecast.getPrecipitation();
		
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void parseAndGetCorrectWindDirectionCode() {
		String expected = "NE";
		String actual = forecast.getWindDirectionCode();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectWindDirectionName() {
		String expected = "Nordøst";
		String actual = forecast.getWindDirectionName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectWindSpeed() {
		Double expected = 2.3;
		Double actual = forecast.getWindSpeed();
		
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void parseAndGetCorrectWindSpeedName() {
		String expected = "Svak vind";
		String actual = forecast.getWindSpeedName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectTemperatureUnit() {
		String expected = "celsius";
		String actual = forecast.getTemperatureUnit();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void parseAndGetCorrectTemperature() {
		Double expected = 20.0;
		Double actual = forecast.getTemperature();
		
		assertEquals(expected, actual, DELTA);
	}
	
	
}
