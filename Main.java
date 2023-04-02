// package avaj_launcher;

import java.io.*;

public class Main
{
    private static final String outputFile = "simulation.txt";

    public static void main( String[] args ) throws EmptyListException, WrongDataException, WrongTypeAircraftException, IOException {

        if (args.length != 1)
            throw new WrongNumberOfArgumentsException();
        else
        {
            WeatherTower weathertower = new WeatherTower();
            
            int count = readFile(args[0], weathertower);

            for (int i = 0; i < count; i++){
                weathertower.conditionsChanged();
            }

        }
    }

    public static int readFile(String str, WeatherTower weathertower) throws WrongDataException, IOException {
        
        try (BufferedReader br = new BufferedReader(new FileReader(str))) {
            String line = (br.readLine());

            int count = Integer.parseInt(line);
            if (count <= 0) {
                throw new WrongDataException(str);
            }
            while ((line = br.readLine()) != null) {
                String[] splittedString = line.split(" ");
                if (splittedString.length != 5){
                    throw new WrongDataException(str);
                }
                int longitude = Integer.parseInt(splittedString[2]);
                int latitude = Integer.parseInt(splittedString[3]);
                int height = Integer.parseInt(splittedString[4]);
                if (height < 0 || height > 100)
                    throw new WrongDataException(str);
                Coordinates coordinates = new Coordinates(longitude, latitude, height);
                Flyable tmp = AirCraftFactory.newAircraft(splittedString[0], splittedString[1], coordinates);
                tmp.registerTower(weathertower);
            }
            br.close();
            return count;
        } catch (WrongTypeAircraftException e) {
        }
            catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void printFile(String str) throws IOException {
        FileWriter fw = new FileWriter(outputFile,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str);
        bw.close();
    }

}
