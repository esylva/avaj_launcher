// package avaj_launcher;

public abstract class AirCraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected AirCraft(long p_id, String p_name, Coordinates p_coordinates){
        this.name = p_name;
        this.coordinates = p_coordinates;
        id = p_id;
    }

   
}
