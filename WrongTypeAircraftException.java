// package avaj_launcher;

public class WrongTypeAircraftException extends Exception {
    public WrongTypeAircraftException(String type){
            System.out.println("\n" + type + " type is undefined");
    }
}
