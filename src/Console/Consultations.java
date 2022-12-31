package Console;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Consultations implements Serializable {
    private String consultationId;
    private Patient patient;
    private String doctor;
    private Notes notes;
    private double cost;
    private Date consultationDate;
    private String time;
    public static ArrayList<Consultations> consultations = new ArrayList<>();
    public static ArrayList<Availability> availabilities = new ArrayList<>();

    public Consultations() {
    }

    public Consultations(String consultationId, Patient patient,
                         String doctor, Notes notes, double cost, Date consultationDate, String time) {
        this.consultationId = consultationId;
        this.patient = patient;
        this.notes = notes;
        this.doctor = doctor;
        this.cost = cost;
        this.consultationDate = consultationDate;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
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

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public static boolean checkAvailability(ArrayList<Availability> availabilities, String doctorName, Date date,
                                            String spec, String time) {
        boolean state = false;
        if (availabilities.size() != 0) {
            for (Availability available : availabilities) {
                if (available.getDoctorName().equals(doctorName)&& available.getSpecialization().equals(spec)) {
                    if(available.getConsultationDate().equals(date) && available.getTime().equals(time)){
                        state = false;
                        break;
                    }else {
                        state = true;
                    }
                }else{
                    state = true;
                }
            }
        }else{
            state = true;
        }
        return state;
    }
}
