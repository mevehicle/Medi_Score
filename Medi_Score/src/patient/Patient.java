package patient;

import enums.AirOrOxygen;
import enums.LevelOfConsciousness;

public class Patient {

    /* Though the patient is an object in the OOP sense,
      they are given a first and last name, to make them
      more relatable, helping to prevent staff from
      objectifying them.
       It may also be convenient to include fields for
      their NHS number, next-of-kin and emergency contact.
       However, using these fields has the side effect of
      storing data by which they could be identified, hence
      data protection implications.
     */

    private String firstName;
    private String lastName;

    private AirOrOxygen breathing;
    private LevelOfConsciousness consciousness;
    private int respiration;
    private int saturation;  // eg. SpO2
    private float temperature;
    private float bloodGlucose;

    private int mediScore;

    public Patient(String firstName, String lastName, AirOrOxygen breathing,
                   LevelOfConsciousness consciousness, int respiration, int saturation,
                   float temperature, float bloodGlucose, int mediScore){
        this.firstName = firstName;
        this.lastName = lastName;

        /*
           The "breathing" attribute indicates whether the patient
           is on air or oxygen
        */
        this.breathing = breathing;

        /*
           The "consciousness" attribute indicates whether the patient
           is alert or CVPU
        */
        this.consciousness = consciousness;

        this.respiration = respiration;
        this.saturation = saturation;   // eg. SpO2
        this.temperature = temperature;
        this.bloodGlucose = bloodGlucose; // eg. CBG
        this.mediScore = mediScore;
    }

    /*
       Getters for Patient class follow:
       (Setters are not necessary, as all fields are inputted
      via keyboard input or constructor)
    */

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Enum getBreathing() {
        return breathing;
    }

    public Enum getConsciousness() {
        return consciousness;
    }

    public int getRespiration() {
        return respiration;
    }

    public int getSaturation() {
        return saturation;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getBloodGlucose() {
        return bloodGlucose;
    }

    public int getMediScore() {
        return mediScore;
    }

    @Override
    public String toString(){
        return
                  "\n First name = " + this.getFirstName()
                + "\n Last name = " + this.getLastName()
                + "\n Breathing = " + this.getBreathing()
                + "\n Consciousness = " + this.getConsciousness()
                + "\n Respiration = " + this.getRespiration()
                + "\n Saturation = " + this.getSaturation()
                + "\n Temperature = " + this.getTemperature()
                + "\n CBG = " + this.getBloodGlucose()
                + "\n________________" +
                  "\n Medi score = " + this.getMediScore()
                + "\n----------------\n\n";
    }
}