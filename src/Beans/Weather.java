package Beans;

public class Weather {
	private String sunrise_time,sunset_time,city_name,country_code,wind_cdir,part_of_day,precipitation;
	private float pressure,wind_speed,temperature,apparent_temperature,cloud_coverage;
	private int result_count,uv_level;
	public String getSunrise_time() {
		return sunrise_time;
	}
	public void setSunrise_time(String sunrise_time) {
		this.sunrise_time = sunrise_time;
	}
	public String getSunset_time() {
		return sunset_time;
	}
	public void setSunset_time(String sunset_time) {
		this.sunset_time = sunset_time;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getWind_cdir() {
		return wind_cdir;
	}
	public void setWind_cdir(String wind_cdir) {
		this.wind_cdir = wind_cdir;
	}
	public String getPart_of_day() {
		return part_of_day;
	}
	public void setPart_of_day(String part_of_day) {
		this.part_of_day = part_of_day;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(float wind_speed) {
		this.wind_speed = wind_speed;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getApparent_temperature() {
		return apparent_temperature;
	}
	public void setApparent_temperature(float apparent_temperature) {
		this.apparent_temperature = apparent_temperature;
	}
	public float getCloud_coverage() {
		return cloud_coverage;
	}
	public void setCloud_coverage(float cloud_coverage) {
		this.cloud_coverage = cloud_coverage;
	}
	public String getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}
	public int getResult_count() {
		return result_count;
	}
	public void setResult_count(int result_count) {
		this.result_count = result_count;
	}
	public int getUv_level() {
		return uv_level;
	}
	public void setUv_level(int uv_level) {
		this.uv_level = uv_level;
	} 

}
