package patient;

import enums.AirOrOxygen;
import enums.LevelOfConsciousness;

public class Patient {

    /* Though the patient is an object in the OOP sense,
      they are given a first and last name, to make them
      more relatable, helping to prevent staff from
      objectifying them.
       It may also be convenient to include fields for
      their NHS number and date of birth.
       However, using these fields has the side-effect of
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

    private int mediScore;

    public Patient(String firstName, String lastName, AirOrOxygen breathing,
                   LevelOfConsciousness consciousness, int respiration, int saturation,
                   float temperature, int mediScore){
        this.firstName = firstName;
        this.lastName = lastName;

        this.breathing = breathing;
        /*
           the "breathing" attribute indicates whether the patient
           is on air or oxygen
         */
        this.consciousness = consciousness;
        this.respiration = respiration;
        this.saturation = saturation;   // eg. SpO2
        this.temperature = temperature;
        this.mediScore = mediScore;
    }

    // Getters and setters for Patient.Patient class follow:

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setBreathing(AirOrOxygen breathing){
        this.breathing = breathing;
    }

    public Enum getBreathing() {
        return breathing;
    }

    public void setConsciousness(LevelOfConsciousness consciousness){
        this.consciousness = consciousness;
    }

    public Enum getConsciousness() {
        return consciousness;
    }

    public void setRespiration(int respiration) {
        this.respiration = respiration;
    }

    public int getRespiration() {
        return respiration;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setMediScore(int mediScore) {
        this.mediScore = mediScore;
    }

    public int getMediScore() {
        return mediScore;
    }

    @Override
    public String toString(){
        return
                  "First name = " + this.getFirstName()
                + "\n Last name = " + this.getLastName()
                + "\n Breathing = " + this.getBreathing()
                + "\n Consciousness = " + this.getConsciousness()
                + "\n Respiration = " + this.getRespiration()
                + "\n Saturation = " + this.getSaturation()
                + "\n Temperature = " + this.getTemperature()
                + "\n________________" +
                  "\n Medi score = " + this.getMediScore()
                + "\n----------------";
    }
}