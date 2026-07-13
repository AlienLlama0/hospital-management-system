package service;
import util.Input;
import storage.DataManager;
import model.Patient;
import enums.BloodGroup;

public class patientService {
    public static void create(){
       System.out.println("Enter your name: ");
       String name = Input.scanner.nextLine();
       System.out.println("Enter your id: ");
       String id = Input.scanner.nextLine();
       System.out.println("Enter your age: ");
       int age = Integer.parseInt(Input.scanner.nextLine());
       System.out.println("Enter your phone: ");
       String phone = Input.scanner.nextLine();
       System.out.println("Enter your gender: ");
       String gender = Input.scanner.nextLine();
       System.out.println("Enter your symptom: ");
       String symptom = Input.scanner.nextLine();
       System.out.println("Enter your bloodgroup: ");
       String blood = Input.scanner.nextLine();
       BloodGroup bloodgroup = BloodGroup.valueOf(blood);
       
       Patient patient = new Patient(id,name,age,phone,gender,symptom, bloodgroup);
       DataManager.patientList.add(patient);
       
    }
    public static void update(){
        System.out.println("");
    }
}
