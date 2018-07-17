package Beans;

public class HistoryBean {
	private int id;
	private String IPAddress,weather_condition,place;
	private String currentDate;
	private float temperature;
	

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getWeather_condition() {
		return weather_condition;
	}
	public void setWeather_condition(String weather_condition) {
		this.weather_condition = weather_condition;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

}
