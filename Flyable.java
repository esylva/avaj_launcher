// package avaj_launcher;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Flyable {
    public void updateConditions() throws FileNotFoundException, IOException;
    public void registerTower(WeatherTower weatherTower) throws FileNotFoundException, IOException;

}
