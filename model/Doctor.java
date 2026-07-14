package model;

public class Doctor extends Person{
    public String specialization;
    public double consultation_fee;

    public Doctor(String id, String name, int age, String phone, String gender, String specialization, double consultation_fee){
        super(id, name, age, phone, gender);
        
        this.specialization = specialization;
        this.consultation_fee = consultation_fee;
    }
}
