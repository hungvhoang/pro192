package models;

public class Car implements Comparable<Car>{
    private String carID="",color="",frameID="",engineID="";
    private Brand brand = null;
    public Car() {
    }
    public Car(String carID,Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
        this.brand = brand;
    }
    public String getCarID() {
        return carID;
    }
    public void setCarID(String carID) {
        this.carID = carID.trim();
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color.toLowerCase().trim();
    }
    public String getFrameID() {
        return frameID;
    }
    public void setFrameID(String frameID) {
        this.frameID = frameID.toUpperCase().trim();
    }
    public String getEngineID() {
        return engineID;
    }
    public void setEngineID(String engineID) {
        this.engineID = engineID.toUpperCase().trim();
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    @Override
    public String toString() {
        return carID+", "+brand.getBrandID()+", "+getColor()+", "+getFrameID()+", "+getEngineID();
    }
    
    public String screenString(){
        return brand.getBrandName()+"\n"+getCarID()+", "+getColor()+", "+getFrameID()+", "+getEngineID();
    }

    /**
     * compare the brand name of two cars, then their carIDs
     */
    @Override
    public int compareTo(Car o) {
        int compare = this.getBrand().getBrandName().compareToIgnoreCase(o.getBrand().getBrandName());
        if(compare!=0) return compare;
        else return this.getCarID().compareToIgnoreCase(((Car)o).getCarID());
    }
}

