package service;

import enums.BloodGroup;
import model.Patient;
import storage.DataManager;
import util.Input;

public class DoctorService {
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
        System.out.println("Enter your specialization: ");
        String specialization = Input.scanner.nextLine();
        System.out.println("Enter your consultation_fee: ");
        double consultation_fee = Double.parseDouble(Input.scanner.nextLine());

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
        System.out.println("5.Specialization");
        System.out.println("6.Consultation_fee");

        System.out.println("Enter your option: ");
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
                String specialization = Input.scanner.nextLine();
                p.specialization = specializtion;
                break;
            case 6:
                String consultation_fee = Input.scanner.nextLine();
                p.consultation_fee = consultation_fee; 
                break;
            default:
                System.out.println("Invalid option!");
        }
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
        DataManager.filterData(b);
    }
    public static void delete(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        Patient c = null;
        for(int i = 0;i < DataManager.patientList.size();i++){
            if(id.equals(DataManager.patientList.get(i).id)){
                c = DataManager.patientList.get(i);
                break;
            }
        }
        if(c == null){
           System.out.println("Patient is not found");
           return; 
        }
        DataManager.deletePatient(id);
        System.out.println("id is deleted!!\n");
    }t
}
