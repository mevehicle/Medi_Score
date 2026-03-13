package helpers;

import java.util.Objects;

public class Validation {

    /*
       Method to check if user input exceeds maximum length of a text field
      or contains illegitimate characters.
    */

    public static boolean validateTextField(String text, int maxLength) {
        boolean valid;
        if (text.length() > maxLength) {
            System.out.println("Your response cannot be over " + maxLength + " characters long.");
            valid = false;
        } else if (!text.matches("^[a-zA-Z'-]*$")) {
            System.out.println("Only letters of the alphabet, - and ' are allowed.");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }


    // Method to check if user input is one of two specific characters or not

    public static boolean validateCharacter(String text, String firstCharacter, String secondCharacter) {
        boolean valid;
        if (!Objects.equals(text, firstCharacter) && !Objects.equals(text, secondCharacter)) {
            System.out.println("Please enter '" + firstCharacter + "' or '" + secondCharacter + "'");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

}
