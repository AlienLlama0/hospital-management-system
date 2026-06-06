package model;
import enums.BloodGroup;

public class Patient extends Person{
    public String symptom;
    public BloodGroup bloodGroup;
    
    public Patient(String id, String name, int age, String phone, String gender, String symptom, BloodGroup bloodGroup){
        super(id, name, age, phone, gender);
        
        this.symptom = symptom;
        this.bloodGroup = bloodGroup;
    }
}