package main;

import enums.AirOrOxygen;
import helpers.Validation;
import patient.Patient;
import observations.RecordResults;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean carryOn = true; // Variable to allow repetition of program
        String assessAnother = ""; // Variable to select whether to repeat program
        boolean valid = false; 
        Scanner scanner = new Scanner(System.in);
        
        while (carryOn == true) {
            Patient patient = RecordResults.recordResults();
            System.out.println(patient);

            while (!valid) {
                System.out.println("Would you like to assess another patient?");
                assessAnother = scanner.nextLine().toUpperCase();
                valid = Validation.validateCharacter(assessAnother, "Y", "N");
            }
            switch (assessAnother) {
                case "Y":
                    continue;
                case "N":
                    carryOn = false;
                    break;
                default:
                    carryOn = false;
                    break;
            }
        }
    }
}
