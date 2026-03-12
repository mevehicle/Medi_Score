package observations;

import helpers.Validation;
import java.util.Scanner;

public class RecordRespiration {
    public static int recordRespiration(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String respirationString = "";
        int respiration = 0;

        while (!valid) {
            System.out.println("\nEnter patient's respiration rate (per minute): ");
            respirationString = scanner.nextLine();
            respiration = Validation.validateStringAsInt(respirationString);
            valid = Validation.validateNumericField(respiration, 0, 200);
        }

        return respiration;
    }
}
