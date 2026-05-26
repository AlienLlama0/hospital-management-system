package model;
import enums.BloodGroup;

abstract class Patient extends Person{
    private BloodGroup bloodGroup;
    private String emergencyContact;
    private String emergencyName;
}