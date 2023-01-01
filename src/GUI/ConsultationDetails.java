package GUI;

import Console.Consultations;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Objects;

public class ConsultationDetails extends JFrame {
    JLabel imageL;

    public ConsultationDetails(String pId, String name, String dob, String mob, String Gender,
                               String conId, String doctor, String cost, String conDate, String time){

        ImageIcon backButton = new ImageIcon(Objects.requireNonNull(getClass().getResource("back1.png")));
        JButton back = new JButton(backButton);
        back.setFocusPainted(false);
        back.setLocation(50, 20);
        back.setSize(30, 30);
        back.addActionListener(e -> {
            dispose();
            new ViewConsultations();
        });
        add(back);
        // Topic
        JLabel topic = new JLabel("Consultation Details");
        topic.setFont(new Font("Arial", Font.BOLD, 30));
        topic.setSize(500,30);
        topic.setLocation(450,20);
        add(topic);

        // Data
        JLabel patientId = new JLabel("Patient ID");
        patientId.setFont(new Font("Arial", Font.BOLD, 16));
        patientId.setSize(500,30);
        patientId.setLocation(50,100);
        add(patientId);

        JLabel patientIdT = new JLabel();
        patientIdT.setText(pId);
        patientIdT.setFont(new Font("Arial", Font.PLAIN, 16));
        patientIdT.setSize(500,30);
        patientIdT.setLocation(200,100);
        add(patientIdT);

        JLabel firstName = new JLabel("Patient Name");
        firstName.setFont(new Font("Arial", Font.BOLD, 16));
        firstName.setSize(500,30);
        firstName.setLocation(50,150);
        add(firstName);

        JLabel firstNameT = new JLabel();
        firstNameT.setText(name);
        firstNameT.setFont(new Font("Arial", Font.PLAIN, 16));
        firstNameT.setSize(500,30);
        firstNameT.setLocation(200,150);
        add(firstNameT);

        JLabel dobL = new JLabel("Date of Birth");
        dobL.setFont(new Font("Arial", Font.BOLD, 16));
        dobL.setSize(500,30);
        dobL.setLocation(50,200);
        add(dobL);

        JLabel dobT = new JLabel();
        dobT.setText(dob);
        dobT.setFont(new Font("Arial", Font.PLAIN, 16));
        dobT.setSize(500,30);
        dobT.setLocation(200,200);
        add(dobT);

        JLabel mobL = new JLabel("Mobile Number");
        mobL.setFont(new Font("Arial", Font.BOLD, 16));
        mobL.setSize(500,30);
        mobL.setLocation(50,250);
        add(mobL);

        JLabel mobT = new JLabel();
        mobT.setText(mob);
        mobT.setFont(new Font("Arial", Font.PLAIN, 16));
        mobT.setSize(500,30);
        mobT.setLocation(200,250);
        add(mobT);

        JLabel genderL = new JLabel("Gender");
        genderL.setFont(new Font("Arial", Font.BOLD, 16));
        genderL.setSize(500,30);
        genderL.setLocation(50,300);
        add(genderL);

        JLabel genderT = new JLabel();
        genderT.setText(Gender);
        genderT.setFont(new Font("Arial", Font.PLAIN, 16));
        genderT.setSize(500,30);
        genderT.setLocation(200,300);
        add(genderT);

        JLabel nicL = new JLabel("Patient NIC");
        nicL.setFont(new Font("Arial", Font.BOLD, 16));
        nicL.setSize(500,30);
        nicL.setLocation(50,350);
        add(nicL);

        JLabel nic = new JLabel("Patient NIC");
        nic.setText(getNic(conId));
        nic.setFont(new Font("Arial", Font.PLAIN, 16));
        nic.setSize(500,30);
        nic.setLocation(200,350);
        add(nic);

        JLabel conIdL = new JLabel("Consultation ID");
        conIdL.setFont(new Font("Arial", Font.BOLD, 16));
        conIdL.setSize(500,30);
        conIdL.setLocation(450,100);
        add(conIdL);

        JLabel conIdT = new JLabel();
        conIdT.setText(conId);
        conIdT.setFont(new Font("Arial", Font.PLAIN, 16));
        conIdT.setSize(500,30);
        conIdT.setLocation(600,100);
        add(conIdT);

        JLabel doctorL = new JLabel("Doctor Name");
        doctorL.setFont(new Font("Arial", Font.BOLD, 16));
        doctorL.setSize(500,30);
        doctorL.setLocation(450,150);
        add(doctorL);

        JLabel doctorT = new JLabel();
        doctorT.setText(doctor);
        doctorT.setFont(new Font("Arial", Font.PLAIN, 16));
        doctorT.setSize(500,30);
        doctorT.setLocation(600,150);
        add(doctorT);

        JLabel costL = new JLabel("Cost");
        costL.setFont(new Font("Arial", Font.BOLD, 16));
        costL.setSize(500,30);
        costL.setLocation(450,200);
        add(costL);

        JLabel costT = new JLabel();
        costT.setText("£" + cost);
        costT.setFont(new Font("Arial", Font.PLAIN, 16));
        costT.setSize(500,30);
        costT.setLocation(600,200);
        add(costT);

        JLabel conDateL = new JLabel("Date");
        conDateL.setFont(new Font("Arial", Font.BOLD, 16));
        conDateL.setSize(500,30);
        conDateL.setLocation(450,250);
        add(conDateL);

        JLabel conDateT = new JLabel();
        conDateT.setText(conDate);
        conDateT.setFont(new Font("Arial", Font.PLAIN, 16));
        conDateT.setSize(500,30);
        conDateT.setLocation(600,250);
        add(conDateT);

        JLabel timeL = new JLabel("Time");
        timeL.setFont(new Font("Arial", Font.BOLD, 16));
        timeL.setSize(500,30);
        timeL.setLocation(450,300);
        add(timeL);

        JLabel timeT = new JLabel();
        timeT.setText(time);
        timeT.setFont(new Font("Arial", Font.PLAIN, 16));
        timeT.setSize(500,30);
        timeT.setLocation(600,300);
        add(timeT);

        ImageIcon imageIcon = getConsultationImage(conId) == null ?
                new ImageIcon(new ImageIcon("/home/tigherknight/IdeaProjects/Tutorial5/WestminsterSkinConsultationManager/src/GUI/noimg.png").getImage().getScaledInstance(200, 200,
                        Image.SCALE_AREA_AVERAGING))
                : new ImageIcon(new ImageIcon(getConsultationImage(conId)).getImage().getScaledInstance(200, 200,
                Image.SCALE_SMOOTH));
        JLabel photo = new JLabel();
        photo.setIcon(imageIcon);
        photo.setSize(600,200);
        photo.setLocation(800,100);
        add(photo);

        JLabel notes = new JLabel("Notes");
        notes.setFont(new Font("Arial", Font.BOLD, 16));
        notes.setSize(100,30);
        notes.setLocation(730,330);
        add(notes);

        JTextArea encryptedText = new JTextArea();
        encryptedText.setText(ConsultationDetails.getConsultationNotes(conId));
        encryptedText.setFont(new Font("Arial", Font.ITALIC, 16));
        encryptedText.setSize(250, 100);
        encryptedText.setLocation(800,330);
        encryptedText.setLineWrap(true);
        encryptedText.setWrapStyleWord(true);
        encryptedText.setEditable(false);
        add(encryptedText);

        JButton encryptButton = new JButton("Decrypt");
        encryptButton.setFocusPainted(false);
        encryptButton.setSize(100,30);
        encryptButton.setLocation(1050,330);
        add(encryptButton);
        encryptButton.addActionListener(e -> {
            encryptedText.setText(AddConsultations.decrypt(encryptedText.getText()));
            encryptButton.setEnabled(false);
        });

        JButton editButton = new JButton("Edit");
        editButton.setFocusPainted(false);
        editButton.setSize(100,30);
        editButton.setLocation(50,400);
        add(editButton);
        editButton.addActionListener(e -> {
            dispose();
            String[] fullName = name.split(" ");
            String first = fullName[0];
            String last = fullName[1];
            try {
                new EditConsultations(pId, first, last, Gender, mob, dob, nic.getText());
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFocusPainted(false);
        deleteButton.setSize(100,30);
        deleteButton.setLocation(150,400);
        add(deleteButton);
        deleteButton.addActionListener(e-> {
            String[] options = {"Yes", "No"};
            int x = JOptionPane.showOptionDialog(null, "Are you sure you want to delete this Consultation?",
                    "Delete - Westminster Skin Consultations",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(x == 0){
                for(Consultations con : Consultations.consultations){
                    if(conId.equals(con.getConsultationId())){
                        Consultations.consultations.remove(con);
                        JOptionPane.showMessageDialog(this,"Consultation Deleted Successfully");
                        break;
                    }
                }
                AddConsultations.saveConsultations();
                AddConsultations.saveAvailableConsultations();
                dispose();
                new ViewConsultations();
            }
        });

        setSize(1200, 500);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Consultations - Westminster Skin Consultations");
    }

    public static String getConsultationNotes(String id){
        String notes = "";
        for(Consultations con : Consultations.consultations){
            if(con.getConsultationId().equals(id)){
                notes = con.getNotes().getNotes();
                break;
            }
        }
        return notes;
    }

    public static String getConsultationImage(String id){
        String file = "";
        for(Consultations con : Consultations.consultations){
            if(con.getConsultationId().equals(id)){
                file = con.getNotes().getFile();
                break;
            }
        }
        return file;
    }

    public String getNic(String id){
        String nic = "";
        for(Consultations con : Consultations.consultations){
            if(con.getConsultationId().equals(id)){
                nic = con.getPatient().getNic();
            }
        }
        return nic;
    }
}
