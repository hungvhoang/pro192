package DTO.university;

import DTO.organization.Organization;

public class University extends Organization{
    private String name;
  
    public University() {
        super();
        this.name="";
    }
    
    public University(int size, String name) {
        super(size);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void comunitcateByTool() {
        System.out.println("In the university, people communication by voice.");
    }
    
    public void enroll() {
        System.out.println("The registration for enrollment is only valid when the University has received all enrollment documents and enrollment fees.");
    }

    public void educate() {
        System.out.println("Provide education at university standard.");
    }

    public String toString(){
        return "Encourage the advancement and development of knowlegde.";
    }
}
