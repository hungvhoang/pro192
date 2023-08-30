package person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String id;
    private String firstName;
    private String sureName;
    private Date birthDate;
    private boolean gender;
    private String phone;
    public Person() {
        this.id ="";
        this.firstName="";
        this.sureName="";
        this.birthDate=new Date(1900, 1, 1);
        this.phone="";
    }
    public Person(String id, String firstName, String sureName, Date birthDate, boolean gender, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSureName() {
        return sureName;
    }
    public void setSureName(String sureName) {
        this.sureName = sureName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("|%s|%s|%s|%s|%s|%s",getId(),getFirstName(),getSureName(),dateFormat.format(birthDate),(isGender())?"Male":"Female",getPhone());
    } 
}
