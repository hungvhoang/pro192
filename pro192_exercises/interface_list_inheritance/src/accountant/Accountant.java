package accountant;

import java.util.Date;

import person.Person;
import working.Working;

public class Accountant extends Person implements Working{
    private double basicSalary;
    private int reward;
    
    public Accountant() {
        super();
    }

    public Accountant(String id, String firstName, String sureName, Date birthDate, boolean gender, String phone, double basicSalary, int reward) {
        super(id, firstName, sureName, birthDate, gender, phone);
        this.basicSalary = basicSalary;
        this.reward = reward;
    }

public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Override
    public double earnMoney() {
        return this.basicSalary+this.reward;
    }

    @Override
    public double tax() {
       double tax=0.0;
       if(this.earnMoney()>=3000) tax = this.earnMoney()*0.25 + (2999*0.1);
       else if(this.earnMoney()>=1000) tax = this.earnMoney()*0.1;
       return tax;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|%.3f|%s|",this.basicSalary,this.reward);
    }
    
    
}
