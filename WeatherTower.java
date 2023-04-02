// package avaj_launcher;

public class WeatherTower extends Tower{
    public String getWeather (Coordinates p_coordinates){
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }

    void changeWeather(){

    }
}
