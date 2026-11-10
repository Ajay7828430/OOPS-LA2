package assignments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TemperatureConverter extends Application {
    @Override
    public void start(Stage stage) {
        TextField input = new TextField();
        input.setPromptText("Enter temperature");
        Label result = new Label("Converted temperature appears here");

        Button toFahrenheit = new Button("Celsius to Fahrenheit");
        Button toCelsius = new Button("Fahrenheit to Celsius");

        toFahrenheit.setOnAction(e -> convert(input, result, true));
        toCelsius.setOnAction(e -> convert(input, result, false));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10); grid.setVgap(14);
        grid.addRow(0, new Label("Temperature:"), input);
        grid.add(toFahrenheit, 0, 1);
        grid.add(toCelsius, 1, 1);
        grid.add(result, 0, 2, 2, 1);

        stage.setTitle("Temperature Converter");
        stage.setScene(new Scene(grid, 480, 200));
        stage.show();
    }

    private void convert(TextField input, Label result, boolean celsiusToFahrenheit) {
        try {
            double value = Double.parseDouble(input.getText().trim());
            if (celsiusToFahrenheit) {
                double converted = (value * 9 / 5) + 32;
                result.setText(String.format("%.2f °C = %.2f °F", value, converted));
            } else {
                double converted = (value - 32) * 5 / 9;
                result.setText(String.format("%.2f °F = %.2f °C", value, converted));
            }
        } catch (NumberFormatException ex) {
            result.setText("Invalid input. Please enter a numeric temperature.");
        }
    }

    public static void main(String[] args) { launch(args); }
}
