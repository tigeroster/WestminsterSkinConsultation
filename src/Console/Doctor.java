package Console;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Person{
    private String medicalLicenseNo;
    private String specialization;
    public static final String[] specializationNames = new String[]{"Dermatology", "Internal " +
            "medicine",
            "Neurology", "Psychiatry", "Surgery", "General Practitioner"};
    public static final ArrayList<Doctor> doctors = new ArrayList<>(10);

    public Doctor(){}
    public Doctor(String medicalLicenseNo, String specialization) {
        this.medicalLicenseNo = medicalLicenseNo;
        this.specialization = specialization;
    }
    public Doctor(String name, String surname, Date dateOfBirth, String mobileNumber, String medicalLicenseNo,
                  String specialization,String gender) {
        super(name, surname, dateOfBirth, mobileNumber,gender);
        this.medicalLicenseNo = medicalLicenseNo;
        this.specialization = specialization;
    }
    public String getMedicalLicenseNo() {
        return medicalLicenseNo;
    }
    public void setMedicalLicenseNo(String medicalLicenseNo) {
        this.medicalLicenseNo = medicalLicenseNo;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}