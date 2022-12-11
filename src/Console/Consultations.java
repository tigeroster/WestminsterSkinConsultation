package Console;

import java.sql.Time;
import java.util.Date;

public class Consultations {
    private int consultationId;
    private Date consultatoionDate;
    private Patient patient;
    private Doctor doctor;
    private String notes;

    public Consultations(){}

    public Consultations(int consultationId, Date consultatoionDate, Patient patient,
                         Doctor doctor, String notes) {
        this.consultationId = consultationId;
        this.consultatoionDate = consultatoionDate;
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

    public Date getConsultatoionDate() {
        return consultatoionDate;
    }

    public void setConsultatoionDate(Date consultatoionDate) {
        this.consultatoionDate = consultatoionDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
