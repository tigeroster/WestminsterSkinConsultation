package Console;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    public String specialization = null;
    @Override
    public void addDoctor(ArrayList<Doctor> doctors) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter the doctor's Firstname: ");
            String firstName = sc.nextLine();
            System.out.println("Enter the doctor's Surname");
            String surname = sc.nextLine();
            System.out.println("Enter the doctor's Date of Birth: ");
            String doctorDob = sc.nextLine();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dob = dateFormatter.parse(doctorDob);

            System.out.println("Enter the doctor's Mobile Number: ");
            String mobile = sc.nextLine();

            System.out.println("Enter the Doctor's Gender: ");
            String gender = sc.nextLine();

            String medicalNumber = Helper.idGenerator(6);
            System.out.println("List of Specializations\n");
            for(int i = 0; i< Doctor.specializationNames.length; i++){
                System.out.println(i + 1 + " - " + Doctor.specializationNames[i]);
            }
            boolean loop = true;
            while(loop){
                try{
                    System.out.println("\nEnter the Doctor's Specialization ID: ");
                    int specializationId = sc.nextInt();

                    switch (specializationId){
                        case 1 -> {
                            specialization = "Dermatology";
                            loop = false;
                        }
                        case 2 -> {
                            specialization = "Internal medicine";
                            loop = false;
                        }
                        case 3 -> {
                            specialization = "Neurology";
                            loop = false;
                        }
                        case 4 -> {
                            specialization = "Psychiatry";
                            loop = false;
                        }
                        case 5 -> {
                            specialization = "Surgery";
                            loop = false;
                        }
                        case 6 -> {
                            specialization = "General Practitioner";
                            loop = false;
                        }
                        default -> {
                            System.out.println("Invalid ID Number");
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }
            Doctor doctor = new Doctor(firstName, surname, dob, mobile, medicalNumber, specialization, gender);
            doctors.add(doctor);
            System.out.println("Doctor " + doctor.getName() + " " + doctor.getSurname() + " is added successfully!\n");
        }catch (ParseException parseException){
            System.out.println("Something is wrong. Please check the inputs you entered");
        }catch(ArrayIndexOutOfBoundsException outOfBoundsException){
            System.out.println();
        }
    }

    @Override
    public void viewDoctors(ArrayList<Doctor> doctors) {
        if(doctors.size() != 0){
            System.out.println("List of all the doctors\n");
            doctors.sort(Comparator.comparing(Person::getSurname));
            for (Doctor doctor : doctors) {
                System.out.println("======================================");
                System.out.println("======================================");
                System.out.println("Medical License Number: " + doctor.getMedicalLicenseNo());
                System.out.println("Doctor's Name: " + doctor.getName() + " " + doctor.getSurname());
                System.out.println("Date Of Birth: " + String.format("%1$tb %1$te, %1$tY", doctor.getDateOfBirth()));
                System.out.println("Gender: " +doctor.getGender());
                System.out.println("Doctor's Specialization: " + doctor.getSpecialization());
                System.out.println("Doctor's Mobile Number: " + doctor.getMobileNumber());
                System.out.println("=======================================");
                System.out.println("=======================================");
            }
        }else{
            System.out.println("No Doctors to be found!\n");
        }
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> doctors) {
        Scanner sc = new Scanner(System.in);
        viewDoctors(doctors);
        if(doctors.size() != 0){
            System.out.println("Enter the medical license number:");
            String number = sc.nextLine();
            for(int i = 0; i<doctors.size(); i++)
            {
                if(number.equals(doctors.get(i).getMedicalLicenseNo())){
                    doctors.remove(doctors.get(i));
                    System.out.println("Doctor deleted successfully!\n");
                    break;
                }else{
                    System.out.println("No doctor to be found!\n");
                }
            }
        }else{
            System.out.println("Please add Doctors to the system\n");
        }
    }

    @Override
    public void saveData(ArrayList<Doctor> doctors) {
        try {
            File file = new File("doctorData.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (Doctor doctorNew : doctors) {
                    objectOutputStream.writeObject(doctorNew);
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

    @Override
    public void loadData(ArrayList<Doctor> doctors) {
        try{
            FileInputStream fileInputStream = new FileInputStream("doctorData.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true){
                try{
                    Doctor doctor = (Doctor) objectInputStream.readObject();
                    doctors.add(doctor);
                }catch(Exception e){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findDoctorDetails(ArrayList<Doctor> doctors){
        Scanner sc = new Scanner(System.in);
        for(Doctor doctor:  doctors){
            System.out.println("Medical License Number: " + doctor.getMedicalLicenseNo());
            System.out.println("Doctor's Name: " + doctor.getName());
            System.out.println("=======================================");
        }
        try{
            System.out.println("Enter the Doctor's Medical License Number: ");
            String number = sc.nextLine();
            for(Doctor doctor: doctors){
                if(number.equals(doctor.getMedicalLicenseNo())){
                    System.out.println("======================================");
                    System.out.println("======================================");
                    System.out.println("Medical License Number: " + doctor.getMedicalLicenseNo());
                    System.out.println("Doctor's Name: " + doctor.getName() + " " + doctor.getSurname());
                    System.out.println("Date Of Birth: " + String.format("%1$tb %1$te, %1$tY", doctor.getDateOfBirth()));
                    System.out.println("Gender: " + doctor.getGender());
                    System.out.println("Doctor's Specialization: " + doctor.getSpecialization());
                    System.out.println("Doctor's Mobile Number: " + doctor.getMobileNumber());
                    System.out.println("=======================================");
                    System.out.println("=======================================");
                }else{
                    System.out.println("No doctors to be found");
                }
            }
        }catch(Exception exception){
            System.out.println("Something is wrong. Please try again!");
        }

    }

}
