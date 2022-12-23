package Console;

import java.io.Serializable;
import java.util.Date;

public class Availability implements Serializable {
    private String doctorName;
    private Date consultationDate;
    private String specialization;
    private String time;
    public Availability(){}

    public Availability(String doctorName, Date consultationDate, String specialization, String time) {
        this.doctorName = doctorName;
        this.consultationDate = consultationDate;
        this.specialization = specialization;
        this.time = time;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }
}
