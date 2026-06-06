package storage;
import java.util.ArrayList;
import java.util.List;
import enums.BloodGroup;
import model.Patient;

public class DataManager {
    static List<Patient> paitentList = new ArrayList<>();
    
    // Read the data from paitent file
    public static void loadData(){
        List<String> data = FileHandler.readPatientFile();
        for(String d : data){
            String[] fields = d.split("[|]");
            // https://stackoverflow.com/questions/28704593/setting-an-enum-from-user-input
            Patient p = new Patient(fields[0], fields[1], Integer.parseInt(fields[2]), fields[3], fields[4], fields[5], BloodGroup.valueOf(fields[6])); // https://stackoverflow.com/questions/28704593/setting-an-enum-from-user-input
            paitentList.add(p);
        }
    }

    public static void showData(){
        System.out.println("===================================================================================================");
        System.out.printf("| %-5s | %-20s | %-5s | %-13s | %-8s | %-13s | %-13s |%n", "ID", "NAME", "AGE", "PHONE", "GENDER", "SYMPTOM", "BLOODGROUP");
        System.out.println("===================================================================================================");
        for(Patient p : paitentList){
            System.out.printf("| %-5s | %-20s | %-5d | %-13s | %-8s | %-13s | %-13s |%n", p.id, p.name, p.age, p.phone, p.gender, p.symptom, p.bloodGroup);
        }
        System.out.println("===================================================================================================");
    }
}
