package CarManager;

public class Tester {
    public static void main(String[] args) {
        Car myCar =new Car();
        myCar.pressStartButton();
        myCar.pressAcceleratorButton();
        myCar.output();
        System.out.println();
        
        Car myNewCar = new Car("red", 100, true, true);
        myNewCar.pressAcceleratorButton();
        myNewCar.setColour("black");
        System.out.println("Colour of my new car: "+ myNewCar.getColour());
        myNewCar.output();
    } 
}
