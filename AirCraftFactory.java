// package avaj_launcher;

public class AirCraftFactory {

    private static long id = 0L;
    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws WrongTypeAircraftException {

        switch (p_type) {
            case ("Baloon"):
                return new Baloon(id++, p_name, p_coordinates);
            case ("Helicopter"):
                return new Helicopter(id++, p_name, p_coordinates);
            case ("JetPlane"):
                return new JetPlane(id++, p_name, p_coordinates);
            default:
                throw new WrongTypeAircraftException(p_type);
        }
    }
}
