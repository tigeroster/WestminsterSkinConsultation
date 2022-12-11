package GUI;

import Console.Doctor;
import javax.swing.*;
import java.awt.*;
public class ViewDoctors extends JFrame {
    JScrollPane scroll;
    public ViewDoctors() {
        DoctorTableModel doctorTableModel = new DoctorTableModel(Doctor.doctors);
        JTable table = new JTable(doctorTableModel);
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
        setTitle("Doctors - Westminster Skin Consultations");
    }
}
