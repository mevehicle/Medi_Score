package observations;

import helpers.RoundFloat;
import helpers.Validation;
import java.util.Scanner;

public class RecordTemperature {

    // Method to determine the patient's temperature

    public static float recordTemperature(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String temperatureString = "";
        float  temperature = 0;

        while (!valid) {
            System.out.println("\nEnter patient's temperature: ");
            temperatureString = scanner.nextLine();
            temperature = Validation.validateStringAsFloat(temperatureString);
            valid = Validation.validateFloat(temperature,
                    (float) 0.0, (float) 100.0);
        }
        // Round temperature to 1 decimal place:
        temperature = RoundFloat.round(temperature, 1);

        return temperature;
    }
}
