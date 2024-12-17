package HospitalManagementSystem;


import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    // will use access modifier and encap//

    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;

    }

    // methods //

    public void addPatient() {
        System.out.print("Enter Patient Name : ");

        String name = scanner.next();

        System.out.print("Enter Patient Age : ");

        int age = scanner.nextInt();

        System.out.printl("Enter Patient Gender : ");

        String gender = scanner.next();

        // blocks //
        try {
            String query = "INSERT INTO patient(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Patient Added Successfully !");
            } else {
                System.out.println("Failed to add Patient !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void viewPatient() {

        String query = "SELECT * FROM patients";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // what it does is : it holds the upcomming table from the db //
            // sets the pointer to it , named as next //
            // and then it keeps printing //

            ResultSet resultSet = preparedStatement.executeQuery();

            // for printing using format specifier so it does not use every variable //

            System.out.println("+------------+--------------------+----------+-----------+");
            System.out.println("| Patient Id | Name               | Age      | Gender    | ");
            System.out.println("+------------+--------------------+----------+-----------+");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");


                // for formatting the output //
                System.out.printf("|%-12s|%-20s|%-10s|%-12s|");
                System.out.println("+------------+--------------------+----------+-----------+");

            }


        } catch (SQLException e){
            e.printStackTrace();
        }
        }


    }
