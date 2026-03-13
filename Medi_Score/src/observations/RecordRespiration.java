package observations;

import java.util.Scanner;

public class RecordRespiration {

    // Method to determine the patient's repiration rate

    public static int recordRespiration(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String respirationString;
        int respiration = 0;

        while (!valid) {
            System.out.println("\n" +
                    "Enter patient's respiration rate (per minute): ");
            respirationString = scanner.nextLine();
            if (respirationString.matches("[\\d]*")) {
                respiration = Integer.parseInt(respirationString);
                if (respiration < 0 || respiration > 100){
                    System.out.println("Enter whole numbers only, between 0 & 100.");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("Enter whole numbers only, between 0 & 100.");
                scanner.reset();
            }
        }
        return respiration;
    }
}
