import java.util.Scanner;

public class RecordResults {
    public static Patient recordResult(){

        boolean valid = false; // Variable to validate keyboard input

        Scanner sc = new Scanner(System.in);  // sc allows entry from keyboard

        // Note patient's first and last names can be no longer than 30 characters each

        String newPatientFirstName = "";
        String newPatientLastName = "";
        String BreathingString = "";
        AirOrOxygen newPatientBreathing = null;
        String ConsciousnessString = "";
        LevelOfConsciousness newPatientConsciousness = null;
        int newPatientRespiration = 0;
        int newPatientSaturation = 0;
        float  newPatientTemperature = 0;

        while (!valid) {
            System.out.println("Please enter the patient's first name: ");
            newPatientFirstName = sc.nextLine();
            valid = Validation.validateTextField(newPatientFirstName, (byte) 20);
        }

        valid = false;  // re-initialise valid after each field has been checked
        while (!valid) {
            System.out.println("Enter the patient's last name: ");
            newPatientLastName = sc.nextLine();
            valid = Validation.validateTextField(newPatientLastName, (byte) 20);
        }

        valid = false;
        while (!valid) {
            System.out.println(" To indicate the patient's mode of breathing,");
            System.out.println("press 'A' for 'Air' or 'O' for 'Oxygen': ");
            BreathingString = sc.nextLine();
            valid = Validation.validateChar(BreathingString, "A", "O");
        }
        newPatientBreathing = switch (BreathingString) {
            case "A" -> AirOrOxygen.AIR;
            case "O" -> AirOrOxygen.OXYGEN;
            default -> newPatientBreathing;
        };


        valid = false;
        while (!valid) {
            System.out.println(" To indicate the patient's level of consciousness,");
            System.out.println("press 'A' for 'Alert' or 'C' for 'CVPU': ");
            ConsciousnessString = sc.nextLine();
            valid = Validation.validateChar(ConsciousnessString, "A", "C");
        }
        newPatientConsciousness = switch (ConsciousnessString) {
            case "A" -> LevelOfConsciousness.ALERT;
            case "C" -> LevelOfConsciousness.CVPU;
            default -> newPatientConsciousness;
        };

        valid = false;
        while (!valid) {
            System.out.println(" Enter respiration rate (per minute): ");
            newPatientRespiration = sc.nextInt();
            valid = Validation.validateNumericField(newPatientRespiration, 0, 200);
        }

        valid = false;
        while (!valid) {
            System.out.println(" Enter oxygen saturation (SpO2): ");
            newPatientSaturation = sc.nextInt();
            valid = Validation.validateNumericField(newPatientSaturation, 0, 100);
        }

        valid = false;
        while (!valid) {
            System.out.println(" Enter temperature: ");
            newPatientTemperature = sc.nextFloat();
            valid = Validation.validateFloat(newPatientTemperature,
                                        (float) 0.0, (float) 100.0);
        }
        // Round newPatientTemperature to 1 decimal place:
        newPatientTemperature = round(newPatientTemperature, 1);

        Patient newPatient = new Patient(newPatientFirstName, newPatientLastName,
                newPatientBreathing, newPatientConsciousness, newPatientRespiration,
                newPatientSaturation, newPatientTemperature);

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


