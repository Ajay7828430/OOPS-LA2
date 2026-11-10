package assignments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentGradeCalculator extends Application {
    @Override
    public void start(Stage stage) {
        TextField name = new TextField();
        TextField[] marks = new TextField[5];

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(18));
        grid.setHgap(12); grid.setVgap(10);
        grid.addRow(0, new Label("Student name:"), name);

        for (int i = 0; i < 5; i++) {
            marks[i] = new TextField();
            marks[i].setPromptText("0 to 100");
            grid.addRow(i + 1, new Label("Subject " + (i + 1) + " marks:"), marks[i]);
        }

        Button calculate = new Button("Calculate Grade");
        Label output = new Label();
        output.setWrapText(true);
        grid.add(calculate, 1, 6);
        grid.add(output, 1, 7);

        calculate.setOnAction(e -> {
            if (name.getText().trim().isEmpty()) {
                output.setText("Please enter the student's name.");
                return;
            }
            int total = 0;
            try {
                for (TextField field : marks) {
                    int mark = Integer.parseInt(field.getText().trim());
                    if (mark < 0 || mark > 100) {
                        output.setText("Each mark must be between 0 and 100.");
                        return;
                    }
                    total += mark;
                }
            } catch (NumberFormatException ex) {
                output.setText("Enter valid whole-number marks for all five subjects.");
                return;
            }

            double percentage = total / 5.0;
            String grade;
            if (percentage >= 90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else grade = "F";

            output.setText("Student: " + name.getText().trim() +
                "\nTotal: " + total + " / 500" +
                "\nPercentage: " + String.format("%.2f", percentage) + "%" +
                "\nGrade: " + grade);
        });

        stage.setTitle("Student Grade Calculator");
        stage.setScene(new Scene(grid, 430, 440));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
