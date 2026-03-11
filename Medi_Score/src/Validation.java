public class Validation {

    /*
        Method to check if user input exceeds maximum length of a text field
       or contains illegitimate characters.
     */
    public static boolean validateTextField(String text, byte maxLength){
        boolean valid;
        if (text.length() > maxLength) {
            System.out.println("Your response cannot be over " + maxLength + " characters long.");
            valid = false;
        } else if (!text.matches("/^[a-zA-Z'-]$/")) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    // Method to check if user input is one of two characters or not
    public static boolean validateChar(String text, String firstChar, String secondChar){
        boolean valid;
        if (text != firstChar && text != secondChar) {
            System.out.println("Please enter '" + firstChar + "' or '" + secondChar + "'");
            valid = false;
        } else {
            valid = true;
        }
        return valid;
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
