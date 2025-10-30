import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherService {
    private static final String API_KEY = "YOUR_OPENWEATHERMAP_API_KEY";
    private static final String API_URL = "http:                                           

    public String getWeatherData(String location) {
        try {
            URL url = new URL(API_URL + "//api.openweathermap.org/data/2.5/weather";

    public String getWeatherData(String location) {
        try {
            URL url = new URL(API_URL + "?q=" + location + "&appid=" + API_KEY + "&units=metric");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonObject = new JSONObject(response.toString());
                String weather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
                double temperature = jsonObject.getJSONObject("main").getDouble("temp");

                return "Current Weather: " + weather + ", Temperature: " + temperature + "°C";
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
