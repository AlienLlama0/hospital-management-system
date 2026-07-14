package storage;
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
                    rs.getString("patient_id"),
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

    public static void addPatient(Patient p) {
        String sql = "INSERT INTO patient(patient_id, name, age, phone, gender, symptom, blood_group) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.id);
            ps.setString(2, p.name);
            ps.setInt(3, p.age);
            ps.setString(4, p.phone);
            ps.setString(5, p.gender);
            ps.setString(6, p.symptom);
            ps.setString(7, p.bloodGroup.name());

            ps.executeUpdate();

            patientList.add(p);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePatient(Patient p) {
        String sql = """
            UPDATE patient
            SET name = ?, age = ?, phone = ?, gender = ?, symptom = ?, blood_group = ?
            WHERE patient_id = ?
            """;

        try (Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.name);
            ps.setInt(2, p.age);
            ps.setString(3, p.phone);
            ps.setString(4, p.gender);
            ps.setString(5, p.symptom);
            ps.setString(6, p.bloodGroup.name());
            ps.setString(7, p.id);

            ps.executeUpdate();

            for (int i = 0; i < patientList.size(); i++) {
                if (patientList.get(i).id.equals(p.id)) {
                    patientList.set(i, p);
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient(String id) {
        String sql = "DELETE FROM patient WHERE patient_id = ?";

        try (Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

            patientList.removeIf(patient -> patient.id.equals(id));

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
    public static void filterData(Patient p){
        System.out.println("===================================================================================================");
        System.out.printf("| %-5s | %-20s | %-5s | %-13s | %-8s | %-13s | %-13s |%n", "ID", "NAME", "AGE", "PHONE", "GENDER", "SYMPTOM", "BLOODGROUP");
        System.out.println("===================================================================================================");
        
        System.out.printf("| %-5s | %-20s | %-5d | %-13s | %-8s | %-13s | %-13s |%n", p.id, p.name, p.age, p.phone, p.gender, p.symptom, p.bloodGroup);
        
        System.out.println("===================================================================================================");
    }
}
