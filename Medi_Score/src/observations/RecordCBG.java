package observations;

import helpers.Validation;
import java.util.Scanner;

public class RecordCBG {
    public static float recordCBG(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String bloodGlucoseString = "";
        float bloodGlucose = 0;

        while (!valid) {
            System.out.println("\nEnter patient's Capillary Blood Glucose [CBG]: ");
            bloodGlucoseString = scanner.nextLine();
            bloodGlucose = Validation.validateStringAsFloat(bloodGlucoseString);
            valid = Validation.validateFloat(bloodGlucose, 0, 50);
        }

        return bloodGlucose;
    }
}

