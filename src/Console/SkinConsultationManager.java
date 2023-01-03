package Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface SkinConsultationManager {
    void addDoctor(ArrayList<Doctor> doctors, Scanner scanner);
    void viewDoctors(ArrayList<Doctor> doctors);
    void deleteDoctor(ArrayList<Doctor> doctors, Scanner scanner);
    void saveData(ArrayList<Doctor> doctors);
    void loadData() throws IOException;
}
