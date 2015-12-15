package com.andresjo.weatherforecast.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.TimeZone;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.andresjo.weatherforecast.models.Forecast;
import com.andresjo.weatherforecast.models.Forecast.ForecastBuilder;
import com.andresjo.weatherforecast.models.Location.LocationBuilder;


public class ForecastXmlReader {
	
	private XMLStreamReader streamReader;
	
	public ForecastXmlReader(String filePath, String encoding) throws FileNotFoundException, XMLStreamException{
		XMLInputFactory factory = XMLInputFactory.newInstance();
		this.streamReader = factory.createXMLStreamReader(new FileInputStream(filePath), encoding);
	}
	
	public ForecastXmlReader(XMLStreamReader streamReader){
		this.streamReader = streamReader;
	}
	
	public Forecast parseForecast() throws XMLStreamException {
		LocationBuilder locationBuilder = new LocationBuilder();
		ForecastBuilder forecastBuilder = new ForecastBuilder();
		
		
		while(streamReader.hasNext()){
			streamReader.next();
			
			if (eventIsStartElement()){
				if (localNameEquals("location") && streamReader.getAttributeCount() == 0){
					parseAndGetLocation(streamReader, locationBuilder);
				}
				
				else if(localNameEquals("tabular")){
					parseAndGetForecastDetails(streamReader, forecastBuilder);
				}
			}
			
		}
		
		return forecastBuilder.location(locationBuilder.build()).build();
	}
	

	private void parseAndGetForecastDetails(XMLStreamReader streamReader, ForecastBuilder forecastBuilder) throws XMLStreamException {
		
		while(streamReader.hasNext()){
			streamReader.next();
			
			if (eventIsStartElement()) {
				if (localNameEquals("time") && periodIsTwo(streamReader)){
					break;
				}
			}
			
		}
		
		forecastBuilder.fromTime(LocalDateTime.parse(streamReader.getAttributeValue(0)));
		forecastBuilder.toTime(LocalDateTime.parse(streamReader.getAttributeValue(1)));
		
		while (streamReader.hasNext()){
			streamReader.next();
			
			if(eventIsEndElement() && localNameEquals("time")){
				return;	       
	        }
			
			if (eventIsStartElement()){
				if (localNameEquals("symbol")){
					forecastBuilder.symbol(streamReader.getAttributeValue(0));
					forecastBuilder.symbolName(streamReader.getAttributeValue(2));
				}else if(localNameEquals("precipitation")) {
					forecastBuilder.precipitation(Double.parseDouble(streamReader.getAttributeValue(0)));
				}else if(localNameEquals("windDirection")) {
					forecastBuilder.windDirectionCode(streamReader.getAttributeValue(1));
					forecastBuilder.windDirectionName(streamReader.getAttributeValue(2));
				}else if(localNameEquals("windDirection")) {
					forecastBuilder.windDirectionCode(streamReader.getAttributeValue(1));
					forecastBuilder.windDirectionName(streamReader.getAttributeValue(2));
				}else if(localNameEquals("windSpeed")) {
					forecastBuilder.windSpeed(Double.parseDouble(streamReader.getAttributeValue(0)));
					forecastBuilder.windSpeedName(streamReader.getAttributeValue(1));
				}else if(localNameEquals("temperature")) {
					forecastBuilder.temperatureUnit(streamReader.getAttributeValue(0));
					forecastBuilder.temperature(Double.parseDouble(streamReader.getAttributeValue(1)));
				}
			}
			
		}
		
	}

	private void parseAndGetLocation(XMLStreamReader streamReader, LocationBuilder locationBuilder) throws XMLStreamException {
		while(streamReader.hasNext()){
			streamReader.next();
			
			if(eventIsEndElement()){
	            if(localNameEquals("location")){
	              return;
	            }
	        }
			
			if (eventIsStartElement()){
				if(localNameEquals("name")){
					streamReader.next();
					locationBuilder.name(streamReader.getText());
				}else if (localNameEquals("type")){
					streamReader.next();
					locationBuilder.type(streamReader.getText());
				}else if(localNameEquals("country")){
					streamReader.next();
					locationBuilder.country(streamReader.getText());
				}else if(localNameEquals("timezone")){
					locationBuilder.timezone(TimeZone.getTimeZone(streamReader.getAttributeValue(0)));
				}else if(localNameEquals("location")){
					locationBuilder.altitude(Double.parseDouble(streamReader.getAttributeValue(0)));
					locationBuilder.latitude(Double.parseDouble(streamReader.getAttributeValue(1)));
					locationBuilder.longitude(Double.parseDouble(streamReader.getAttributeValue(2)));
				}
			}
			
		}
	}
	
	private boolean periodIsTwo(XMLStreamReader streamReader){
		if (streamReader.getAttributeCount() == 3){
			return streamReader.getAttributeValue(2).equals("2");
		}
		return false;
	}
	
	private boolean eventIsStartElement(){
		return streamReader.getEventType() == XMLStreamReader.START_ELEMENT;
	}

	private boolean eventIsEndElement(){
		return streamReader.getEventType() == XMLStreamReader.END_ELEMENT;
	}
	
	private boolean localNameEquals(String localName){
		return streamReader.getLocalName().equals(localName);
	}
}
