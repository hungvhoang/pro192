package carManager;

import java.util.*;

import business.BrandList;
import business.CarList;
import menu.Menu;

public class CarManager{
    public static void main(String[] args) {
        String[] options = {"List all brands","Add a new brand","Search a brand by its ID","Update a brand","Save all brands to file \"brands.txt\"","List all cars","List cars by brand name","Add a car","Remove a car","Update a car","Save all cars to file \"cars.txt\"","Exit the program"};
        ArrayList<String> menu= new ArrayList<>();
        for (String x : options) {
            menu.add(x);
        }
        BrandList brandList = new BrandList();
        brandList.loadFromFile();
        CarList carList = new CarList(brandList);
        carList.loadFromFile();
        int choice =0;
        do {
            choice = Menu.getIntChoice(menu);
            switch(choice){
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    brandList.searchByID();
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile();
                    System.out.println("Saved.");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.printBasedBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    carList.saveToFile();
                    System.out.println("Saved");
                    break;
                case 12:
                    System.out.println("Program quitted.");
                    break;
            }
        } while (choice!=12);
    }
}