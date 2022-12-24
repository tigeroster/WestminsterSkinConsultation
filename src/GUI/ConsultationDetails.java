package GUI;

import javax.swing.*;
import java.awt.*;

public class ConsultationDetails extends JFrame {

    public ConsultationDetails(String pId, String name, String dob, String mob, String Gender,
                               String conId, String doctor, String cost, String conDate, String time){
        // Topic
        JLabel topic = new JLabel("Consultation Details");
        topic.setFont(new Font("Arial", Font.BOLD, 30));
        topic.setSize(500,30);
        topic.setLocation(250,20);
        add(topic);

        // Data
        JLabel patientId = new JLabel("Patient ID : ");
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

        JLabel firstName = new JLabel("Patient Name : ");
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

        JLabel dobL = new JLabel("Date of Birth : ");
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

        JLabel mobL = new JLabel("Mobile Number : ");
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

        JLabel genderL = new JLabel("Gender : ");
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

        JLabel conIdL = new JLabel("Consultation ID : ");
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

        JLabel doctorL = new JLabel("Doctor Name : ");
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

        JLabel costL = new JLabel("Cost : ");
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

        JLabel conDateL = new JLabel("Date : ");
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

        JLabel timeL = new JLabel("Time : ");
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

        setSize(800, 500);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Consultations - Westminster Skin Consultations");
    }
}
