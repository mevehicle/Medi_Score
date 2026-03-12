package observations;

import helpers.Validation;
import java.util.Scanner;

public class RecordSaturation {

    // Method to determine the patient's oxygen saturation

    public static int recordSaturation(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String saturationString = "";
        int saturation = 0;

        while (!valid) {
            System.out.println("\nEnter patient's oxygen saturation (SpO2): ");
            saturationString = scanner.nextLine();
            saturation = Validation.validateStringAsInt(saturationString);
            valid = Validation.validateNumericField(saturation, 0, 100);
        }

        return saturation;
    }
}
