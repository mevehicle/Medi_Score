package helpers;

import java.util.Objects;

public class Validation {

    /*
       Method to check if user input exceeds maximum length of a text field
      or contains illegitimate characters.
    */
    public static boolean validateTextField(String text, int maxLength){
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


    // Method to check if user input is one of two characters or not

    public static boolean validateCharacter(String text, String firstCharacter, String secondCharacter){
        boolean valid;
        if (!Objects.equals(text, firstCharacter) && !Objects.equals(text, secondCharacter)) {
            System.out.println("Please enter '" + firstCharacter + "' or '" + secondCharacter + "'");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }


    /*
       Method to check whether an input String can be converted to an integer
      and to convert it if possible

        Source - https://stackoverflow.com/a/5585800
        Posted by Rob Hruska, modified by community. See post 'Timeline' for change history
        Retrieved 2026-03-12, License - CC BY-SA 4.0
    */
    public static int validateStringAsInt(String toCheck){
        int foo;
        try {
            foo = Integer.parseInt(toCheck);
        }
        catch (NumberFormatException e) {
            foo = 0;
        }
        return foo;
    }


    /* Method to check whether an input String can be converted to a double
   And convert it if possible

        Source - https://stackoverflow.com/a/5585800
        Posted by Rob Hruska, modified by community. See post 'Timeline' for change history
        Retrieved 2026-03-12, License - CC BY-SA 4.0
   */
    public static float validateStringAsFloat(String toCheck) {
        float foo;
        try {
            foo = Float.parseFloat(toCheck);
        } catch (NumberFormatException e) {
            foo = (float) 0.0;
        }
        return foo;
    }


    // Method to check user input is an integer between 2 amounts

    public static boolean validateNumericField(int toCheck, int min, int max){
        boolean valid;
        if (toCheck < min | toCheck > max){
            System.out.println("Please enter a number between " + (min) + " and " + (max) + " (inclusive).");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }


    // Method to check user input is a float between 2 amounts

    public static boolean validateFloat(float toCheck, float min, float max){
        boolean valid;
        if (toCheck < min | toCheck > max){
            System.out.println("Please enter a number between " + (min) + " and " + (max) + " (inclusive).");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }
}
