package GUI;

import Console.Doctor;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ViewDoctors extends JFrame {
    JScrollPane scroll;
    public ViewDoctors() {
        DoctorTableModel doctorTableModel = new DoctorTableModel(Doctor.doctors);
        JTable table = new JTable(doctorTableModel);
        table.setRowHeight(30);
        table.getTableHeader().setBackground(Color.yellow);
        table.setAutoCreateRowSorter(true);
        scroll = new JScrollPane(table);
        scroll.setSize(1200, 500);
        scroll.setLocation(0,100);
        add(scroll, BorderLayout.CENTER);

        // Back Button
        ImageIcon backButton = new ImageIcon(Objects.requireNonNull(getClass().getResource("home1.png")));
        JButton back = new JButton(backButton);
        back.setFocusPainted(false);
        back.setLocation(50,20);
        back.setSize(30,30);
        back.addActionListener(e -> {
            dispose();
            new Home();

        });
        add(back);

        setSize(1200, 500);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Doctors - Westminster Skin Consultations");
    }
}
