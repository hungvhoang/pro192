package teacher;

import java.text.SimpleDateFormat;
import java.util.Date;

import person.Person;

public class Teacher extends Person{
    private String subject;
    private double salary;
    public Teacher() {
        super();
        this.subject="";
    }
    public Teacher(String id, String name, Date birthDay, boolean gender, String subject, double salary) {
        super(id, name, birthDay, gender);
        this.subject = subject;
        this.salary = salary;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| |%-30s|%8s|%10s|%8s|%10s|%10.1f|",this.getName(),this.getId(),format.format(this.getBirthDay()),(this.isGender()?"Male":"Female"),this.subject,this.salary);
    }
}
