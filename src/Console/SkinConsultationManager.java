package Console;

import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {
    void addDoctor(ArrayList<Doctor> doctors);
    void viewDoctors(ArrayList<Doctor> doctors);
    void deleteDoctor(ArrayList<Doctor> doctors);
    void saveData(ArrayList<Doctor> doctors);
    void loadData(ArrayList<Doctor> doctors) throws IOException;
}
