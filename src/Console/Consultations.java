package Console;

import java.util.ArrayList;
import java.util.Date;

public class Consultations {
    private int consultationId;
    private Patient patient;
    private String doctor;
    private String notes;
    public static ArrayList<Consultations> consultations = new ArrayList<>();
    public static ArrayList<Availability> availabilities = new ArrayList<>();

    public Consultations() {
    }

    public Consultations(int consultationId, Patient patient,
                         String doctor, String notes) {
        this.consultationId = consultationId;
        this.patient = patient;
        this.notes = notes;
        this.doctor = doctor;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static boolean checkAvailability(ArrayList<Availability> availabilities, String doctorName, Date date) {
        boolean state = false;
        if (availabilities.size() != 0) {
            for (Availability available : availabilities) {
                if (available.getDoctorName().equals(doctorName)) {
                    if (available.getConsultationDate().equals(date)) {
                        state = false;
                        break;
                    } else {
                        state = true;
                    }
                } else {
                    state = true;
                }
            }
        } else {
            state = true;
        }
        return state;
    }
}
