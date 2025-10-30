import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherGUI {
    private JFrame frame;
    private JTextField locationField;
    private JLabel currentWeatherLabel;
    private JLabel forecastLabel;

    public void createGUI() {
        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        locationField = new JTextField(20);
        JButton getWeatherButton = new JButton("Get Weather");
        getWeatherButton.addActionListener(new GetWeatherActionListener());

        currentWeatherLabel = new JLabel();
        forecastLabel = new JLabel();

        frame.add(locationField, BorderLayout.NORTH);
        frame.add(getWeatherButton, BorderLayout.CENTER);
        frame.add(currentWeatherLabel, BorderLayout.WEST);
        frame.add(forecastLabel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    private class GetWeatherActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String location = locationField.getText();
            WeatherService weatherService = new WeatherService();
            String weatherData = weatherService.getWeatherData(location);

            if (weatherData != null) {
                currentWeatherLabel.setText(weatherData);
            } else {
                currentWeatherLabel.setText("Failed to get weather data");
            }
        }
    }
}
