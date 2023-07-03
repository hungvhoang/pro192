package models;

import java.io.Serializable;

public class Car implements Serializable,Comparable{
    String carID="";
    Brand brand=null;
    String color="";
    String frameID="";
    String engineID="";
    public Car() {
    }
    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }
    public String getCarID() {
        return carID;
    }
    public void setCarID(String carID) {
        if(!carID.isBlank())
        this.carID = carID;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if(!color.isBlank())
        this.color = color.trim().toLowerCase();
    }
    public String getFrameID() {
        return frameID;
    }
    public void setFrameID(String frameID) {
        if(!frameID.isBlank())
        this.frameID = frameID.toUpperCase();
    }
    public String getEngineID() {
        return engineID;
    }
    public void setEngineID(String engineID) {
        if(!engineID.isBlank())
        this.engineID = engineID.toUpperCase();
    }
    
    public String toString(){
        return String.format("|%8s|%32s|%9s|%12s|%13s|",carID,brand.getBrandName(),color,frameID,engineID);
    }
    
    @Override
    public int compareTo(Object o) {
        return this.carID.compareToIgnoreCase(((Car)o).carID);
    }
}
