package observations;

import enums.*;
import helpers.*;
import patient.Patient;


public class RecordResults {

    /*
       Method to determine patient's physiological measurements.
      In its turn it will call other methods for each characteristic.
    */
    public static Patient recordResults(){

        String firstName;
        String lastName;
        AirOrOxygen breathing;
        LevelOfConsciousness consciousness;
        int respiration;
        int saturation;
        float temperature;
        float bloodGlucose;
        boolean fasting;
        int breathingScore;
        int consciousnessScore;
        int respirationScore = 0;
        int saturationScore = 0;
        int temperatureScore = 0;
        int bloodGlucoseScore = 0;
        int mediScore;

        // Record the patient's first name
        firstName = RecordName.recordName("first");

        // Record the patient's last name
        lastName = RecordName.recordName("last");

        // Record whether the patient breathes air or oxygen;
        breathing = RecordAirOrOxygen.recordAirOrOxygen();

        // - Update Medi score to reflect the medium which the patient breathes
        breathingScore = breathing.getScore();

        // Print Medi Score points
        ScoreChecker.scoreChecker(breathing.getScore());

        // Record the patient's level of consciousness
        consciousness = RecordConsciousness.recordConsciousness();

        // - Update Medi score to reflect the patient's level of consciousness
        consciousnessScore = consciousness.getScore();

        // Print Medi Score points and check for additional risk
        ScoreChecker.scoreChecker(consciousness.getScore());

        // Record the patient's rate of respiration
        respiration = RecordRespiration.recordRespiration();

        // Update Medi score to reflect patient's respiration rate
        if (respiration <= 8){
            respirationScore = 3;
        } else if (respiration < 12){
            respirationScore = 1;
        } else if (respiration > 20 && respiration <= 24){
            respirationScore = 2;
        } else if (respiration >=25){
            respirationScore = 3;
        }

        // Print Medi Score points and check for additional risk
        ScoreChecker.scoreChecker(respirationScore);

        // Record the patient's oxygen saturation
        saturation = RecordSaturation.recordSaturation();

        // Update Medi score to reflect patient's oxygen saturation
        if (saturation <= 83){
            saturationScore = 3;
        } else if (saturation <= 85){
            saturationScore = 2;
        } else if (saturation <= 87){
            saturationScore = 1;
        } else if ((saturation == 93 || saturation == 94)
            && breathing.getScore() == 2){
            saturationScore = 1;
        } else if ((saturation == 95 || saturation == 96)
                && breathing.getScore() == 2){
            saturationScore = 2;
        } else if (saturation >= 97
                && breathing.getScore() == 2){
            saturationScore = 3;
        }

        // Print Medi Score points and check for additional risk
        ScoreChecker.scoreChecker(saturationScore);

        // Record the patient's temperature
        temperature = RecordTemperature.recordTemperature();

        // Update Medi score to reflect the patient's temperature:
        if (temperature <= (float) 35.0){
            temperatureScore = 3;
        } else if (temperature <= (float) 36.0){
            temperatureScore = 1;
        } else if (temperature >= (float) 38.1
                && temperature <= 39.0){
            temperatureScore = 1;
        } else if (temperature >= 39.1){
            temperatureScore = 2;
        }

        // Print Medi Score points and check for additional risk
        ScoreChecker.scoreChecker(temperatureScore);

        // Record the patient's Capillary Blood Glucose [CBG]
        bloodGlucose = RecordCBG.recordCBG();

        // Find out if patient is fasting
        fasting = RecordFasting.recordFasting();

        // Update Medi score to reflect the patient's CBG:
        if (fasting){
            if (bloodGlucose <= (float) 3.4) {
                bloodGlucoseScore = 3;
            } else if (bloodGlucose >= (float) 3.5
                && bloodGlucose <= 3.9) {
                bloodGlucoseScore = 2;
            } else if (bloodGlucose >= (float) 5.5
                    && bloodGlucose <= 5.9) {
                bloodGlucoseScore = 2;
            } else if (bloodGlucose >= (float) 6.0){
                bloodGlucoseScore = 3;
            }
        } else if (!fasting){
            if (bloodGlucose <= (float) 4.5) {
                bloodGlucoseScore = 3;
            } else if (bloodGlucose >= (float) 4.5
                    && bloodGlucose <= 5.8) {
                bloodGlucoseScore = 2;
            } else if (bloodGlucose >= (float) 7.9
                    && bloodGlucose <= 8.9) {
                bloodGlucoseScore = 2;
            } else if (bloodGlucose >= (float) 9.0){
                bloodGlucoseScore = 3;
            }
        }

        // Print Medi Score points and check for additional risk
        ScoreChecker.scoreChecker(bloodGlucoseScore);

        // Calculate total mediScore
        mediScore = breathingScore + consciousnessScore + respirationScore + saturationScore
                + temperatureScore + bloodGlucoseScore;

        // Return instance of Patient class
        return new Patient(firstName, lastName,
                breathing, consciousness, respiration,
                saturation, temperature, bloodGlucoseScore, mediScore);
    }
}


