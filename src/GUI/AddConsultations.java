package GUI;

import Console.*;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.security.Key;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;

import static Console.Doctor.doctors;
public class AddConsultations extends JFrame {
    JComboBox<Object> comboBox = new JComboBox<>();
    JComboBox<Object> comboBoxS = new JComboBox<>();
    public static File filePath;
    String consultationId;
    String id;
    String genderSelected;

    private final String[] time = {
            "09:00", "10:00", "11:00", "12:00", "01:00", "02:00", "03:00", "04:00", "05:00","06:00"
    };

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

        JLabel dateOfBirthL = new JLabel();
        dateOfBirthL.setSize(100,30);
        dateOfBirthL.setLocation(250,250);
        dateOfBirthL.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        c.add(dateOfBirthL);

        ImageIcon getDateOfBirthIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("calendar.png")));
        JButton getDob = new JButton(getDateOfBirthIcon);
        getDob.setFocusPainted(false);
        getDob.setSize(50,30);
        getDob.setLocation(350,250);
        c.add(getDob);
        getDob.addActionListener(e -> {
            if(e.getSource() == getDob){
                dateOfBirthL.setText(new DatePicker(this).setPickedDate());
            }
        });

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

        // NIC
        JLabel nicL = new JLabel("NIC Number");
        nicL.setFont(new Font("Arial", Font.PLAIN, 16));
        nicL.setSize(200, 20);
        nicL.setLocation(100, 350);
        c.add(nicL);

        JTextField nic = new JTextField();
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

        JLabel consultDateL = new JLabel();
        consultDateL.setSize(100,30);
        consultDateL.setLocation(750,200);
        consultDateL.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        c.add(consultDateL);

        JButton getConsultDate = new JButton(getDateOfBirthIcon);
        getConsultDate.setFocusPainted(false);
        getConsultDate.setSize(50,30);
        getConsultDate.setLocation(850,200);
        c.add(getConsultDate);
        getConsultDate.addActionListener(e -> {
            if(e.getSource() == getConsultDate){
                consultDateL.setText(new DatePicker(this).setPickedDate());
            }
        });

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

        // Upload a file
        JButton upload = new JButton("Upload a file");
        upload.setFocusPainted(false);
        upload.setSize(150,30);
        upload.setLocation(1010,300);
        c.add(upload);

        upload.addActionListener(e -> {
            JFileChooser fileUpload = new JFileChooser();
            int res = fileUpload.showOpenDialog(null);

            if(res == JFileChooser.APPROVE_OPTION){
                filePath = new File(fileUpload.getSelectedFile().getAbsoluteFile().toURI());
                System.out.println(filePath);
            }
        });

        try{
            book.addActionListener(e -> {
                if(tFirstname.getText().equals("")|| tSurname.getText().equals("") || comboBox.getSelectedItem() == null || comboBoxS.getSelectedItem() == null){
                    JOptionPane.showMessageDialog(this,"Please enter data to add a Consultation");
                }else{
                    String patientName = tFirstname.getText() + " " + tSurname.getText();
                    String doctorName = (String) comboBox.getSelectedItem();
                    String dateOfBirth = dateOfBirthL.getText();
                    String dateFormat = consultDateL.getText();
                    String spec = (String) comboBoxS.getSelectedItem();
                    String time = (String) comboBoxT.getSelectedItem();
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
                    if(Consultations.checkAvailability(Consultations.availabilities, doctorName, formatBox, spec, time)){
                        id = Helper.idGenerator(5);
                        consultationId = Helper.idGenerator(8);
                        genderSelected = getSelectedButtonText(gen);
                        Patient patient = new Patient(tFirstname.getText(), tSurname.getText(), dobBox,
                                tMobile.getText(), genderSelected, id, nic.getText());
                        Patient.patients.add(patient);
                        Consultations.availabilities.add(new Availability(doctorName,formatBox,
                                spec, time));
                        saveAvailableConsultations();
                        Consultations.consultations.add(new Consultations(consultationId, patient, doctorName,
                                jNotes.getText(), pastConsultations(patientName, nic.getText()), formatBox,
                                (String) comboBoxT.getSelectedItem()));
                        encrypt();
                        JOptionPane.showMessageDialog(this,"Consultation Added Successfully!");
                        tFirstname.setText("");
                        tSurname.setText("");
                        jNotes.setText("");
                        tMobile.setText("");
                        dateOfBirthL.setText("");
                        getConsultDate.setText("");
                    }else{
                        System.out.println("Else statement");
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

    public static void encrypt(){
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            SecretKey key = kg.generateKey();
            SecureRandom random = new SecureRandom();
            byte[] iv = new byte[16];
            random.nextBytes(iv);

            Cipher cipher = Cipher.getInstance(key.getAlgorithm() + "/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

            ObjectOutputStream oos = null;
            for (Consultations con : Consultations.consultations) {
                SealedObject sealedEm1 = new SealedObject(con, cipher);
                FileOutputStream fos = new FileOutputStream("encryptedConsultationData.aes");
                CipherOutputStream cos = new CipherOutputStream(fos, cipher);
                oos = new ObjectOutputStream(cos);
                oos.writeObject(sealedEm1);
            }
            assert oos != null;
            oos.close();

        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static void decrypt(){
        try{
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            SecretKey key = kg.generateKey();
            byte[] iv = new byte[16];
            Cipher cipher = Cipher.getInstance(key.getAlgorithm() + "/CBC/PKCS5Padding");
            cipher.init( Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));

            CipherInputStream cipherInputStream = new CipherInputStream(new BufferedInputStream(new FileInputStream("encryptedConsultationData.aes")), cipher );
            ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
            while(true){
                try{
                    SealedObject sealedObject = (SealedObject) inputStream.readObject();
                    Consultations consultations1 = (Consultations) sealedObject.getObject(cipher);
                    Consultations.consultations.add(consultations1);
                    System.out.println(consultations1.getConsultationId() + " " + consultations1.getDoctor());
                }catch(Exception ex){
                    ex.printStackTrace();
                    break;
                }
            }
            inputStream.close();
            System.out.println("Decryption works");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
