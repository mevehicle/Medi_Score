package observations;

import enums.AirOrOxygen;
import helpers.Validation;
import java.util.Scanner;

public class RecordAirOrOxygen {

    // Method to determine whether the patient breathes air or oxygen:

    public static AirOrOxygen recordAirOrOxygen(){

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String breathingString = "";
        AirOrOxygen breathing = null;

        while (!valid) {
            System.out.println("\nTo indicate the patient's mode of breathing,");
            System.out.println("press 'A' for 'Air' or 'O' for 'Oxygen': ");
            breathingString = scanner.nextLine().toUpperCase();
            valid = Validation.validateCharacter(breathingString, "A", "O");
        }
        breathing = switch (breathingString) {
            case "A" -> AirOrOxygen.AIR;
            case "O" -> AirOrOxygen.OXYGEN;
            default -> breathing;
        };

        return breathing;
    }
}
