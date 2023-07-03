package models;

import java.io.Serializable;

public class Brand implements Serializable{
    private String brandID,brandName,soundBrand;
    private double price;
    
    public Brand() {
        this.brandID="";
        this.brandName="";
        this.soundBrand="";
    }

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        if(!brandID.isBlank())
            this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if(!brandName.isBlank())
        this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        if(!soundBrand.isBlank())
        this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price>0)
        this.price = price;
    }

    public String toString(){
        return String.format("|%10s|%31s|%14s|%-9.3f|",brandID,brandName,soundBrand,price);
    }
    
}
