package CarManager;

public class Car {
    //Car's attributes.
    private String colour;
    private int enginePower;
    private boolean convertible;
    private boolean parkingBrake;
    
    //constructor.
    Car(){
        this.colour="";
    };
    Car(String colour,int enginePower,boolean convertible,boolean parkingBrake){
        this.setColour(colour);
        this.setEnginePower(enginePower);
        this.setConvertible(convertible);
        this.setParkingBrake(parkingBrake);
    }
    
    //getters.
    public String getColour(){
        return colour;
    }
    public int getEnginePower(){
        return enginePower;
    }
    public boolean isConvirtible(){
        return convertible;
    }
    public boolean isParkingBrake(){
        return parkingBrake;
    }
    
    //setter.
    public void setColour(String colour){
        this.colour=colour;
    }
    public void setEnginePower(int enginePower){
        this.enginePower=enginePower;
    }
    public void setConvertible(boolean convertible){
        this.convertible=convertible;
    }
    public void setParkingBrake(boolean parkingBrake){
        this.parkingBrake=parkingBrake;
    }

    //Car's method
    public void pressStartButton(){
        System.out.println("You have pressed the start button.");
    }
    public void pressAcceleratorButton(){
        System.out.println("You have pressed the Accelerator button! *brr brr*");
    }
    public void output(){
        System.out.println("Colour: "+this.colour);
        System.out.println("Engine power: "+this.enginePower);
        System.out.println("Convertible: "+this.convertible);
        System.out.println("Parking brake: "+this.parkingBrake);        
    }

    //toString
    public String toString(){
        return colour+"\n"+enginePower+"\n"+convertible+"\n"+parkingBrake+"\n";
    }
}
