package observations;

import helpers.Validation;

import java.util.Scanner;

public class RecordFasting {
    public static boolean recordFasting(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        boolean fasting = false;
        String fastingString = "";

        while (!valid){
            System.out.println("Is the patient fasting? ('Y' or 'N')");
            fastingString = scanner.nextLine().toUpperCase();
            valid = Validation.validateCharacter(fastingString, "Y", "N");
        }
        switch (fastingString){
            case "Y":
                fasting = true;
                break;
            case "N":
                fasting = false;
                break;
        }
        return fasting;
    }
}
