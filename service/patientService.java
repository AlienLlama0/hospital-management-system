package service;
import util.Input;
import storage.DataManager;
import model.Patient;
import enums.BloodGroup;

public class patientService {
    void create(){
       String name = Input.scanner.nextLine();
       String id = Input.scanner.nextLine();
       int age = Input.scanner.nextInt();
       int phone = Input.scanner.nextInt();
       String gender = Input.scanner.nextLine();
       String symptom = Input.scanner.nextLine();
       BloodGroup bloodgroup = BloodGroup.AB_NEG;
       
       Patient patient = new Patient(id,name,age,phone,gender,symptom,BloodGroup bloodgroup);
       
    }
}
