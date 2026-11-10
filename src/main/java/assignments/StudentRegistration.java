package assignments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentRegistration extends Application {
    @Override
    public void start(Stage stage) {
        TextField name = new TextField();
        TextField usn = new TextField();
        ComboBox<String> branch = new ComboBox<>();
        branch.getItems().addAll("ISE", "CSE", "ECE", "EEE", "Mechanical", "Civil");
        branch.setPromptText("Select branch");

        ComboBox<Integer> semester = new ComboBox<>();
        for (int i = 1; i <= 8; i++) semester.getItems().add(i);
        semester.setPromptText("Select semester");

        TextField email = new TextField();
        TextField phone = new TextField();

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(12, male, female);

        Button submit = new Button("Submit");
        Label output = new Label();
        output.setWrapText(true);

        submit.setOnAction(e -> {
            String studentName = name.getText().trim();
            String studentUsn = usn.getText().trim();
            String studentEmail = email.getText().trim();
            String studentPhone = phone.getText().trim();

            if (studentName.isEmpty() || studentUsn.isEmpty() ||
                branch.getValue() == null || semester.getValue() == null ||
                studentEmail.isEmpty() || studentPhone.isEmpty() ||
                genderGroup.getSelectedToggle() == null) {
                output.setText("Please fill in all fields.");
                return;
            }
            if (!studentEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                output.setText("Enter a valid email address.");
                return;
            }
            if (!studentPhone.matches("\\d{10}")) {
                output.setText("Phone number must contain exactly 10 digits.");
                return;
            }

            RadioButton selected = (RadioButton) genderGroup.getSelectedToggle();
            output.setText("Registration successful!\nName: " + studentName +
                "\nUSN: " + studentUsn + "\nBranch: " + branch.getValue() +
                "\nSemester: " + semester.getValue() + "\nGender: " + selected.getText() +
                "\nEmail: " + studentEmail + "\nPhone: " + studentPhone);
        });

        GridPane grid = new GridPane();
        grid.setHgap(12); grid.setVgap(12); grid.setPadding(new Insets(18));
        grid.addRow(0, new Label("Name:"), name);
        grid.addRow(1, new Label("USN:"), usn);
        grid.addRow(2, new Label("Branch:"), branch);
        grid.addRow(3, new Label("Semester:"), semester);
        grid.addRow(4, new Label("Gender:"), genderBox);
        grid.addRow(5, new Label("Email:"), email);
        grid.addRow(6, new Label("Phone number:"), phone);
        grid.add(submit, 1, 7);
        grid.add(output, 1, 8);

        stage.setTitle("Student Registration Form");
        stage.setScene(new Scene(grid, 520, 480));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
