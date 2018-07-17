package Adapter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import Beans.HistoryBean;
import Beans.HistoryDao;
import Beans.Weather;

public class Implement {

	public static void processAutoCity(HttpServletRequest request, HttpServletResponse response)throws ServletException 
	{
		
		String systemipaddress = Fetcher.IPString();
		
		try
		{
			
		LookupService currentLocation = new LookupService("C:/Users/prateek.bhardwaj/Downloads/GeoLiteCity/GeoLiteCity.dat",
				LookupService.GEOIP_MEMORY_CACHE );
		Location location = currentLocation.getLocation(systemipaddress);
		
		String city = location.city;
      
		processWeather(request,response,city);
		
		currentLocation.close();
		
		}
		
		catch (IOException ioException) 
		{
		    ioException.printStackTrace();
		}
	}

	
	public static void processWeather(HttpServletRequest request, HttpServletResponse response, String city)throws ServletException, IOException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    
		Weather weather = Fetcher.weatherProcessing(city);
		if(weather==null)
		{
		
			request.setAttribute("ErrorMsg", "Sorry, We Can Not Find The Entered City");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Weather.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
		
			request.setAttribute("currentInput",city);
			request.setAttribute("Weather", weather);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/Weather.jsp");
			dispatcher.forward(request, response);
		
		}
	}



}
