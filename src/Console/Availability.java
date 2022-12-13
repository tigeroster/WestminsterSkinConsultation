package Console;

import java.io.Serializable;
import java.util.Date;

public class Availability implements Serializable {
    private String doctorName;
    private Date consultationDate;
    public Availability(){}

    public Availability(String doctorName, Date consultationDate) {
        this.doctorName = doctorName;
        this.consultationDate = consultationDate;
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
