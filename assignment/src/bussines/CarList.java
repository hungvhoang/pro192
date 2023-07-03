package bussines;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import menu.Menu;
import models.Brand;
import models.Car;

public class CarList extends ArrayList<Car>{
    private String header =("| Car ID |           Brand Name           |  Color  |  Frame ID  |  Engine ID  |");
    private String row    =("|--------|--------------------------------|---------|------------|-------------|");
    private BrandList brandList;
    public static Scanner sc = new Scanner(System.in);
    File file = new File("./Cars.txt");

    public boolean saveToFile() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        for(Car x : this) oos.writeObject(x);
        oos.close();
        return true;
    }

    public boolean loadFromFile(){
        if(this.file.isFile()&& this.file.exists()){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                boolean hasNext = true;
                while(hasNext){
                    Car car = (Car)ois.readObject();
                    if(car != null) this.add(car);
                    else hasNext = false;
                }
                ois.close();
            }catch(Exception e){
                
                
            }
            return true;
            }else{
                System.out.println("The file could not be found.");
                return false;
        }
    }

    public CarList(BrandList brandList){
        this.brandList = brandList;
    }
    public int searchID(String carID){
        for(Car x : this){
            if(x.getCarID().equalsIgnoreCase(carID))
                return this.indexOf(x);
        }
        return -1;
    }

    public int searchFrame(String frameID){
        for(Car x : this){
            if(x.getFrameID().equalsIgnoreCase(frameID))
                return this.indexOf(x);
        }
        return -1;
    }

    public int searchEngine(String engineID){
        for(Car x : this){
            if(x.getEngineID().equalsIgnoreCase(engineID))
                return this.indexOf(x);
        }
        return -1;
    }

    public void addCar(){
        String temp="";
        String carID="",color="",frameID="",engineID="";
        do {

            //get car id
            do{
                System.out.print("Enter car ID(Format: Cxx): ");
                carID= sc.nextLine();
                if(carID.matches("(C|c)(0-9)(0-9)"))
                    System.out.println("Wrong format. Enter again.");
                else if(searchID(carID)!=-1){
                    System.out.println("Car ID already existed. Enter again.");
                }
            }while(searchID(carID)!=-1|carID.matches("(C|c)(0-9)(0-9)"));

            //print a menu of brand for user to choose
            Brand brand = (Brand)Menu.getObjectChoice(brandList);
            do {
                System.out.print("Enter color: ");
                color = sc.nextLine();
                if(color.isBlank()) 
                    System.out.println("Cannot be blank. Enter again.");
            } while (color.isBlank());
            
            // get frame id
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

            // get engine id
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
            this.add(new Car(carID.toUpperCase(), brand, color, frameID.toUpperCase(), engineID.toUpperCase()));
            System.out.print("Enter a new car?(y- yes): ");
            temp= sc.nextLine();
        } while (temp.equalsIgnoreCase("y"));
    }

    public void printBasedBrandName(){
        System.out.print("Enter brand name: ");
        String partOfBrandName = sc.nextLine();
        boolean found = false;
        System.out.println("\tList of cars by brand name: ");
        for (Car x: this) {
            if(x.getBrand().getBrandName().toLowerCase().contains(partOfBrandName.toLowerCase())){
                System.out.println(x);
                found= true;
            }
        }
        if(!found) System.out.println("Empty.");
    }
    public void listCars(){
        ArrayList<Car> list = this;
        if(list.isEmpty()) System.out.println("Empty list.");
        else{
            Collections.sort(list);
            System.out.println("\tList of all cars: ");
            System.out.println(header);
            System.out.println(row);
            for(Car car : list){
                System.out.println(car);
                System.out.println(row);
            }
        }
    }

    public boolean removeCar(){
        System.out.println("Enter car's ID you want to remove: ");
        String carID = sc.nextLine();
        if(searchID(carID)==-1) {
            System.out.println("Not found.");
            return false;
        }
        else this.remove(searchID(carID));
        return true;
    }

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
            this.get(index).setFrameID("0");
            this.get(index).setEngineID("0");
            System.out.println(this.get(index));
            String color="",frameID="",engineID="";
            //print a menu of brand for user to choose
            Brand brand = (Brand)Menu.getObjectChoice(brandList);
            this.get(searchID(carID)).setBrand(brand);

            // get new color
            do {
                System.out.print("Enter new color: ");
                color = sc.nextLine();
                if(color.isBlank()) 
                    System.out.println("Cannot be blank. Enter again.");
            } while (color.isBlank());
            this.get(index).setColor(color);

            // get new frame id
            do {
                System.out.print("Enter new frame ID(Format: Fxxxx): ");
                frameID=sc.nextLine();
                if(!frameID.matches("(F|f)\\d{5}")){
                    System.out.println("Wrong format. Enter again.");
                }
                else if(searchFrame(frameID)!=-1){
                    System.out.println("Frame ID already existed. Enter again.");
                }
            } while (!frameID.matches("(F|f)\\d{5}")|searchFrame(frameID)!=-1);
            this.get(index).setFrameID(frameID);

            // get engine id
            do {
                System.out.print("Enter new engine ID(Format: Exxxx): ");
                engineID=sc.nextLine();
                if(!engineID.matches("(E|e)\\d{5}")){
                    System.out.println("Wrong format. Enter again.");
                }
                else if(searchEngine(engineID)!=-1){
                    System.out.println("Engine ID already existed. Enter again.");
                }
            } while (!engineID.matches("(E|e)\\d{5}")|searchEngine(engineID)!=-1);
            this.get(index).setEngineID(engineID);
            System.out.println("Updated.");
        }
        return true;
    }
}
