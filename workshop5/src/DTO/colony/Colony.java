package DTO.colony;

import DTO.organization.Organization;

public class Colony extends Organization{
    private String place;
    //Constructor
    public Colony() {
        super();
        this.place="";
    }
    //Constructor with fields
    public Colony(int size, String place) {
        super(size);
        this.place = place;
    }
    
   //getter and setter 
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    //methods
    @Override
    public void comunitcateByTool() {
        System.out.println("This colony communicate by sound.");
    }
    
    public void grow(){
        System.out.println("An annual cycle of growth that begins in spring");
    }

    public void reproduce(){
        System.out.println("Colony can reproduce itself through a process.");
    }

    public String toString() {
        return "\nThe colony size is: "+getSize()
            +"\nThe colony's place is: "+getPlace();
    }
}
