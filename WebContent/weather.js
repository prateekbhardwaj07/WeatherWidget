/**
 * 
 */

$(document).ready(function(){
  $.post('http://localhost:8080/WeatherProject/LocationServlet',{
	  DetectLocation:"Auto-Detect"
  },function(response,status) 
  {  
	  document.getElementById('responseData').innerHTML = response;
	
  });
});
    