package service;

import enums.BloodGroup;
import model.Patient;
import storage.DataManager;
import util.Input;
import storage.DoctorRepository;
import model.Doctor;

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
        
        Doctor doctor = new Doctor(id,name,age,phone,gender,specialization,consultation_fee);
        DoctorRepository.addDoctor(doctor);
        System.out.println("Doctor id is created.\n");

    }
    public static void update(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        Doctor d = null;
        for(int i = 0;i < DataManager.doctorList.size();i++){
            if(id.equals(DataManager.doctorList.get(i).id)){
                d = DataManager.doctorList.get(i);
                break;
            }
        }
        if(d == null){
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
            System.out.println("Enter your name: ");    
            String name = Input.scanner.nextLine();
                d.name = name;
                break;
            case 2:
            System.out.println("Enter your age: ");     
            int age = Integer.parseInt(Input.scanner.nextLine());
                d.age = age;
                break;
            case 3:
            System.out.println("Enter your phone number: ");    
            String phone = Input.scanner.nextLine();
                d.phone = phone;
                break;
            case 4:
            System.out.println("Enter your gender: ");    
            String gender = Input.scanner.nextLine();
                d.gender = gender;
                break;
            case 5:
            System.out.println("Enter your specialization: ");    
            String specialization = Input.scanner.nextLine();
                d.specialization = specialization;
                break;
            case 6:
            System.out.println("Enter your consultation_fee: ");    
            double consultation_fee = Double.parseDouble(Input.scanner.nextLine());
                d.consultation_fee = consultation_fee; 
                break;
            default:
                System.out.println("Invalid option!");
        }
        DoctorRepository.updateDoctor(d);
        System.out.println("Doctor id id updated.\n");
    }
    public static void read(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        Doctor b = null;
        for(int i = 0;i < DataManager.doctorList.size();i++){
            if(id.equals(DataManager.doctorList.get(i).id)){
                b = DataManager.doctorList.get(i);
                break;
            }
        }
        if(b == null){
            System.out.println("Doctor id is not found");
            return;
        }
        DoctorRepository.doctorFilterData(b);
    }
    public static void delete(){
        System.out.println("Enter you id please: ");
        String id = Input.scanner.nextLine();
        Doctor c = null;
        for(int i = 0;i < DataManager.doctorList.size();i++){
            if(id.equals(DataManager.doctorList.get(i).id)){
                c = DataManager.doctorList.get(i);
                break;
            }
        }
        if(c == null){
           System.out.println("Doctor id is not found.\n");
           return; 
        }
        DoctorRepository.deleteDoctor(id);
        System.out.println("id is deleted!!\n");
    }
}
