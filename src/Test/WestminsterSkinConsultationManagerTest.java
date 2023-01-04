package Test;

import Console.Doctor;
import Console.WestminsterSkinConsultationManager;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WestminsterSkinConsultationManagerTest {
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    void tearDown(){
        System.setOut(printStream);
    }

    @Test
    public void viewAllTheDetailsOfTheDoctors(){
        manager.loadData();
        assertTrue(Doctor.doctors.size() > 0);
        manager.viewDoctors(Doctor.doctors);
        assertEquals("""
                =========================================
                |       List of all the Doctors         |
                =========================================
                Medical License Number       : SWGOXX
                Doctor's Name                : Lily Anthony
                Date Of Birth                : Jun 6, 2001
                Gender                       : Female
                Doctor's Specialization      : Cosmetic Dermatology
                Doctor's Mobile Number       : 0772839238
                =======================================
                =======================================
                Medical License Number       : GNGErr
                Doctor's Name                : Emily Becker
                Date Of Birth                : Aug 8, 2001
                Gender                       : Female
                Doctor's Specialization      : Medical Dermatology
                Doctor's Mobile Number       : 0772389389
                =======================================
                =======================================
                Medical License Number       : KpUbyd
                Doctor's Name                : Zerka Benajmin
                Date Of Birth                : Dec 8, 1989
                Gender                       : Male
                Doctor's Specialization      : Paediatric Dermatology
                Doctor's Mobile Number       : 0721323234
                =======================================
                =======================================
                Medical License Number       : LdupOG
                Doctor's Name                : Daniel Brooke
                Date Of Birth                : Jul 8, 2000
                Gender                       : Male
                Doctor's Specialization      : Cosmetic Dermatology
                Doctor's Mobile Number       : 0783329039
                =======================================
                =======================================
                Medical License Number       : 2mLtuv
                Doctor's Name                : Monica Geller
                Date Of Birth                : Dec 9, 1998
                Gender                       : Female
                Doctor's Specialization      : Paediatric Dermatology
                Doctor's Mobile Number       : 0778932389
                =======================================
                =======================================
                Medical License Number       : si70y9
                Doctor's Name                : Racheal Greene
                Date Of Birth                : Feb 4, 1999
                Gender                       : Female
                Doctor's Specialization      : Medical Dermatology
                Doctor's Mobile Number       : 0778382948
                =======================================
                =======================================
                Medical License Number       : YEEj91
                Doctor's Name                : Ethan Hunt
                Date Of Birth                : May 2, 1990
                Gender                       : Male
                Doctor's Specialization      : Cosmetic Dermatology
                Doctor's Mobile Number       : 0778932389
                =======================================
                =======================================
                Medical License Number       : vZ8TiK
                Doctor's Name                : Micheal Peterson
                Date Of Birth                : Jun 5, 1997
                Gender                       : Male
                Doctor's Specialization      : Medical Dermatology
                Doctor's Mobile Number       : 0723892389
                =======================================
                =======================================
                Medical License Number       : GK6TdS
                Doctor's Name                : Ross Taylor
                Date Of Birth                : Apr 6, 1998
                Gender                       : Male
                Doctor's Specialization      : Cosmetic Dermatology
                Doctor's Mobile Number       : 0778932893
                =======================================
                =======================================
                Medical License Number       : 93bF9t
                Doctor's Name                : Amy White
                Date Of Birth                : Sep 9, 1990
                Gender                       : Female
                Doctor's Specialization      : Cosmetic Dermatology
                Doctor's Mobile Number       : 0763798389
                =======================================
                =======================================""", byteArrayOutputStream.toString());
    }

    @Test
    public void addADoctor() throws ParseException {
        String input = "Kevin\nPeterson\n02/12/1990\n0778938989\nMale\n1";
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Scanner scanner = new Scanner(inputStream);
        manager.addDoctor(Doctor.doctors, scanner);
        assertEquals(1, Doctor.doctors.size());
    }

    @Test
    public void deleteADoctor() throws ParseException {
        addADoctor();
        String doctorId = "";
        for(Doctor doctor: Doctor.doctors){
            doctorId = doctor.getMedicalLicenseNo();
        }
        byte[] bytes = doctorId.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Scanner scanner = new Scanner(inputStream);
        manager.deleteDoctor(Doctor.doctors, scanner);
        assertEquals(0, Doctor.doctors.size());
    }

    @Test
    public void addDoctorThrowsParseException(){
        String input = "Kevin\nPeterson\ndate\n0778938989\nMale\n1";
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Scanner scanner = new Scanner(inputStream);
        assertThrows(ParseException.class, () ->{
            manager.addDoctor(Doctor.doctors, scanner);
        });
    }

    @Test
    public void addDoctorThrowsArrayIndexOutOfBoundsException() throws ParseException {
        manager.loadData();
        String input = "Kevin\nPeterson\ndate\n0778938989\nMale\n1";
        byte[] bytes = input.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Scanner scanner = new Scanner(inputStream);
        manager.addDoctor(Doctor.doctors, scanner);
        assertNotEquals(11, Doctor.doctors.size());
    }
}