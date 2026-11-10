package assignments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleBankingApplication extends Application {
    private double balance = 0.0;

    @Override
    public void start(Stage stage) {
        TextField initialBalance = new TextField();
        TextField amount = new TextField();
        initialBalance.setPromptText("Initial balance");
        amount.setPromptText("Amount for deposit/withdrawal");

        Button startAccount = new Button("Set Initial Balance");
        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withdraw");
        Button check = new Button("Check Balance");
        Label message = new Label("Set an initial balance to begin.");
        message.setWrapText(true);

        startAccount.setOnAction(e -> {
            try {
                double value = Double.parseDouble(initialBalance.getText().trim());
                if (value < 0) {
                    message.setText("Initial balance cannot be negative.");
                    return;
                }
                balance = value;
                message.setText(String.format("Account created. Balance: %.2f", balance));
            } catch (NumberFormatException ex) {
                message.setText("Enter a valid initial balance.");
            }
        });

        deposit.setOnAction(e -> {
            try {
                double value = readAmount(amount);
                if (value <= 0) {
                    message.setText("Deposit amount must be greater than zero.");
                    return;
                }
                balance += value;
                message.setText(String.format("Deposit successful. Balance: %.2f", balance));
            } catch (NumberFormatException ex) {
                message.setText("Enter a valid deposit amount.");
            }
        });

        withdraw.setOnAction(e -> {
            try {
                double value = readAmount(amount);
                if (value <= 0) {
                    message.setText("Withdrawal amount must be greater than zero.");
                } else if (value > balance) {
                    message.setText("Insufficient balance. Withdrawal not allowed.");
                } else {
                    balance -= value;
                    message.setText(String.format("Withdrawal successful. Balance: %.2f", balance));
                }
            } catch (NumberFormatException ex) {
                message.setText("Enter a valid withdrawal amount.");
            }
        });

        check.setOnAction(e ->
            message.setText(String.format("Current balance: %.2f", balance)));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10); grid.setVgap(12);
        grid.addRow(0, new Label("Initial balance:"), initialBalance, startAccount);
        grid.addRow(1, new Label("Transaction amount:"), amount);
        grid.add(deposit, 0, 2);
        grid.add(withdraw, 1, 2);
        grid.add(check, 0, 3);
        grid.add(message, 0, 4, 3, 1);

        stage.setTitle("Simple Banking Application");
        stage.setScene(new Scene(grid, 560, 260));
        stage.show();
    }

    private double readAmount(TextField field) {
        return Double.parseDouble(field.getText().trim());
    }

    public static void main(String[] args) { launch(args); }
}
