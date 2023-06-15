package DTO.FPTUniversity;

import DTO.role.Role;
import DTO.university.University;

public class FPTUniversity extends University implements Role{
    private String address;
    FPTUniversity(){
        super();
        this.address="";
    }

    public FPTUniversity(int size, String name, String address) {
        super(size, name);
        this.address = address;
    } 

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void createWorker() {
        System.out.println("Providing human resources.");    
    }

    @Override
    public String toString() {
        return "FPT has four campuses Hanoi, HCM, Can Tho, Quy Nhon.";   
    }    

    
}
