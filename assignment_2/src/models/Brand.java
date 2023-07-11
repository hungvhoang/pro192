package models;

public class Brand{
    private String brandID="",brandName="",soundBrand="";
    private double price;
    public Brand() {
    }
    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID.trim().toUpperCase();
        this.brandName = brandName.trim();
        this.soundBrand = soundBrand.trim();
        this.price = price;
    }
    public String getBrandID() {
        return brandID;
    }
    public void setBrandID(String brandID) {
        this.brandID = brandID.trim().toUpperCase();
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName.trim();
    }
    public String getSoundBrand() {
        return soundBrand;
    }
    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand.trim();
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return brandID+", "+brandName+", "+soundBrand+": "+price;
    }
    
}