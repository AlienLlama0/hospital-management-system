package storage;

import java.sql.*;

import enums.BloodGroup;
import model.Doctor;
import model.Patient;

public class DoctorRepository {
    public static void loadDoctor(){
        DataManager.doctorList.clear();

        try (Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM doctor")) {

            while (rs.next()) {
                Doctor p = new Doctor(
                    rs.getString("doctor_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("phone"),
                    rs.getString("gender"),
                    rs.getString("specialization"),
                    rs.getDouble("consultation_fee")
                );

                DataManager.doctorList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDoctor(Doctor d){
        String sql = "INSERT INTO doctor(doctor_id, name, age, phone, gender, specialization, consultation_fee) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.id);
            ps.setString(2, d.name);
            ps.setInt(3, d.age);
            ps.setString(4, d.phone);
            ps.setString(5, d.gender);
            ps.setString(6, d.specialization);
            ps.setDouble(7, d.consultation_fee);

            ps.executeUpdate();

            DataManager.doctorList.add(d);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor d){
        String sql = "UPDATE doctor SET name = ?, age = ?, phone = ?, gender = ?, specialization = ?, consultation_fee = ? WHERE doctor_id = ?";

        try (Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.name);
            ps.setInt(2, d.age);
            ps.setString(3, d.phone);
            ps.setString(4, d.gender);
            ps.setString(5, d.specialization);
            ps.setDouble(6, d.consultation_fee);
            ps.setString(7, d.id);

            ps.executeUpdate();

            for(int i = 0; i < DataManager.doctorList.size();i++){
                if(DataManager.doctorList.get(i).id.equals(d.id)){
                    DataManager.doctorList.set(i, d);
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctor(String id){
        String sql = "DELETE FROM doctor WHERE doctor_id = ?";

        try (Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

            DataManager.doctorList.removeIf(doctor -> doctor.id.equals(id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void doctorShowData(){
        System.out.println("===================================================================================================");
        System.out.printf("| %-5s | %-20s | %-5s | %-13s | %-8s | %-13s | %-13s |%n", "ID", "NAME", "AGE", "PHONE", "GENDER", "SPECIALIZATION", "CONSULTATION_FEE");
        System.out.println("===================================================================================================");
        for(Doctor d : DataManager.doctorList){
            System.out.printf("| %-5s | %-20s | %-5d | %-13s | %-8s | %-13s | %-13s |%n", d.id, d.name, d.age, d.phone, d.gender, d.specialization, d.consultation_fee);
        }
        System.out.println("===================================================================================================");
    }
    public static void doctorFilterData(Doctor d){
        System.out.println("===================================================================================================");
        System.out.printf("| %-5s | %-20s | %-5s | %-13s | %-8s | %-13s | %-13s |%n", "ID", "NAME", "AGE", "PHONE", "GENDER", "SPECIALIZATION", "CONSULTATION_FEE");
        System.out.println("===================================================================================================");
        
        System.out.printf("| %-5s | %-20s | %-5d | %-13s | %-8s | %-13s | %-13s |%n", d.id, d.name, d.age, d.phone, d.gender, d.specialization, d.consultation_fee);
        
        System.out.println("===================================================================================================");
    }
}
