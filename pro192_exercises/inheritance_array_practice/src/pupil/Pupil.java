package pupil;

import java.text.SimpleDateFormat;
import java.util.Date;

import person.Person;

public class Pupil extends Person {
    private String level;
    private double scored;
    public Pupil() {
        super();
    }
    public Pupil(String id, String name, Date birthDay, boolean gender, String level, double scored) {
        super(id, name, birthDay, gender);
        this.level = level;
        this.scored = scored;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public double getScored() {
        return scored;
    }
    public void setScored(double scored) {
        this.scored = scored;
    }
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| |%-30s|%8s|%10s|%8s|%5s|%5.1f|",this.getName(),this.getId(),format.format(this.getBirthDay()),(this.isGender()?"Male":"Female"),this.level,this.scored);
    }
    public String evaluate(){
        return (this.scored<5)?"Bad" :(this.scored>=8)? "Good" : "Average"; 
    }
}
