package GUI;

import Console.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import static Console.Doctor.doctors;

public class AddConsultations extends JFrame {
    JComboBox<Object> comboBox = new JComboBox<>();
    JComboBox<Object> comboBoxS = new JComboBox<>();

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
    private final String[] years
            = { "1990","1991","1992","1993","1994","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "2022" };

    private final String[] time = {
            "09:00", "10:00", "11:00", "12:00", "01:00", "02:00", "03:00", "04:00", "05:00","06:00"
    };

    private final String[] consultYears = {
            "2023", "2024", "2025"
    };
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MMM/yyyy");
    public AddConsultations(){
        Container c = getContentPane();
        c.setLayout(null);
        // Components
        JLabel title = new JLabel("Book a Consultation");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300,30);
        title.setLocation(450,30);
        c.add(title);

        // View Consultations
        JButton viewConsultations = new JButton("All Consultations");
        viewConsultations.setFocusPainted(false);
        viewConsultations.setSize(170,30);
        viewConsultations.setLocation(1000,30);
        try{
            viewConsultations.addActionListener(e -> {
                new ViewConsultations();
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        c.add(viewConsultations);

        // First Name
        JLabel firstname = new JLabel("First Name");
        firstname.setFont(new Font("Arial", Font.PLAIN, 16));
        firstname.setSize(200, 20);
        firstname.setLocation(100, 110);
        c.add(firstname);

        JTextField tFirstname = new JTextField();
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

        JTextField tSurname = new JTextField();
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
        male.setSelected(true);
        c.add(male);
        c.add(female);
        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.PLAIN, 16));
        dob.setSize(200, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        JComboBox<String> date = new JComboBox<>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(250, 250);
        c.add(date);

        JComboBox<String> month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(80, 20);
        month.setLocation(300, 250);
        c.add(month);

        JComboBox<String> year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(100, 20);
        year.setLocation(380, 250);
        c.add(year);

        // Mobile Number
        JLabel mobile = new JLabel("Mobile Number");
        mobile.setFont(new Font("Arial", Font.PLAIN, 16));
        mobile.setSize(200, 20);
        mobile.setLocation(100, 300);
        c.add(mobile);

        JTextField tMobile = new JTextField();
        tMobile.setFont(new Font("Arial", Font.PLAIN, 15));
        tMobile.setSize(250, 30);
        tMobile.setLocation(250, 300);
        c.add(tMobile);



        // Doctor Specialization
        JLabel doctorSpecialization = new JLabel("Specialization");
        doctorSpecialization.setFont(new Font("Arial", Font.PLAIN, 16));
        doctorSpecialization.setSize(140, 20);
        doctorSpecialization.setLocation(600, 110);
        c.add(doctorSpecialization);

        DefaultComboBoxModel<Object> comboBoxModelS = new DefaultComboBoxModel<>();
        comboBoxModelS.addElement("");
        for (String spec : Doctor.specializationNames) {
            comboBoxModelS.addElement(spec);
        }
        comboBoxS.setModel(comboBoxModelS);
        comboBoxS.setSize(400, 30);
        comboBoxS.setLocation(750, 110);
        comboBoxS.setRenderer(new DefaultListCellRenderer());
        c.add(comboBoxS);

        // Doctor's List
        JLabel doctorNames = new JLabel("Doctor's Name");
        doctorNames.setFont(new Font("Arial", Font.PLAIN, 16));
        doctorNames.setSize(130, 20);
        doctorNames.setLocation(600, 150);
        c.add(doctorNames);

        DefaultComboBoxModel<Object> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxS.addActionListener(e ->{
            comboBox.removeAllItems();
            for (Doctor doctor : doctors) {
                if(doctor.getSpecialization().equals(comboBoxS.getSelectedItem())){
                    comboBoxModel.addElement(doctor.getName() + " " + doctor.getSurname());
                }
            }
        });

        comboBox.setModel(comboBoxModel);
        comboBox.setSize(400, 30);
        comboBox.setLocation(750, 150);
        comboBox.setRenderer(new DefaultListCellRenderer());
        c.add(comboBox);

        // Consultation Date
        JLabel consultDate = new JLabel("Booking Date");
        consultDate.setFont(new Font("Arial", Font.PLAIN, 16));
        consultDate.setSize(200, 20);
        consultDate.setLocation(600, 200);
        c.add(consultDate);

        JComboBox<String> consultDateBox = new JComboBox<>(dates);
        consultDateBox.setFont(new Font("Arial", Font.PLAIN, 15));
        consultDateBox.setSize(60, 20);
        consultDateBox.setLocation(750, 200);
        c.add(consultDateBox);

        JComboBox<String> consultMonth = new JComboBox<>(months);
        consultMonth.setFont(new Font("Arial", Font.PLAIN, 15));
        consultMonth.setSize(80, 20);
        consultMonth.setLocation(820, 200);
        c.add(consultMonth);

        JComboBox<String> consultYear = new JComboBox<>(consultYears);
        consultYear.setFont(new Font("Arial", Font.PLAIN, 15));
        consultYear.setSize(100, 20);
        consultYear.setLocation(900, 200);
        c.add(consultYear);

        // Consultation Time
        JLabel consultTime = new JLabel("Booking Time");
        consultTime.setFont(new Font("Arial", Font.PLAIN, 16));
        consultTime.setSize(200, 20);
        consultTime.setLocation(600, 250);
        c.add(consultTime);
        JComboBox<String> comboBoxT = new JComboBox<>(time);
        comboBoxT.setSize(100, 30);
        comboBoxT.setLocation(750, 250);
        comboBoxT.setRenderer(new DefaultListCellRenderer());
        c.add(comboBoxT);

        // Notes
        JLabel notes = new JLabel("Additional Notes");
        notes.setFont(new Font("Arial", Font.PLAIN, 16));
        notes.setSize(200, 20);
        notes.setLocation(600, 300);
        c.add(notes);

        JTextArea jNotes = new JTextArea();
        jNotes.setFont(new Font("Arial", Font.PLAIN, 15));
        jNotes.setSize(250, 100);
        jNotes.setLocation(750, 300);
        c.add(jNotes);

        // Book a consultation button
        JButton book = new JButton("Book");
        book.setFocusPainted(false);
        book.setSize(100,30);
        book.setLocation(600,350);
        try{
            book.addActionListener(e -> {
                String patientName = tFirstname.getText() + " " + tSurname.getText();
                String doctorName = (String) comboBox.getSelectedItem();
                String dateBox = (String) consultDateBox.getSelectedItem();
                String monthBox = (String) consultMonth.getSelectedItem();
                String yearBox = (String) consultYear.getSelectedItem();
                String pDateBox = (String) date.getSelectedItem();
                String pMonthBox = (String) month.getSelectedItem();
                String pYearBox = (String) year.getSelectedItem();
                String dateOfBirth = pDateBox +"/" + pMonthBox + "/" + pYearBox;
                String dateFormat = dateBox +"/" + monthBox + "/" + yearBox;
                Date formatBox;
                Date dobBox;
                try {
                    dobBox = dateFormatter.parse(dateOfBirth);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    formatBox = dateFormatter.parse(dateFormat);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                if(Consultations.checkAvailability(Consultations.availabilities, doctorName, formatBox)){
                    String id = Helper.idGenerator(5);
                    String consultationId = Helper.idGenerator(8);
                    String genderSelected = getSelectedButtonText(gen);
                    Patient patient = new Patient(tFirstname.getText(), tSurname.getText(), dobBox,
                            tMobile.getText(), genderSelected, id);
                    Patient.patients.add(patient);
                    Consultations.availabilities.add(new Availability(doctorName,formatBox));
                    saveAvailableConsultations();
                    Consultations.consultations.add(new Consultations(consultationId, patient, doctorName,
                            jNotes.getText(), pastConsultations(patientName), formatBox, (String) comboBoxT.getSelectedItem()));
                    saveConsultations();
                    JOptionPane.showMessageDialog(this,"Consultation Added Successfully!");
                    for(Consultations con : Consultations.consultations){
                        System.out.println("Consultation ID: " + con.getConsultationId());
                        System.out.println("Patient Name: " + con.getPatient().getName() + con.getPatient().getSurname());
                        System.out.println("Patient ID: " + con.getPatient().getId());
                        System.out.println("Doctor Assigned: " + con.getDoctor());
                        System.out.println("Consultation Cost: " + "$" + con.getCost());
                    }
                    tFirstname.setText("");
                    tSurname.setText("");
                    jNotes.setText("");
                    tMobile.setText("");
                }else{
                    JOptionPane.showMessageDialog(this,"Doctor already occupied\nOn call doctor assigned");
                }
            });
        }catch(RuntimeException runtimeException){
            runtimeException.printStackTrace();
        }
        c.add(book);
        setTitle("Add a Consultation");
        setSize(1200, 600);
        setVisible(true);
        setResizable(false);
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public static void saveAvailableConsultations(){
        try {
            File file = new File("availableConsultations.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (Availability available : Consultations.availabilities) {
                    objectOutputStream.writeObject(available);
                }
                objectOutputStream.close();
                fileOutputStream.close();
                System.out.println("Saved Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void loadAvailableConsultations() {
        try{
            FileInputStream fileInputStream = new FileInputStream("availableConsultations.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true){
                try{
                    Availability available = (Availability) objectInputStream.readObject();
                    Consultations.availabilities.add(available);
                }catch(Exception e){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadConsultations() {
        try{
            FileInputStream fileInputStream = new FileInputStream("Consultations.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true){
                try{
                    Consultations available = (Consultations) objectInputStream.readObject();
                    Consultations.consultations.add(available);
                }catch(Exception e){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveConsultations(){
        try {
            File file = new File("Consultations.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (Consultations available : Consultations.consultations) {
                    objectOutputStream.writeObject(available);
                }
                objectOutputStream.close();
                fileOutputStream.close();
                System.out.println("Saved Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public double pastConsultations(String pName){
        double cost = 0;
        if(Consultations.consultations.size() != 0){
            for(Consultations con : Consultations.consultations){
                String name = con.getPatient().getName() + " " + con.getPatient().getSurname();
                if(name.equals(pName)){
                    cost = 25;
                    break;
                }else{
                    cost = 15;
                }
            }
        }else{
            cost = 15;
        }
        return cost;
    }
}
