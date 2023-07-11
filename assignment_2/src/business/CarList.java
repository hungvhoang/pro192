package business;

import java.io.*;
import java.util.*;

import models.Brand;
import models.Car;

public class CarList extends ArrayList<Car>{
    private Scanner sc = new Scanner(System.in);
    private BrandList brandList=null;
    private File file = new File("./cars.txt");


    public CarList(BrandList brandList){
        this.brandList = brandList;
    }
    

    /**
     * read the data from "cars.txt"
     * @return
     */
    public boolean loadFromFile(){
        if(file.exists() & file.isFile()){
            try {
                Scanner reader = new Scanner(file);
                while(reader.hasNextLine()){
                    //read the data of object line-by-line
                    String data = reader.nextLine();
                    //Split the line from file into parts.
                    String[] arr = data.split(", ");
                    //arr[0] : carID, arr[1]: brandID, arr[2]: color, arr[3]: frameID, arr[4]: engineID.
                    Brand brand = brandList.get(brandList.searchID(arr[1])); //-- search the brand by its ID
                    //add into the cars list
                    this.add(new Car(arr[0], brand, arr[2], arr[3], arr[4]));
                }    
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        else return false;
    }

    /**
     * Save object to file line-by-line
     * @return
     */
    public boolean saveToFile(){
        try{
            FileWriter writer = new FileWriter(file);
            for (Car x : this) {
                writer.write(x+"\n");
            }
            writer.close();
        }catch(Exception e){

        }
        return true;
    }

    /**
     * search the car ID through list
     * @param carID
     * @return index of carID in list
     */
    public int searchID(String carID){
        for(Car x : this){
            if(x.getCarID().equalsIgnoreCase(carID))
                return this.indexOf(x);
        }
        return -1;
    }

    /**
     * Search frame ID through list
     * @param frameID
     * @return index of frameID
     */
    public int searchFrame(String frameID){
        for(Car x : this){
            if(x.getFrameID().equalsIgnoreCase(frameID))
                return this.indexOf(x);
        }
        return -1;
    }

    /**
     * Search engineID through list
     * @param engineID
     * @return index of engineID
     */
    public int searchEngine(String engineID){
        for(Car x : this){
            if(x.getEngineID().equalsIgnoreCase(engineID))
                return this.indexOf(x);
        }
        return -1;
    }


    /**
     * get carID from user
     * @return carID
     */
    private String inputCarID(){
        String carID="";
        do{
                System.out.print("Enter car ID(Format: Cxx): ");
                carID = sc.nextLine();
                if(!carID.matches("(C|c)\\d{2}")){
                    System.out.println("Wrong format. Enter again.");
                }
                else if(searchID(carID)!=-1){
                        System.out.println("Car ID already existed. Enter again.");
                }
            }while(searchID(carID)!=-1|!carID.matches("(C|c)\\d{2}"));
            return carID;
    }

    /**
     * get color from user
     * @return color of the car
     */
    private String inputColor(){
        String color="";
        do {
            System.out.print("Enter color: ");
            color = sc.nextLine();
            if(color.isBlank()) 
                System.out.println("Cannot be blank. Enter again.");
        } while(color.isBlank());
            return color;
    }

    /**
     * get frameID from user
     * @return
     */
    private String inputFrameID(){
        String frameID ="";
        do {
            System.out.print("Enter frame ID(Format: Fxxxx): ");
            frameID=sc.nextLine();
            if(!frameID.matches("(F|f)(\\d{5})")){
             System.out.println("Wrong format. Enter again.");
            }
            else if(searchFrame(frameID)!=-1){
                System.out.println("Frame ID already existed. Enter again.");
            }
        } while (!frameID.matches("(F|f)(\\d{5})")|searchFrame(frameID)!=-1);
        return frameID;
    }

    /**
     * get engineID from user
     * @return
     */
    private String inputEngineID(){
        String engineID="";
        do {
            System.out.print("Enter engine ID(Format: Exxxx): ");
            engineID=sc.nextLine();
            if(!engineID.matches("(E|e)(\\d{5})")){
                System.out.println("Wrong format. Enter again.");
            }
            else if(searchEngine(engineID)!=-1){
                System.out.println("Engine ID already existed. Enter again.");
            }
        } while (!engineID.matches("(E|e)(\\d{5})")|searchEngine(engineID)!=-1);
        return engineID;
    }

    /**
     * add a new car to list 
     */
    public void addCar(){
        String temp="";
        do {
            String carID=inputCarID();
            Brand brand = brandList.getBrandChoice();
            String color = inputColor();
            String frameID = inputFrameID();
            String engineID = inputEngineID();
            this.add(new Car(carID, brand, color, frameID, engineID));
            System.out.println("Car has been added.");
            System.out.print("Enter another car?(y- yes): ");
            temp=sc.nextLine();
        } while (temp.equalsIgnoreCase("y"));
    }

    /**
     * print out some cars by brand name
     */
    public void printBasedBrandName(){
        System.out.print("Enter brand name: ");
        String partOfBrandName = sc.nextLine();
        boolean found = false;
        System.out.println("\tList of cars by brand name: ");
        for (Car x: this) {
            if(x.getBrand().getBrandName().toLowerCase().contains(partOfBrandName.toLowerCase())){
                System.out.println(x.screenString());
                found= true;
            }
        }
        if(!found) System.out.println("Empty.");
    }
    
    /**
     * remove a car from list
     * @return
     */
    public boolean removeCar(){
        System.out.println("Enter car's ID you want to remove: ");
        String carID = sc.nextLine();
        if(searchID(carID)==-1) {
            System.out.println("Not found.");
            return false;
        }
        else {
            this.remove(searchID(carID));
            System.out.println("Removed.");
        }
        return true;
    }

    /**
     * update new color, frameID, engineID of a car by its ID
     * @return
     */
    public boolean updateCar(){
        this.listCars();
        System.out.print("Enter car's ID you want to update: ");
        String carID = sc.nextLine();
        if(searchID(carID)==-1){
            System.out.println("Not found.");
            return false;
        }
        else{
            int index = searchID(carID);
            System.out.println("Update car "+carID+":");
            this.get(index).setBrand(brandList.getBrandChoice());
            this.get(index).setColor(inputColor());
            this.get(index).setFrameID(inputFrameID());
            this.get(index).setEngineID(inputEngineID());
            return true;
        }
    }
    
    /**
     * print out all cars of the list
     */
    public void listCars(){
        Collections.sort(this);
        for (Car x : this) {
            System.out.println(x.screenString());
        }
    }


}
