package model;

abstract class Person {
    public String id;
    public String name;
    public int age;
    public String phone;
    public String gender;

    Person(String id, String name, int age, String phone, String gender){
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }
}
