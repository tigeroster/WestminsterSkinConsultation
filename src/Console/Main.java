package Console;

import GUI.GUIRunner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

public class Main{
    private static boolean mainMenu = true;
    private static boolean subMenu = true;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadData();

        System.out.println("""
                              =======================================================
                              |          Westminster Skin Consultations             |
                              =======================================================
                              |          Choose your option to proceed              |
                              |                                                     |
                              |         Press (1) -> Skin Consultation System       |
                              |         Press (2) -> Manager Console                |
                              |         Press (3) -> Exit                           |
                              |                                                     |
                              =======================================================""");
        try{
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
                              =======================================================
                              |          Welcome to the Manager's Console           |
                              =======================================================
                              |          Choose your option to proceed              |
                              |                                                     |
                              |         Press (1) -> Add a New Doctor               |
                              |         Press (2) -> Delete a Doctor                |
                              |         Press (3) -> View all Doctors               |
                              |         Press (4) -> Save all Data                  |
                              |         Press (5) -> Exit                           |
                              |                                                     |
                              =======================================================""");
                            int option = sc.nextInt();
                            switch (option) {
                                case 1 -> manager.addDoctor(Doctor.doctors, sc);
                                case 2 -> manager.deleteDoctor(Doctor.doctors,sc);
                                case 3 -> manager.viewDoctors(Doctor.doctors);
                                case 4 -> manager.saveData(Doctor.doctors);
                                case 5 -> System.exit(0);
                                default -> System.out.println("Invalid Input");
                            }
                            System.out.println("""
                              =======================================================
                              |   Would you like to continue with another option?   |
                              =======================================================
                              |          Choose your option to proceed              |
                              |                                                     |
                              |         Press (1)       -> Continue                 |
                              |         Press (Any key) -> Exit                     |
                              |                                                     |
                              =======================================================""");
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
        }catch(InputMismatchException e){
            System.out.println("Invalid Input");
        }

    }
}