package DTO.tester;

import DTO.FPTUniversity.FPTUniversity;
import DTO.beeColony.BeeColony;
import DTO.colony.Colony;
import DTO.university.University;

public class Tester {
    public static void main(String[] args) {
        Colony obj1=new BeeColony(2000,"land","honey");
        System.out.println(obj1);
        obj1.grow();
        obj1. reproduce();
        
        University obj2=new FPTUniversity(100000,"FPT","Can Tho");
        System.out.println(obj2);
        obj2.enroll();
        obj2.educate();
        
    } 
}
