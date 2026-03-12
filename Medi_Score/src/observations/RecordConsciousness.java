package observations;

import enums.LevelOfConsciousness;
import helpers.Validation;
import java.util.Scanner;

public class RecordConsciousness {

    // Method to determine the patient's level of consciousness

    public static LevelOfConsciousness recordConsciousness(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String ConsciousnessString = "";
        LevelOfConsciousness consciousness = null;

        while (!valid) {
            System.out.println("\nTo indicate the patient's level of consciousness,");
            System.out.println("press 'A' for 'Alert' or 'C' for 'CVPU': ");
            ConsciousnessString = scanner.nextLine().toUpperCase();
            valid = Validation.validateCharacter(ConsciousnessString, "A", "C");
        }
        consciousness = switch (ConsciousnessString) {
            case "A" -> LevelOfConsciousness.ALERT;
            case "C" -> LevelOfConsciousness.CVPU;
            default -> consciousness;
        };

        return consciousness;
    }

}
