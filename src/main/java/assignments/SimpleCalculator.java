package assignments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    @Override
    public void start(Stage stage) {
        TextField first = new TextField();
        TextField second = new TextField();
        first.setPromptText("First number");
        second.setPromptText("Second number");
        Label result = new Label("Result will appear here");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10); grid.setVgap(12);
        grid.addRow(0, new Label("First number:"), first);
        grid.addRow(1, new Label("Second number:"), second);

        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < operators.length; i++) {
            String operator = operators[i];
            Button button = new Button(operator);
            button.setMinWidth(55);
            button.setOnAction(e -> {
                try {
                    double a = Double.parseDouble(first.getText().trim());
                    double b = Double.parseDouble(second.getText().trim());
                    double answer;
                    switch (operator) {
                        case "+" -> answer = a + b;
                        case "-" -> answer = a - b;
                        case "*" -> answer = a * b;
                        case "/" -> {
                            if (b == 0) {
                                result.setText("Cannot divide by zero.");
                                return;
                            }
                            answer = a / b;
                        }
                        default -> throw new IllegalStateException("Unknown operator");
                    }
                    result.setText("Result: " + answer);
                } catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers in both fields.");
                }
            });
            grid.add(button, i, 2);
        }
        grid.add(result, 0, 3, 4, 1);

        stage.setTitle("Simple Calculator");
        stage.setScene(new Scene(grid, 420, 220));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
