package GUI;

import Console.Doctor;

import javax.swing.*;
import java.awt.*;

import static Console.Doctor.doctors;

public class CheckDoctorAvailability extends JFrame {
    JComboBox<Object> comboBox = new JComboBox<>();
    private final String[] consultYears = {
            "2022", "2023"
    };

    private final String[] dates
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private final String[] months
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };

    public CheckDoctorAvailability(){
        Container c = getContentPane();
        c.setLayout(null);
        // Components
        JLabel title = new JLabel("Select your preferred Doctor");
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        title.setSize(600,25);
        title.setLocation(120,30);
        c.add(title);
        // Doctors List
        JLabel doctorNames = new JLabel("Doctor's Name");
        doctorNames.setFont(new Font("Arial", Font.PLAIN, 16));
        doctorNames.setSize(200, 20);
        doctorNames.setLocation(100, 150);
        c.add(doctorNames);

        DefaultComboBoxModel<Object> comboBoxModel = new DefaultComboBoxModel<>();
        for (Doctor doctor : doctors) {
            comboBoxModel.addElement("Dr. " + doctor.getName() + " " + doctor.getSurname());
        }
        comboBox.setModel(comboBoxModel);
        comboBox.setSize(250, 30);
        comboBox.setLocation(250, 150);
        comboBox.addActionListener(e -> {
            System.out.println("Works");
        });
        comboBox.setRenderer(new DefaultListCellRenderer());
        c.add(comboBox);

        // Consultation Date
        JLabel consultDate = new JLabel("Booking Date");
        consultDate.setFont(new Font("Arial", Font.PLAIN, 16));
        consultDate.setSize(200, 20);
        consultDate.setLocation(100, 200);
        c.add(consultDate);

        JComboBox<String> consultDateBox = new JComboBox<>(dates);
        consultDateBox.setFont(new Font("Arial", Font.PLAIN, 15));
        consultDateBox.setSize(50, 20);
        consultDateBox.setLocation(250, 200);
        c.add(consultDateBox);

        JComboBox<String> consultMonth = new JComboBox<>(months);
        consultMonth.setFont(new Font("Arial", Font.PLAIN, 15));
        consultMonth.setSize(80, 20);
        consultMonth.setLocation(300, 200);
        c.add(consultMonth);

        JComboBox<String> consultYear = new JComboBox<>(consultYears);
        consultYear.setFont(new Font("Arial", Font.PLAIN, 15));
        consultYear.setSize(100, 20);
        consultYear.setLocation(380, 200);
        c.add(consultYear);

        // Check Availability Button
        JButton check = new JButton("Check Availability");
        check.setFocusPainted(false);
        check.setSize(200,30);
        check.setLocation(200,250);
        c.add(check);

        setTitle("Check Availability");
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
    }
}
