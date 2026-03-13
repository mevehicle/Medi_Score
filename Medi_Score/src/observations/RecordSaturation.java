package observations;

import java.util.Scanner;

public class RecordSaturation {

    // Method to determine the patient's oxygen saturation

    public static int recordSaturation(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String saturationString;
        int saturation = 0;

        while (!valid) {
            System.out.println("\nEnter patient's oxygen saturation (SpO2): ");
            saturationString = scanner.nextLine();
            if (saturationString.matches("[\\d]*")) {
                saturation = Integer.parseInt(saturationString);
                if (saturation < 0 || saturation > 100){
                    System.out.println("Enter whole numbers only, between 0 & 100.");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("Enter whole numbers only, between 0 & 100.");
                scanner.reset();
            }
        }
        return saturation;
    }
}
