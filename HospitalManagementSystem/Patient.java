package HospitalManagementSystem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        // blocks //
        try{
            String query = "INSERT INTO patient(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);

            int affectedRows = preparedStatement.executeUpdate();

            if(affectedRows > 0){
                System.out.println("Patient Added Successfully !");
            }
            else{
                System.out.println("Failed to add Patient !");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }




}
