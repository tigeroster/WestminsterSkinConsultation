package GUI;

import Console.Consultations;
import Console.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;


public class EditConsultations extends JFrame {
    ButtonGroup gen;
    JTextField dobPicker;
    JTextField tFirstname, tSurname, tMobile, nic;
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public EditConsultations(String pId, String first, String last, String genderP, String mob, String dateOfBirth,
                             String pNic) throws ParseException {
        ImageIcon calendar = new ImageIcon(Objects.requireNonNull(getClass().getResource("calendar.png")));
        Container c = getContentPane();
        c.setLayout(null);
        // Components
        JLabel title = new JLabel("Edit Consultation");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        c.add(title);

        // Home button
        ImageIcon homeIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("home1.png")));
        JButton home = new JButton(homeIcon);
        home.setSize(30, 30);
        home.setFocusPainted(false);
        home.setLocation(50, 20);
        home.addActionListener(e -> {
            dispose();
            new Home();
        });
        c.add(home);

        // First Name
        JLabel firstname = new JLabel("First Name");
        firstname.setFont(new Font("Arial", Font.PLAIN, 16));
        firstname.setSize(200, 20);
        firstname.setLocation(100, 110);
        c.add(firstname);

        tFirstname = new JTextField();
        tFirstname.setText(first);
        tFirstname.setFont(new Font("Arial", Font.PLAIN, 15));
        tFirstname.setSize(250, 30);
        tFirstname.setLocation(250, 100);
        c.add(tFirstname);

        // Surname
        JLabel surname = new JLabel("Surname");
        surname.setFont(new Font("Arial", Font.PLAIN, 16));
        surname.setSize(200, 20);
        surname.setLocation(100, 150);
        c.add(surname);

        tSurname = new JTextField();
        tSurname.setText(last);
        tSurname.setFont(new Font("Arial", Font.PLAIN, 15));
        tSurname.setSize(250, 30);
        tSurname.setLocation(250, 150);
        c.add(tSurname);

        // Gender
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 16));
        gender.setSize(200, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        male.setSize(100, 30);
        male.setLocation(250, 200);
        female.setSize(100, 30);
        female.setLocation(350, 200);
        if (genderP.equals(male.getText())) {
            male.setSelected(true);
        } else {
            female.setSelected(true);
        }
        c.add(male);
        c.add(female);
        gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.PLAIN, 16));
        dob.setSize(200, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        dobPicker = new JTextField();
        dobPicker.setText(dateOfBirth);
        dobPicker.setFont(new Font("Arial", Font.PLAIN, 15));
        dobPicker.setSize(150, 30);
        dobPicker.setLocation(250, 250);
        JButton dobButton = new JButton();
        dobButton.setIcon(calendar);
        dobButton.setFocusPainted(false);
        dobButton.setSize(50, 30);
        dobButton.setLocation(400, 250);
        dobButton.addActionListener(e -> {
            dobPicker.setText(new DatePicker(this).setPickedDate());
        });
        c.add(dobButton);
        c.add(dobPicker);

        // Mobile Number
        JLabel mobile = new JLabel("Mobile Number");
        mobile.setFont(new Font("Arial", Font.PLAIN, 16));
        mobile.setSize(200, 20);
        mobile.setLocation(100, 300);
        c.add(mobile);

        tMobile = new JTextField();
        tMobile.setText(mob);
        tMobile.setFont(new Font("Arial", Font.PLAIN, 15));
        tMobile.setSize(250, 30);
        tMobile.setLocation(250, 300);
        c.add(tMobile);

        // NIC
        JLabel nicL = new JLabel("NIC Number");
        nicL.setFont(new Font("Arial", Font.PLAIN, 16));
        nicL.setSize(200, 20);
        nicL.setLocation(100, 350);
        c.add(nicL);

        nic = new JTextField();
        nic.setText(pNic);
        nic.setFont(new Font("Arial", Font.PLAIN, 15));
        nic.setSize(250, 30);
        nic.setLocation(250, 350);
        c.add(nic);

        JButton update = new JButton("Update");
        JButton cancel = new JButton("Cancel");
        update.setSize(100,30);
        cancel.setSize(100,30);
        update.setLocation(100, 400);
        cancel.setLocation(200,400);
        c.add(update);
        c.add(cancel);

        update.addActionListener(e -> {
            for(Consultations consultations : Consultations.consultations){
                if(pId.equals(consultations.getPatient().getId())){
                    consultations.getPatient().setName(tFirstname.getText());
                    consultations.getPatient().setSurname(tSurname.getText());
                    consultations.getPatient().setGender(AddConsultations.getSelectedButtonText(gen));
                    try {
                        consultations.getPatient().setDateOfBirth(dateFormatter.parse(dobPicker.getText()));
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    consultations.getPatient().setMobileNumber(tMobile.getText());
                    consultations.getPatient().setNic(nic.getText());
                }
            }
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to Update Patient Information?");
            if(option == 0){
                AddConsultations.saveConsultations();
                dispose();
                new ViewConsultations();
            }

        });
        cancel.addActionListener(e-> {
            dispose();
            new ViewConsultations();
        });

        setTitle("Edit the Consultation");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
