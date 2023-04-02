// package avaj_launcher;

public class WeatherProvider {
    // private static volatile WeatherProvider weatherProvider;
    private static final String[] weather  = {"RAIN", "FOG", "SUN", "SNOW"};

    // private WeatherProvider(){}
    // public static WeatherProvider getProvider(){
    //     if (weatherProvider == null)
    //         synchronized (WeatherProvider.class) {
    //             if (weatherProvider == null) {
    //                 weatherProvider = new WeatherProvider();
    //             }
    //         }
    //     return weatherProvider;
    // }

    public static String getCurrentWeather(Coordinates coordinates){
        return weather[(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4];
    }
}
