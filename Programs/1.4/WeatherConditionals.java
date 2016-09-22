package us.to.sstctf;

public class WeatherConditionals {
	public static String getWeatherAdvice(int temperature, String description) {
		boolean windy = false;
		boolean snow = false;
		if (description.contains("windy")) {
			windy = true;
		} else if (description.contains("snow")) {
			snow = true;
		}
		
		if (windy) {
			return "Too windy or cold! Enjoy watching the weather through the window.";
		} else if (snow && (temperature > 100)) {
			return "I'm not sure that is correct.";
		} else {
			return "It's safe to go outside, " + temperature + " degrees and " + description + ".";
		}
	}
	
	public static String getHikingAdvice(int temperature, int windchill, int humidity, String description) {
		
		// List of dangerous weather
		String[] dangerousWeather = {"tornado", "storm", "hurricane", "hail", "thunder", "heavy"};
		boolean isDangerous = false;
		
		// List of rainy weather
		String[] rainWeather = {"rain", "showers"};
		boolean isRainy = false;
		
		// List of smokey weather
		String[] smokeyWeather = {"dust", "foggy", "smokey"};
		boolean isSmokey = false;

		// List of drizzle terms
		String drizzleWeather = "drizzle";
		boolean isDrizzle = false;
		
		
		// Checking for danger terms
		for (String s : dangerousWeather) {
			if (description.contains(s))
				isDangerous = true;
		}
		
		// Checking for rainy terms
		for (String s : rainWeather) {
			if (description.contains(s))
				isRainy = true;
		}
		
		// Checking for smokey terms
		for (String s : smokeyWeather) {
			if (description.contains(s))
				isSmokey = true;
		}
		
		// Checking for drizzle terms
		if (description.contains(drizzleWeather))
			isDrizzle = true;
		
		// Checking temperature and humidity
		if (temperature > 90) {
			// Checking for hot weather
			if (humidity > 80)
				// Checking for humid weather
				return "It's too hot and humid for a hike; wait for a cooler and less humid day.";
			else
				return "It's too hot for a hike; wait for a cooler day.";
		} else if (temperature < 40 || windchill < 40)
			// Checking for cold weather due to temperature or windchill
			return "It's too cold outside; wait for it to warm up.";
		
		// Checking for description conditions
		if (isDangerous) {
			return "Dangerous weather possible; best to stay sheltered.";
		} else if (isRainy) {
			return "Rain or showers forecast; not a good hiking day.";
		} else if (isSmokey) {
			return "Might be too smokey for a hike; best to check first.";
		} else if (isDrizzle) {
			return "There may be a drizzle; maybe take a rain coat.";
		} else {
			return "Weather is good. Looks like another great day for a hike!";
		}
	}
	
	public static boolean isString(String str) {
		if (str == null || str.length() >= 81) {
			return true;
		}
		return false;
	}
}
