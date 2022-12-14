package GUI;

import Console.Consultations;
import Console.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ViewConsultations extends JFrame{
    JScrollPane scroll;
    public ViewConsultations(){
        ViewConsultationModel consultationModel = new ViewConsultationModel(Consultations.consultations);
        JTable table = new JTable(consultationModel);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(Color.yellow);
        table.setAutoCreateRowSorter(true);
        scroll = new JScrollPane(table);
        scroll = new JScrollPane(table);
        scroll.setSize(1200, 500);
        add(scroll, BorderLayout.CENTER);

        setSize(1200, 500);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Consultations - Westminster Skin Consultations");
    }

}
