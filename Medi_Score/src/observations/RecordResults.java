package observations;

import enums.*;
import helpers.*;
import patient.Patient;


public class RecordResults {
    public static Patient recordResults(){

        String firstName;
        String lastName;
        AirOrOxygen breathing;
        LevelOfConsciousness consciousness;
        int respiration;
        int saturation;
        float temperature;
        int score = 0;

        // Record the patient's first name
        firstName = RecordName.recordName("first");

        // Record the patient's last name
        lastName = RecordName.recordName("last");

        // Record whether the patient breathes air or oxygen;
        breathing = RecordAirOrOxygen.recordAirOrOxygen();

        // - Update Medi score to reflect the medium which the patient breathes
        score += breathing.getScore();

        // Record the patient's level of consciousness
        consciousness = RecordConsciousness.recordConsciousness();

        // Update Medi score to reflect the patient's level of consciousness
        score += consciousness.getScore();

        // Record the patient's rate of respiration
        respiration = RecordRespiration.recordRespiration();

        // Update Medi score to reflect patient's respiration rate
        if (respiration <= 8){
            score += 3;
        } else if (respiration < 12){
            score += 1;
        } else if (respiration > 20 && respiration <= 24){
            score += 2;
        } else if (respiration >=25){
            score += 3;
        }

        // Record the patient's oxygen saturation
        saturation = RecordSaturation.recordSaturation();

        // Update Medi score to reflect patient's oxygen saturation
        if (saturation <= 83){
            score += 3;
        } else if (saturation <= 85){
            score += 2;
        } else if (saturation <= 87){
            score += 1;
        } else if ((saturation == 93 || saturation == 94)
            && breathing.getScore() == 2){
            score += 1;
        } else if ((saturation == 95 || saturation == 96)
                && breathing.getScore() == 2){
            score += 2;
        } else if (saturation >= 97
                && breathing.getScore() == 2){
            score += 3;
        }

        // Record the patient's temperature
        temperature = RecordTemperature.recordTemperature();

        // Update Medi score to reflect the patient's temperature:
        if (temperature <= (float) 35.0){
            score += 3;
        } else if (temperature <= (float) 36.0){
            score += 1;
        } else if (temperature >= (float) 38.1
                && temperature <= 39.0){
            score += 1;
        } else if (temperature >= 39.1){
            score += 2;
        }

        // Create instance of Patient class
        Patient patient = new Patient(firstName, lastName,
                breathing, consciousness, respiration,
                saturation, temperature, score);

        return patient;
    }
}


