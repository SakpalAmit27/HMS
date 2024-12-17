package HospitalManagementSystem;


import java.sql.Connection;
import java.util.Scanner;

public class Patient {
    // will use access modifier and encap//

    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection , Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;

    }

    // methods //

    public void addPatient(){
        System.out.print("Enter Patient Name : ");

        String name = scanner.next();

        System.out.print("Enter Patient Age : ");

        int age = scanner.nextInt();

        System.out.printl("Enter Patient Gender : ");

        String gender = scanner.next();

    }




}
