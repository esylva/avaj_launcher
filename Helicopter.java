// package avaj_launcher;

import java.io.IOException;

public class Helicopter extends AirCraft implements Flyable{
    private WeatherTower weatherTower;


    Helicopter(long p_id, String name, Coordinates coordinates){
        super(p_id, name, coordinates);
    }

    public void updateConditions() throws IOException {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather){
            case("SUN"):
               Main.printFile("Helicopter " + this.name + "(" + this.id + ")" + ": SUN\n");
                if ((coordinates.getHeight() + 2) > 100){
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), 100);
                }
                else{
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                }
                break;
            case("RAIN"):
               Main.printFile("Helicopter " + this.name + "(" + this.id + ")" + ": RAIN\n");
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case("FOG"):
               Main.printFile("Helicopter " + this.name + "(" + this.id + ")" + ": FOG\n");
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case("SNOW"):
               Main.printFile("Helicopter " + this.name + "(" + this.id + ")" + ": SNOW\n");
                if ((coordinates.getHeight() - 12) <= 0){
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
                   Main.printFile("We are landing!\n");
                    weatherTower.unregister(this);
                }
                else{
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                }
                break;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
       Main.printFile("Tower: " + this.name + " registered\n");
    }
}
