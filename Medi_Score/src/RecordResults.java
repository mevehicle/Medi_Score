import java.util.Scanner;

public class RecordResults {
    public static Patient recordResults(){

        boolean valid = false; // Variable to validate keyboard input

        Scanner sc = new Scanner(System.in);  // sc allows entry from keyboard

        // Note patient's first and last names can be no longer than 30 characters each

        String newPatientFirstName = "";
        String newPatientLastName = "";
        String BreathingString = "";
        AirOrOxygen newPatientBreathing = null;
        String ConsciousnessString = "";
        LevelOfConsciousness newPatientConsciousness = null;
        String newPatientRespirationString = "";
        int newPatientRespiration = 0;
        String newPatientSaturationString = "";
        int newPatientSaturation = 0;
        String newPatientTemperatureString = "";
        float  newPatientTemperature = 0;
        int score = 0;

        while (!valid) {
            System.out.println("Please enter the patient's first name: ");
            newPatientFirstName = sc.nextLine();
            valid = Validation.validateTextField(newPatientFirstName, 20);
        }

        valid = false;  // re-initialise valid after each field has been checked
        while (!valid) {
            System.out.println("\nEnter the patient's last name: ");
            newPatientLastName = sc.nextLine();
            valid = Validation.validateTextField(newPatientLastName, 20);
        }

        valid = false;
        while (!valid) {
            System.out.println("\nTo indicate the patient's mode of breathing,");
            System.out.println("press 'A' for 'Air' or 'O' for 'Oxygen': ");
            BreathingString = sc.nextLine().toUpperCase();
            valid = Validation.validateChar(BreathingString, "A", "O");
        }
        newPatientBreathing = switch (BreathingString) {
            case "A" -> AirOrOxygen.AIR;
            case "O" -> AirOrOxygen.OXYGEN;
            default -> newPatientBreathing;
        };
        // Update Medi score to reflect the medium which the patient breathes
        score += newPatientBreathing.getScore();

        valid = false;
        while (!valid) {
            System.out.println("\nTo indicate the patient's level of consciousness,");
            System.out.println("press 'A' for 'Alert' or 'C' for 'CVPU': ");
            ConsciousnessString = sc.nextLine().toUpperCase();
            valid = Validation.validateChar(ConsciousnessString, "A", "C");
        }
        newPatientConsciousness = switch (ConsciousnessString) {
            case "A" -> LevelOfConsciousness.ALERT;
            case "C" -> LevelOfConsciousness.CVPU;
            default -> newPatientConsciousness;
        };
        // Update Medi score to reflect patient's level of consciousness
        score += newPatientConsciousness.getScore();

        valid = false;
        while (!valid) {
            System.out.println("\nEnter patient's respiration rate (per minute): ");
            newPatientRespirationString = sc.nextLine();
            newPatientRespiration = Validation.validateStringAsInt(newPatientRespirationString);
            valid = Validation.validateNumericField(newPatientRespiration, 0, 200);
        }
        // Update Medi score to reflect patient's respiration rate
        if (newPatientRespiration <= 8){
            score += 3;
        } else if (newPatientRespiration < 12){
            score += 1;
        } else if (newPatientRespiration > 20 && newPatientRespiration <= 24){
            score += 1;
        } else if (newPatientRespiration >=25){
            score += 3;
        }

        valid = false;
        while (!valid) {
            System.out.println("\nEnter patient's oxygen saturation (SpO2): ");
            newPatientSaturationString = sc.nextLine();
            newPatientSaturation = Validation.validateStringAsInt(newPatientSaturationString);
            valid = Validation.validateNumericField(newPatientSaturation, 0, 100);
        }
        if (newPatientSaturation <= 83){
            score += 3;
        } else if (newPatientSaturation <= 85){
            score += 2;
        } else if (newPatientSaturation <= 87){
            score += 1;
        } else if ((newPatientSaturation == 93 || newPatientSaturation == 94)
            && BreathingString == "O"){
            score += 1;
        } else if ((newPatientSaturation == 95 || newPatientSaturation == 96)
                && BreathingString == "O"){
            score += 2;
        } else if (newPatientSaturation >= 97
                && BreathingString == "O"){
            score += 3;
        }

        valid = false;
        while (!valid) {
            System.out.println("\nEnter patient's temperature: ");
            newPatientTemperatureString = sc.nextLine();
            newPatientTemperature = Validation.validateStringAsFloat(newPatientTemperatureString);
            valid = Validation.validateFloat(newPatientTemperature,
                                        (float) 0.0, (float) 100.0);
        }
        // Round newPatientTemperature to 1 decimal place:
        newPatientTemperature = round(newPatientTemperature, 1);
        // Update Medi score to reflect the patient's temperature:
        if (newPatientTemperature <= (float) 35.0){
            score += 3;
        } else if (newPatientTemperature <= (float) 36.0){
            score += 1;
        } else if (newPatientTemperature >= (float) 38.1
                && newPatientTemperature <= 39.0){
            score += 1;
        } else if (newPatientTemperature >= 39.1){
            score += 2;
        }

        Patient newPatient = new Patient(newPatientFirstName, newPatientLastName,
                newPatientBreathing, newPatientConsciousness, newPatientRespiration,
                newPatientSaturation, newPatientTemperature, score);

        return newPatient;

    }


    /*
      Method to round off a number
      Source - https://stackoverflow.com/a/22186845
      Posted by jpdymond
      Retrieved 2026-03-11 and edited, License - CC BY-SA 3.0
    */

    private static float round (float value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (float) Math.round(value * scale) / scale;
    }

}


