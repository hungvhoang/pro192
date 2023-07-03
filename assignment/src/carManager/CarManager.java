package carManager;


import bussines.BrandList;
import bussines.CarList;
import menu.Menu;


public class CarManager {
    public static void main(String[] args) throws Exception{
        BrandList brandList = new BrandList();
        brandList.loadFromFile();
        CarList carList = new CarList(brandList);
        carList.loadFromFile();
        String[] options = {"List all brands","Add a new brands","Search a brand by ID","Update a brand","Save all brands to files \"brands.txt\"","List all cars","List cars based on a part of brand name","Add a new car","Remove a car by its ID","Update a car","Save all cars to file \"cars.txt\"","Exit the program"};
        int choice=0;
        do {
            choice = Menu.getChoice(options);
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
                    boolean saved = brandList.saveToFile();
                    if(saved) {System.out.println("Saved.");}
                    else System.out.println("Something went wrong...");
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
                    break;
                case 12:
                    System.out.println("Program quitted.");
                    break;
            }
    
       } while (choice!=12);
    }
}
