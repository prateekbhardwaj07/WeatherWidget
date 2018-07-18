/**
 * 
 */

$(document).ready(function(){
  $.post('http://localhost:8080/WeatherWidget/LocationServlet',{
	  DetectLocation:"Auto-Detect"
  },function(response,status)
  {  
	  document.getElementById('responseData').innerHTML = response;
	  console.log("Success");
	
  });
});
    