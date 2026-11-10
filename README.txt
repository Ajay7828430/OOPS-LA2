# JavaFX LA2 Assignments

Five separate JavaFX applications, using Java 17 and Maven.

## Requirements
- JDK 17
- VS Code
- VS Code Extension Pack for Java
- Apache Maven installed and available as `mvn` in the terminal

## Open and run
1. Extract this ZIP.
2. In VS Code choose File > Open Folder and open `JavaFX_LA2_Assignments`.
3. Open Terminal > New Terminal.
4. Run one of these commands from the folder containing `pom.xml`:

   Student Registration:
   `mvn javafx:run -DmainClass=assignments.StudentRegistration`

   Simple Calculator:
   `mvn javafx:run -DmainClass=assignments.SimpleCalculator`

   Temperature Converter:
   `mvn javafx:run -DmainClass=assignments.TemperatureConverter`

   Student Grade Calculator:
   `mvn javafx:run -DmainClass=assignments.StudentGradeCalculator`

   Simple Banking Application:
   `mvn javafx:run -DmainClass=assignments.SimpleBankingApplication`

Maven downloads the JavaFX dependencies the first time. Internet access is needed for the initial download.

## Check installations
`java -version`
`mvn -version`

If `mvn` is not recognized, install Apache Maven and add its `bin` folder to PATH, then restart VS Code.

## Grade rule used
The assignment PDF does not specify grade boundaries. This sample uses:
A+ >= 90, A >= 80, B >= 70, C >= 60, D >= 50, F < 50.
Confirm these boundaries with your lecturer if a specific scheme is expected.
