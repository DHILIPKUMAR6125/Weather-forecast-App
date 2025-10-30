import javax.swing.*;

public class WeatherApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WeatherGUI gui = new WeatherGUI();
                gui.createGUI();
            }
        });
    }
}
