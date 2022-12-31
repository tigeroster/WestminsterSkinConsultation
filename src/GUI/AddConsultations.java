package GUI;

import Console.*;
import datechooser.model.DateChoose;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static Console.Doctor.doctors;
public class AddConsultations extends JFrame {
    JComboBox<Object> comboBox = new JComboBox<>();
    JComboBox<Object> comboBoxS = new JComboBox<>();
    JComboBox<String> comboBoxT;
    public static File filePath;
    ButtonGroup gen;
    String id, genderSelected, consultationId,doctorName, spec, time, patientName,imageRefPath;
    JTextField dobPicker;
    JTextArea jNotes;
    JTextField consultDatePicker,tFirstname, tSurname, tMobile, nic;
    Date formatBox, dobBox;
    JButton book;
    private final String[] timeList = {
            "09:00", "10:00", "11:00", "12:00", "01:00", "02:00", "03:00", "04:00", "05:00","06:00"
    };

    public String[] getTime() {
        return timeList;
    }

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public AddConsultations(){
        Container c = getContentPane();
        c.setLayout(null);
        // Components
        JLabel title = new JLabel("Book a Consultation");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300,30);
        title.setLocation(450,30);
        c.add(title);

        // Home button
        ImageIcon homeIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("home1.png")));
        JButton home = new JButton(homeIcon);
        home.setSize(30,30);
        home.setFocusPainted(false);
        home.setLocation(50,20);
        home.addActionListener(e -> {
            dispose();
            new Home();
        });
        c.add(home);

        // View Consultations
        JButton viewConsultations = new JButton("All Consultations");
        viewConsultations.setFocusPainted(false);
        viewConsultations.setSize(170,30);
        viewConsultations.setLocation(1000,30);
        try{
            viewConsultations.addActionListener(e -> {
                dispose();
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

        tFirstname = new JTextField();
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
        dobPicker.setFont(new Font("Arial", Font.PLAIN, 15));
        dobPicker.setSize(100, 30);
        dobPicker.setLocation(250, 250);
        JButton dobButton = new JButton();
        dobButton.setFocusPainted(false);
        dobButton.setSize(50,30);
        dobButton.setLocation(350,250);
        dobButton.addActionListener(e-> {
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
        nic.setFont(new Font("Arial", Font.PLAIN, 15));
        nic.setSize(250, 30);
        nic.setLocation(250, 350);
        c.add(nic);

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

        consultDatePicker = new JTextField();
        consultDatePicker.setFont(new Font("Arial", Font.PLAIN, 15));
        consultDatePicker.setSize(100, 30);
        consultDatePicker.setLocation(750, 200);
        JButton consultDateButton = new JButton();
        consultDateButton.setSize(50,30);
        consultDateButton.setLocation(850,200);
        c.add(consultDateButton);
        consultDateButton.addActionListener(e-> {
            consultDatePicker.setText(new DatePicker(this).setPickedDate());
        });
        c.add(consultDatePicker);

        // Consultation Time
        JLabel consultTime = new JLabel("Booking Time");
        consultTime.setFont(new Font("Arial", Font.PLAIN, 16));
        consultTime.setSize(200, 20);
        consultTime.setLocation(600, 250);
        c.add(consultTime);
        comboBoxT = new JComboBox<>(timeList);
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

        jNotes = new JTextArea();
        jNotes.setFont(new Font("Arial", Font.PLAIN, 15));
        jNotes.setSize(250, 100);
        jNotes.setLocation(750, 300);
        jNotes.setLineWrap(true);
        jNotes.setWrapStyleWord(true);
        jNotes.setAutoscrolls(true);
        c.add(jNotes);

        // Book a consultation button
        book = new JButton("Book");
        book.setFocusPainted(false);
        book.setSize(100,30);
        book.setLocation(600,350);

        // Upload a file
        JButton upload = new JButton("Upload a file");
        upload.setFocusPainted(false);
        upload.setSize(150,30);
        upload.setLocation(1010,300);
        c.add(upload);

        JLabel success = new JLabel();
        success.setSize(150,30);
        success.setLocation(1010,320);
        c.add(success);

        upload.addActionListener(e -> {
            JFrame imageUploadFrame = new JFrame("Upload Image For Consultation");
            FileDialog imageFileDialog = new FileDialog(imageUploadFrame, "Open", FileDialog.LOAD);
            imageFileDialog.setVisible(true);
            imageRefPath = imageFileDialog.getDirectory() + imageFileDialog.getFile();
            success.setText("File Uploaded");
        });

        try{
            book.addActionListener(e -> {
                if(tFirstname.getText().equals("")|| tSurname.getText().equals("") || comboBox.getSelectedItem() == null || comboBoxS.getSelectedItem() == null){
                    JOptionPane.showMessageDialog(this,"Please enter data to add a Consultation");
                }else{
                    patientName = tFirstname.getText() + " " + tSurname.getText();
                    doctorName = (String) comboBox.getSelectedItem();
                    String dateOfBirth = dobPicker.getText();
                    String dateFormat = consultDatePicker.getText();
                    spec = (String) comboBoxS.getSelectedItem();
                    time = (String) comboBoxT.getSelectedItem();
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
                    if(Consultations.checkAvailability(Consultations.availabilities, doctorName, formatBox, spec,
                            time)){
                        addPatientConsultation(doctorName);
                        JOptionPane.showMessageDialog(this,"Consultation Added Successfully!");
                    }else{
                        for(Doctor doc : doctors){
                            String doctor = doc.getName() + " " + doc.getSurname();
                            if(!doctor.equals(doctorName) && doc.getSpecialization().equals(spec)){
                                if(Consultations.checkAvailability(Consultations.availabilities, doctor, formatBox,
                                        spec, time)){
                                    addPatientConsultation(doctor);
                                    JOptionPane.showMessageDialog(this,
                                            "Dr. " + doctorName + " is not available. Consultation is added to Dr. " + doctor);
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(this, "No Doctor is available in that Date/Time " +
                                            "slot." +
                                            " " +
                                            "Please select a different Time Slot/Date");
                                }
                            }
                        }
                    }
                }
            });
        }catch(RuntimeException runtimeException){
            runtimeException.printStackTrace();
        }
        c.add(book);
        setTitle("Add a Consultation");
        setSize(1200, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public static void saveConsultations(){
        try {
            File file = new File("Consultations.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (Consultations consultations : Consultations.consultations) {
                    objectOutputStream.writeObject(consultations);
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

    public static void loadConsultations() {
        try{
            FileInputStream fileInputStream = new FileInputStream("Consultations.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true){
                try{
                    Consultations consultation = (Consultations) objectInputStream.readObject();
                    Consultations.consultations.add(consultation);
                }catch(Exception e){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public double pastConsultations(String pName, String nic){
        double cost = 0;
        if(Consultations.consultations.size() != 0){
            for(Consultations con : Consultations.consultations){
                String name = con.getPatient().getName() + " " + con.getPatient().getSurname();
                if(name.equals(pName) && con.getPatient().getNic().equals(nic)){
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

    public static String encrypt(String notes){
        int key = 6;
        StringBuilder encryptedText = new StringBuilder();
        char[] charsForEncryption = notes.toCharArray();
        for(char c : charsForEncryption){
            c += key;
            encryptedText.append(c);
        }
        System.out.println(encryptedText);
        return encryptedText.toString();
    }

    public static String decrypt(String notes){
        int key = 6;
        StringBuilder decryptedText = new StringBuilder();
        char[] charsForEncryption = notes.toCharArray();
        for(char c : charsForEncryption){
            c -= key;
            decryptedText.append(c);
        }
        System.out.println(decryptedText);
        return decryptedText.toString();
    }

    public void addPatientConsultation(String doctorNamePass){
        id = Helper.idGenerator(5);
        consultationId = Helper.idGenerator(8);
        genderSelected = getSelectedButtonText(gen);
        Patient patient = new Patient(tFirstname.getText(), tSurname.getText(), dobBox,
                tMobile.getText(), genderSelected, id, nic.getText());
        Patient.patients.add(patient);
        Consultations.availabilities.add(new Availability(doctorNamePass,formatBox,
                spec, time));
        saveAvailableConsultations();
        Notes notes = new Notes(encrypt(jNotes.getText()), imageRefPath);
        Consultations.consultations.add(new Consultations(consultationId, patient, doctorNamePass,
                notes, pastConsultations(patientName, nic.getText()), formatBox,
                (String) comboBoxT.getSelectedItem()));
        saveConsultations();
        tFirstname.setText("");
        tSurname.setText("");
        jNotes.setText("");
        tMobile.setText("");
        nic.setText("");
        dobPicker.setText("");
        consultDatePicker.setText("");
    }
}
