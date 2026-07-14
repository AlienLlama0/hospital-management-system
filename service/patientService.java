package service;
import util.Input;
import storage.DataManager;
import storage.PatientRepository;
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
       PatientRepository.addPatient(patient);
       System.out.println("Patient id is created.\n");
    }

    public static void update(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        Patient p = null;
        for(int i = 0;i < DataManager.patientList.size();i++){
            if(id.equals(DataManager.patientList.get(i).id)){
                p = DataManager.patientList.get(i);
                break;
            }
        }
        if(p == null){
            System.out.println("Patient is not found");
            return;
        }
        System.out.println("1.Name");
        System.out.println("2.AGE");
        System.out.println("3.Phone");
        System.out.println("4.Gender");
        System.out.println("5.Symptom");
        System.out.println("6.Blood Group");

        
        int option = Integer.parseInt(Input.scanner.nextLine());
        switch(option){
            case 1:
                String name = Input.scanner.nextLine();
                p.name = name;
                break;
            case 2:
                int age = Integer.parseInt(Input.scanner.nextLine());
                p.age = age;
                break;
            case 3:
                String phone = Input.scanner.nextLine();
                p.phone = phone;
                break;
            case 4:
                String gender = Input.scanner.nextLine();
                p.gender = gender;
                break;
            case 5:
                String symptom = Input.scanner.nextLine();
                p.symptom = symptom;
                break;
            case 6:
                String blood = Input.scanner.nextLine();
                p.bloodGroup = BloodGroup.valueOf(blood); 
                break;
            default:
                break;
        }
        PatientRepository.updatePatient(p);
        System.out.println("Patient id is updated.\n");
    }
    public static void read(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        Patient b = null;
        for(int i = 0;i < DataManager.patientList.size();i++){
            if(id.equals(DataManager.patientList.get(i).id)){
                b = DataManager.patientList.get(i);
                break;
            }
        }
        if(b == null){
            System.out.println("Patient is not found");
            return;
        }
        PatientRepository.patientFilterData(b);
    }
    public static void delete(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        PatientRepository.deletePatient(id);
        System.out.println("id is deleted!!\n");
    }
}
