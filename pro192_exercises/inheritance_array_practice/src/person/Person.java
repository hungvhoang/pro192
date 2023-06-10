package person;

import java.util.Date;

public class Person {
    private String id;
    private String name;
    private Date birthDay;
    private boolean gender;

    public Person(){
        this.id="";
        this.name="";
        this.birthDay= new Date(1900,1,1);
    }
    public Person(String id,String name,Date birthDay,boolean gender){
        this.id=id;
        this.name=name;
        this.birthDay=birthDay;
        this.gender=gender;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
