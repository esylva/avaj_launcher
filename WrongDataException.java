// package avaj_launcher;

public class WrongDataException extends Exception {
    public WrongDataException(String str){
        super("\nWrong data in file " + str);
    }
}
