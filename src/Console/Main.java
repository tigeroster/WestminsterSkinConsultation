package Console;

import GUI.GUIRunner;

import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

public class Main{
    private static boolean mainMenu = true;
    private static boolean subMenu = true;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadData(Doctor.doctors);

        System.out.println("""
                Welcome to Westminster Skin Consultations
                Choose your option to proceed
                1 : Skin Consultation System
                2 : Manager Console
                3 : Exit""");
        int mainOpt = sc.nextInt();
        if(mainOpt == 1){
            System.out.println("Loading GUI...");
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    GUIRunner.main();
                    System.out.println("GUI loaded Successfully");
                }
            };
            timer.schedule(task, 1500);

        }else if(mainOpt == 3){
            System.exit(0);
        }else{
            while(mainMenu){
                while(subMenu){
                    try{
                        System.out.println("""
                Please select your option to continue
                1: Add a new Doctor
                2: Delete a Doctor
                3: Print the list of the doctors
                4: Save data
                5: Find Doctor Details
                6: Exit""");
                        int option = sc.nextInt();
                        switch (option) {
                            case 1 -> manager.addDoctor(Doctor.doctors);
                            case 2 -> manager.deleteDoctor(Doctor.doctors);
                            case 3 -> manager.viewDoctors(Doctor.doctors);
                            case 4 -> manager.saveData(Doctor.doctors);
                            case 5 -> manager.findDoctorDetails(Doctor.doctors);
                            case 6 -> System.exit(0);
                            default -> System.out.println("Invalid Input");
                        }
                        System.out.println("""
                        Would you like to continue with another option?
                         1: Enter 1 to continue
                         2: Enter any number to exit""");
                        if(sc.nextInt() == 1){
                            subMenu = true;
                        }else{
                            subMenu = false;
                            System.exit(0);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}