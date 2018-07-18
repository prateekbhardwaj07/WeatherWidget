<%@page import="java.text.*"%>
<%@ page language="java" import="Beans.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/WeatherWidget/css/pageStyles.css" type="text/css"/>
</head>
<body>
<div class="bigCard" id="card1">
<div class="imageDiv">
<img src="<%
if(request.getAttribute("Weather")!=null)
{
	Weather weather = (Weather)request.getAttribute("Weather");
	String pod = weather.getPart_of_day();
	String precip = weather.getPrecipitation();
	float clouds = weather.getCloud_coverage();
	if(pod.equals("d")&&(clouds<10.0))
	{
		out.print("/WeatherWidget/css/icons/sun.png");
	}
	else if(pod.equals("d")&&(clouds<60.0))
	{
		out.print("/WeatherWidget/css/icons/cloudandsun.png");
	}
	else
	{
		out.print("/WeatherWidget/css/icons/rain.png");
	}
}
 %>" style="margin:5%;float:left;"/>
 <h4 style="font-family:verdana;color:white;margin-left:2%;" >
 <% if(request.getAttribute("Weather")!=null)
		{
			Weather weather = (Weather)request.getAttribute("Weather");
			String city = weather.getCity_name();
			String country = weather.getCountry_code();
			out.print("Location :"+city);
			if(country.length()>0)
			{
				out.print(" , "+country);
			}
		}
%>
</h4>
 <h4 style="color:white;font-family:verdana;">
 <%
 if(request.getAttribute("Weather")!=null)
 {
 	Weather weather = (Weather)request.getAttribute("Weather");
 	String pod = weather.getPart_of_day();
 	float clouds = weather.getCloud_coverage();
 	String precip = weather.getPrecipitation();
 	float wind_speed = weather.getWind_speed();
	String wind_direction = weather.getWind_cdir();
 	if(!precip.equals("null"))
 	{
 		if(pod.equals("d")&&(clouds<10.0)&&(Float.parseFloat(precip)==0.0))
 	 	{
 	 		out.print("Sunny");
 	 	}
 		else if(pod.equals("d")&&(clouds<60.0)&&(Float.parseFloat(precip)==0.0))
 	 	{
 	 		out.print("Sun with Clouds");
 	 	}
 		else if(pod.equals("n")&&(clouds<10.0)&&(Float.parseFloat(precip)==0.0))
 	 	{
 	 		out.print("Clear Night");
 	 	}
 		else if(pod.equals("n")&&(clouds<60.0)&&(Float.parseFloat(precip)==0.0))
 	 	{
 	 		out.print("Night Cloud Cover");
 	 	}
 		else if(clouds>=60.0&&(Float.parseFloat(precip)==0.0))
 	 	{
 	 		out.print("Overcast Clouds");
 	 	}
 		else if((Float.parseFloat(precip)>0.0)&&(Float.parseFloat(precip)<5.0))
 		{
 			out.print(" Light Shower");
 		}
 		else if((Float.parseFloat(precip)>=5.0)&&(Float.parseFloat(precip)<10.0))
 		{
 			out.print(" Medium Rain");
 		}
 		else if((Float.parseFloat(precip)>=10.0))
 		{
 			out.print(" Heavy Rainfall");
 		}
 		else
 		{
 			
 		}
 		out.print(",wind speed "+wind_speed +"m/s in "+wind_direction+",<br>precip:"+precip+" mm");
 	}
 	else
 	{
 		if(pod.equals("d")&&(clouds<10.0))
 	 	{
 	 		out.print("Sunny");
 	 	}
 		else if(pod.equals("d")&&(clouds<60.0))
 	 	{
 	 		out.print("Sun with Clouds");
 	 	}
 		else if(pod.equals("n")&&(clouds<10.0))
 	 	{
 	 		out.print("Clear Night");
 	 	}
 		else if(pod.equals("n")&&(clouds<60.0))
 	 	{
 	 		out.print("Night Cloud Cover");
 	 	}
 		else if(clouds>=60.0)
 	 	{
 	 		out.print("Overcast Clouds");
 	 	}
 		else
 		{
 			
 		}
 		out.print(",wind speed "+wind_speed +"m/s in "+wind_direction);	
 	}
	 
 }
 %>
 </h4>
</div>
<div name="weatherInfo" class="infoDiv"> 
<h4>
<%
if(request.getAttribute("Weather")!=null)
		{
			Weather weather= (Weather)request.getAttribute("Weather");
			String sunrise = weather.getSunrise_time();
			String sunset = weather.getSunset_time();
			float temperature = weather.getTemperature();
			out.print("<br>Real Temperature "+temperature+" °C");
			float appr_temp = weather.getApparent_temperature();
			out.print("<br><br>Feels Like "+appr_temp+" °C");
			float clouds = weather.getCloud_coverage();
			out.print("<br><br>Cloud Cover: "+clouds+" Percent");
		}
else if(request.getAttribute("ErrorMsg")!=null)
{
	out.print(request.getAttribute("ErrorMsg").toString());
}
else
{
	out.print("No Weather Information Found");
}
%>
</h4>
</div>
</div>
</div>
</body>
</html>