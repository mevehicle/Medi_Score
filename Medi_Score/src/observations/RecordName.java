package observations;

import helpers.Validation;
import java.util.Scanner;

public class RecordName {
     /*
        Method to determine a patient's name -
        Can be used for first and last names.
        Note patient's first and last names can be no longer than 20 characters each
     */
     public static String recordName(String position){

         Scanner scanner = new Scanner(System.in);

         boolean valid = false; // Variable to validate keyboard input
         String name = "";

         while (!valid) {
             System.out.println("\nPlease enter the patient's " + position + " name: ");
             name = scanner.nextLine();
             valid = Validation.validateTextField(name, 20);
         }

         return name;
     }
}
