package GUI;

import Console.Doctor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class DoctorTableModel extends AbstractTableModel {
    private final String[] headers = {"ID", "Full Name", "Date of Birth", "Mobile Number", "Gender", "Specialization" };
    public static ArrayList<Doctor> doctorsList;

    public DoctorTableModel() {
    }

    public DoctorTableModel(ArrayList<Doctor> doctors) {
        doctorsList = doctors;
    }

    @Override
    public int getRowCount() {
        return doctorsList.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if(columnIndex == 0){
            temp = doctorsList.get(rowIndex).getMedicalLicenseNo();
        }else if(columnIndex == 1){
            temp = doctorsList.get(rowIndex).getName() + " " + doctorsList.get(rowIndex).getSurname();
        }else if(columnIndex == 2){
            temp = doctorsList.get(rowIndex).getDateOfBirth();
        }else if(columnIndex == 3){
            temp = doctorsList.get(rowIndex).getMobileNumber();
        }else if(columnIndex == 4){
            temp = doctorsList.get(rowIndex).getGender();
        }else if(columnIndex == 5){
            temp = doctorsList.get(rowIndex).getSpecialization();
        }
        return temp;
    }
    public String getColumnName(int col){
        return headers[col];
    }

    public Class getColumnClass(int col){
        if(col == 0){
            return String.class;
        }else if(col == 1){
            return String.class;
        }else if(col == 2){
            return Date.class;
        }else if(col == 3){
            return String.class;
        }else if(col == 4){
            return String.class;
        }else if(col == 5){
            return String.class;
        }
        else {
            return null;
        }
    }

}