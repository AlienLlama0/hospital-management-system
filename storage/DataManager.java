package storage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import enums.BloodGroup;
import model.Patient;

import java.sql.*;

public class DataManager {
    public static List<Patient> patientList = new ArrayList<>();
    
    // Read the data from paitent file
    public static void loadData() {
        patientList.clear();

        try (Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM patient")) {

            while (rs.next()) {
                Patient p = new Patient(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("phone"),
                    rs.getString("gender"),
                    rs.getString("symptom"),
                    BloodGroup.valueOf(rs.getString("blood_group"))
                );

                patientList.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showData(){
        System.out.println("===================================================================================================");
        System.out.printf("| %-5s | %-20s | %-5s | %-13s | %-8s | %-13s | %-13s |%n", "ID", "NAME", "AGE", "PHONE", "GENDER", "SYMPTOM", "BLOODGROUP");
        System.out.println("===================================================================================================");
        for(Patient p : patientList){
            System.out.printf("| %-5s | %-20s | %-5d | %-13s | %-8s | %-13s | %-13s |%n", p.id, p.name, p.age, p.phone, p.gender, p.symptom, p.bloodGroup);
        }
        System.out.println("===================================================================================================");
    }
}
