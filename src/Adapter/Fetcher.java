package Adapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import Beans.Weather;

public class Fetcher {
	
	private static String key = "554971867d3e414c990b2cc86348b041";
	
	 public static String IPString()
	 {
		 String systemipaddress = "";
		 
		 try
		 {
	            URL url_name = new URL("http://bot.whatismyipaddress.com");
	 
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url_name.openStream()));
	 
	            // reads system IPAddress
	            
	            systemipaddress = reader.readLine().trim();
	            
	     }
	     catch (Exception exception)
	     {
	            systemipaddress = "Cannot Execute Properly";
	     }
		 
		 return systemipaddress;
		 
	 }
	
	 public static String getUrlContents(String urlString)
	  {
		 
		StringBuilder content = new StringBuilder();

	    try
	    {
     
    	  URL url = new URL(urlString);
	     
	      URLConnection urlConnection = url.openConnection();
	      
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String line;

	      while ((line = bufferedReader.readLine()) != null)
	      {
	    	  content.append(line + "\n");
	      }
	      
	      bufferedReader.close();
	      	
	    }
	    catch(Exception exception)
	    {
	      exception.printStackTrace();
	    }
	    
	    return content.toString();
	    
	  }

	 public static Weather weatherProcessing(String city){
		 
		 	String urlString = "https://api.weatherbit.io/v2.0/current?city="+city+"&key="+key;
			String responseData = getUrlContents(urlString);
			
			if(responseData.length()>0)
			{
				
				JSONObject jObject = new JSONObject(responseData);
				JSONArray dataArray = jObject.getJSONArray("data");
				
				JSONObject dataObject = dataArray.getJSONObject(0);
				
				Weather weather = new Weather();
				
				weather.setSunrise_time(dataObject.getString("sunrise"));
				weather.setSunset_time(dataObject.getString("sunset"));
				
				if(dataObject.getString("city_name") == city)
				{
					weather.setCity_name(dataObject.getString("city_name"));
				}
				else
				{
					weather.setCity_name(GenerateCase(city));
				}
				
				weather.setCountry_code(dataObject.getString("country_code"));
				weather.setPressure(dataObject.getFloat("pres"));
				weather.setWind_speed(dataObject.getFloat("wind_spd"));
				weather.setWind_cdir(dataObject.getString("wind_cdir"));
				weather.setTemperature(dataObject.getFloat("temp"));
				weather.setApparent_temperature(dataObject.getFloat("app_temp"));
				weather.setCloud_coverage(dataObject.getFloat("clouds"));
				weather.setPart_of_day(dataObject.getString("pod"));
				weather.setPrecipitation(dataObject.get("precip").toString());
				weather.setUv_level(dataObject.getInt("uv"));
				
				
				return weather;
			}
			else
				return null;
		}
	 
	 
	 public static String getPicturePath(int weatherCode)
	 {
		 if(weatherCode==200||weatherCode==201||weatherCode==202||weatherCode==230||weatherCode==231)
			 return "/WeatherProject/css/thunder.png";
		 if(weatherCode==804||weatherCode==801||weatherCode==802||weatherCode==803)
			 return "/WeatherProject/css/sunwithclouds.png";
		 if(weatherCode==500||weatherCode==501||weatherCode==502||weatherCode==520||weatherCode==521||weatherCode==522)
			 return "/WeatherProject/css/rain.png";
		 if(weatherCode==800)
			 return "/WeatherProject/css/black_sun.jpg";
					 
		return "/WeatherProject/css/black_sun.jpg";
	 }
	
	 public static String GenerateCase(String anyStr)
	 {
		 String resultStr = String.valueOf(anyStr.charAt(0)).toUpperCase();
		 resultStr = resultStr + anyStr.substring(1, anyStr.length());
		 return resultStr;
	 }
	 
}
