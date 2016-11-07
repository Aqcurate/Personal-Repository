package us.to.sstctf;

import java.util.HashMap;
import java.util.Map;

public class StringTester {
	public static void main(String[] args) {
		String[] description = {
				"tornado",
				"tropical storm",
				"hurricane",
				"severe thunderstorms",
				"thunderstorms",
				"mixed rain and snow",
				"mixed rain and sleet",
				"mixed snow and sleet",
				"freezing drizzle",
				"drizzle",
				"freezing rain",
				"showers",
				"showers",
				"snow flurries",
				"light snow showers",
				"blowing snow",
				"snow",
				"hail",
				"sleet",
				"dust",
				"foggy",
				"haze",
				"smoky",
				"blustery",
				"windy",
				"cold",
				"cloudy",
				"mostly cloudy (night)",
				"mostly cloudy (day)",
				"partly cloudy (night)",
				"partly cloudy (day)",
				"clear (night)",
				"sunny",
				"fair (night)",
				"fair (day)",
				"mixed rain and hail",
				"hot",
				"isolated thunderstorms",
				"scattered thunderstorms",
				"scattered thunderstorms",
				"scattered showers",
				"heavy snow",
				"scattered snow showers",
				"heavy snow",
				"partly cloudy",
				"thundershowers",
				"snow showers",
				"isolated thundershowers",
		};
		
		int temperature;
		int windchill;
		int humidity;
		
		for (windchill = 39; windchill < 41; windchill++) {
			for (humidity = 79; humidity < 81; humidity++) {
				for (String s : description) {
					for (temperature = 39; temperature < 41; temperature++) {
						System.out.println("Temperature: " + temperature + " Windchill: " + windchill + " Humidity: " + humidity + " Description: " + s);
						System.out.println(WeatherConditionals.getHikingAdvice(temperature, windchill, humidity, s));
					}
					
					for (temperature = 89; temperature < 91; temperature++) {
						System.out.println("Temperature: " + temperature + " Windchill: " + windchill + " Humidity: " + humidity + " Description: " + s);
						System.out.println(WeatherConditionals.getHikingAdvice(temperature, windchill, humidity, s));
					}
				}
			}
		}
	}
}
