// package avaj_launcher;

import java.io.IOException;

public class Baloon extends AirCraft implements Flyable{
    private WeatherTower weatherTower;


    Baloon(long p_id, String name, Coordinates coordinates){
        super(p_id,  name, coordinates);
    }

    public void updateConditions() throws IOException {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case ("SUN"):
                Main.printFile("Baloon " + this.name + "(" + this.id + ")" + ":  SUN\n");
                if ((coordinates.getHeight() + 4) > 100) {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
                } else {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() + 4);
                }
                break;
            case ("RAIN"):
                Main.printFile("Baloon " + this.name + "(" + this.id + ")" + ":  RAIN\n");
                if ((coordinates.getHeight() - 5) <= 0) {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
                    Main.printFile("Egypt's Force! We are landing!\n");
                    weatherTower.unregister(this);
                } else {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                }
                break;
            case ("FOG"):
                Main.printFile("Baloon " + this.name + "(" + this.id + ")" + ":  FOG\n");
                if ((coordinates.getHeight() - 3) <= 0) {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
                    Main.printFile("Egypt's Force! We are landing!\n");
                    weatherTower.unregister(this);
                } else {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                }
                break;
            case ("SNOW"):
                Main.printFile("Baloon " + this.name + "(" + this.id + ")" + ":  SNOW\n");
                if ((coordinates.getHeight() - 15) <= 0) {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
                    Main.printFile("Egypt's Force! We are landing!\n");
                    weatherTower.unregister(this);
                } else {
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
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
