package Console;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person{
    private String id;
    private static final ArrayList<Patient> patients = new ArrayList<>();
    public Patient(String name, String surname, Date dateOfBirth, String mobileNumber, String gender, String id) {
        super(name, surname, dateOfBirth, mobileNumber, gender);
        this.id = id;
    }

    public Patient(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Patient> getPatients(){
        return patients;
    }
}
