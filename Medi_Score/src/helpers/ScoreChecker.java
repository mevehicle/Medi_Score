package helpers;

import java.util.Scanner;

public class ScoreChecker {
    public static void scoreChecker(int score){

        /*
           Method to print the patient's Medi Score for a specific
          measurement and inquire whether it has risen by more than
          2 points in the last 24 hours.
        */

        Scanner scanner = new Scanner(System.in);

        boolean valid = false; // Variable to validate keyboard input
        String raised = ""; // variable to chart whether score has raised steeply

        System.out.println("This accrues " + score + " Medi score points.\n");
        if (score > 2){
            while (!valid){
                System.out.println("Has this score increased by more than 2 points " +
                        "within the last 24 hour period? ('Y' or 'N')");
                raised = scanner.nextLine().toUpperCase();
                valid = Validation.validateCharacter(raised, "Y", "N");
            }
            switch (raised){
                case "Y":
                    System.out.println("""
                            
                            WARNING - this indicates an additional risk!
                            Please alert a doctor urgently.""");
                    break;
                case "N":
                    break;
            }
        }
    }
}
