package DTO.beeColony;

import DTO.colony.Colony;
import DTO.role.Role;

public class BeeColony extends Colony implements Role{
    private String type;

    public BeeColony() {
        super();
        this.type = "";
    }

    public BeeColony(int size, String place, String type) {
        super(size, place);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    @Override
    public String toString() {
        return "The colony's type is: "+ getType() 
            +super.toString();
    }

    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees.");
    }
    
}
