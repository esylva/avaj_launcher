// package avaj_launcher;

public class WrongNumberOfArgumentsException extends RuntimeException{
    public WrongNumberOfArgumentsException(){
        super("\nUsage:\n" +"java <Simulator> <scenario.txt>\n");
    }
}
