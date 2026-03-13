package observations;

import helpers.RoundFloat;
import java.util.Scanner;

public class RecordCBG {

    // Method to determine the patient's capillary blood glucose level [CBG]:

    public static float recordCBG(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String bloodGlucoseString;
        float bloodGlucose = (float) 0.0;

        while (!valid) {
            System.out.println("\nEnter patient's Capillary Blood Glucose [CBG]: ");
            bloodGlucoseString = scanner.nextLine();
            if (bloodGlucoseString.matches("[0-9]*([.]{1}[0-9]+){0,1}")) {
                bloodGlucose = Float.parseFloat(bloodGlucoseString);
                if (bloodGlucose < 0 || bloodGlucose > 100){
                    System.out.println("Enter numbers and decimal points only, between 0 & 100.");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("Enter numbers and decimal points only, between 0 & 100.");
            }
        }
        // Round bloodGlucose to 1 decimal place:
        bloodGlucose = RoundFloat.round(bloodGlucose, 1);

        return bloodGlucose;
    }
}

