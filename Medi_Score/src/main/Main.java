package main;

import patient.Patient;
import observations.*;

public class Main {
    public static void main(String[] args) {
        Patient patient = RecordResults.recordResults();
        System.out.println(patient);
    }
}
