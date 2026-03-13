package observations;

import helpers.RoundFloat;
import java.util.Scanner;

public class RecordTemperature {

    // Method to determine the patient's temperature

    public static float recordTemperature(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String temperatureString;
        float temperature = (float) 0.0;

        while (!valid) {
            System.out.println("\nEnter patient's temperature in celsius: ");
            temperatureString = scanner.nextLine();
            if (temperatureString.matches("[0-9]*([.]{1}[0-9]+){0,1}")) {
                temperature = Float.parseFloat(temperatureString);
                if (temperature < 0 || temperature > 100){
                    System.out.println("Enter numbers and decimal points only, between 0 & 100.");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("Enter numbers and decimal points only, between 0 & 100.");
            }
        }
        // Round temperature to 1 decimal place:
        temperature = RoundFloat.round(temperature, 1);

        return temperature;
    }
}
