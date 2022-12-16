package GUI;

import Console.Consultations;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class ViewConsultationModel extends AbstractTableModel {
    private final String[] headers = {"Patient ID", "Patient Name", "Date of Birth", "Mobile Number", "Gender",
            "Consultation ID",
            "Doctor Appointed" , "Consultation Cost", "Date"};
    public static ArrayList<Consultations> consultations;

    public ViewConsultationModel() {
    }

    public ViewConsultationModel(ArrayList<Consultations> consultations) {
        ViewConsultationModel.consultations = consultations;
    }

    @Override
    public int getRowCount() {
        return consultations.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if(columnIndex == 0){
            temp = consultations.get(rowIndex).getPatient().getId();
        }else if(columnIndex == 1){
            temp = consultations.get(rowIndex).getPatient().getName() + " " + consultations.get(rowIndex).getPatient().getSurname();
        }else if(columnIndex == 2){
            temp = String.format("%1$tb %1$te, %1$tY", consultations.get(rowIndex).getPatient().getDateOfBirth());
        }else if(columnIndex == 3){
            temp = consultations.get(rowIndex).getPatient().getMobileNumber();
        }else if(columnIndex == 4){
            temp = consultations.get(rowIndex).getPatient().getGender();
        }else if(columnIndex == 5){
            temp = consultations.get(rowIndex).getConsultationId();
        }else if(columnIndex == 6){
            temp = consultations.get(rowIndex).getDoctor();
        }else if(columnIndex == 7){
            temp = consultations.get(rowIndex).getCost();
        }else if(columnIndex == 8){
            temp = String.format("%1$tb %1$te, %1$tY", consultations.get(rowIndex).getConsultationDate());
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
            return String.class;
        }else if(col == 3){
            return String.class;
        }else if(col == 4){
            return String.class;
        }else if(col == 5){
            return String.class;
        }else if(col == 6){
            return String.class;
        }else if(col == 7){
            return String.class;
        }else if(col == 8){
            return String.class;
        }
        else {
            return null;
        }
    }

}
