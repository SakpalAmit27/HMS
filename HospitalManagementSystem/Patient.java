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




}
