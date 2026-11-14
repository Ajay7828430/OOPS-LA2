# JavaFX LA2 Assignments

Five separate JavaFX applications, using Java 17 and Maven.

## Requirements
- JDK 17
- VS Code
- VS Code Extension Pack for Java
- Apache Maven installed and available as `mvn` in the terminal

## Open and run
1. In VS Code, open the folder that contains `pom.xml`.
2. To select an app in VS Code, choose Terminal > Run Task and select one of the five `Run ...` tasks.
3. Or open Terminal > New Terminal. Confirm it is in the project folder by running:

   `Test-Path .\pom.xml`

   It should print `True`. If it prints `False`, change to the folder that contains `pom.xml`. The `cd` command only changes folders; it does not start the application.
4. Run one of these commands in that terminal. A JavaFX window should open, and the command will keep running until you close the window:

   Student Registration:
   `mvn javafx:run "-DmainClass=assignments.StudentRegistration"`

   Simple Calculator:
   `mvn javafx:run "-DmainClass=assignments.SimpleCalculator"`

   Temperature Converter:
   `mvn javafx:run "-DmainClass=assignments.TemperatureConverter"`

   Student Grade Calculator:
   `mvn javafx:run "-DmainClass=assignments.StudentGradeCalculator"`

   Simple Banking Application:
   `mvn javafx:run "-DmainClass=assignments.SimpleBankingApplication"`

To build all five apps without opening a window, run `mvn verify`. Maven does not have a `check` lifecycle phase; use `verify` for a full build.

The project Maven configuration uses the repository in your Windows user profile. Maven downloads JavaFX dependencies the first time, so Internet access is needed for the initial download.

## Check installations
`java -version`
`mvn -version`

If `mvn` is not recognized, install Apache Maven and add its `bin` folder to PATH, then restart VS Code.

## Grade rule used
The assignment PDF does not specify grade boundaries. This sample uses:
A+ >= 90, A >= 80, B >= 70, C >= 60, D >= 50, F < 50.
Confirm these boundaries with your lecturer if a specific scheme is expected.
