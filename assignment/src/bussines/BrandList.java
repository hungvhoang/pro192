package bussines;
import java.io.*;
import java.util.*;

import menu.Menu;
import models.Brand;

public class BrandList extends ArrayList<Brand> {
    private String header=("| Brand ID |           Brand Name          |     Sound    |  Price  |");
    private String row =  ("|----------|-------------------------------|--------------|---------|");
    private File file = new File("./brands.txt");
    private static Scanner sc = new Scanner(System.in);


    /**
     * save data to txt file
     * @return
     * @throws Exception
     */
    public boolean saveToFile() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        for(Brand x : this) oos.writeObject(x);
        oos.close();
        return true;
    }

    /**
     * get data from txt file
     * @return
     * @throws Exception
     */
    public boolean loadFromFile() throws Exception{
        if(file.isFile()){
            ArrayList<Brand> data = new ArrayList<>();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try{
                while(true){
                    data.add((Brand)ois.readObject());
                }
            }catch(Exception e){
                
            }
            this.addAll(data);
            ois.close();
            fis.close();
            return true;
        }
        else return false;
    }
    /**
     * Search brand by ID
     * @param brandID
     * @return
     */
    public int searchID(String brandID){
        for(int i=0;i<this.size();i++){
            if(this.get(i).getBrandID().equalsIgnoreCase(brandID)) 
            return i;
        }
        return -1;
    }

    /**
     * Search brand by ID and print out
     */
    public void searchByID(){
        System.out.print("Enter brand ID: ");
        int index = searchID(sc.nextLine());
        if(index==-1) System.out.println("Not found.");
        else System.out.println("Found: "+this.get(index));
    }
    public Brand getBrandChoice(){
        Menu menu = new Menu();
        return (Brand)menu.getObjectChoice(this);
    }


    /**
     * add a new brand
     */
    public void addBrand(){
        String temp ="";
        boolean condition = false;
        String brandID="",brandName="",soundBrand="";
        double price=0;
        do {

            //get brand id(condition: ID is not exist in the list)
            do{
                System.out.print("Enter brand ID: ");
                brandID = sc.nextLine();
                if(this.searchID(brandID)!=-1) {
                    System.out.println("Brand ID already exist!");
                    condition=false;
                }
                else condition =true;
            }while(!condition);

            //get brand name(condition: not blank)
            do{                         
                System.out.print("Enter brand name: ");
                brandName= sc.nextLine();
                if(brandName.isBlank()){
                    System.out.print("Brand name cannot be blanked.");
                    condition= false;
                }
                else condition=true;
            }while(!condition);

            //get sound brand(condition: not blank)
            do{                         
                System.out.print("Enter sound brand: ");
                soundBrand= sc.nextLine();
                if(soundBrand.isBlank()){
                    System.out.print("Sound brand cannot be blanked.");
                    condition= false;
                }
                else condition=true;
            }while(!condition);

            //get price(>0)
            do {
                try {
                    System.out.print("Enter price: ");
                    price = Double.parseDouble(sc.nextLine());
                    if (price<0) throw new Exception();
                    condition=true;
                } catch (Exception e) {
                    System.out.println("Invalid. Enter again.");
                    condition=false;
                }
            } while (!condition);
            this.add(new Brand(brandID, brandName, soundBrand, price));
            System.out.print("Enter another brand?(y- yes): ");
            temp=sc.nextLine();
        } while (temp.equalsIgnoreCase("y"));
    }

    /** 
     * Update brand name, sound brand, and price 
     */
    public void updateBrand(){
        System.out.print("Enter brand ID to update: ");
        int index = searchID(sc.nextLine());
        if(index == -1) System.out.println("Not found.");
        else{
            System.out.println("\t Update:"+this.get(index));
            boolean condition = false;
            String brandName="",soundBrand="";
            double price=0;
            do{                         
                System.out.print("Enter new brand name: ");
                brandName= sc.nextLine();
                if(brandName.isBlank()){
                    System.out.print("Brand name cannot be blanked.");
                    condition= false;
                }
                else {
                    this.get(index).setBrandName(brandName);
                    condition=true;
                }
            }while(!condition);
            do{                         
                System.out.print("Enter sound brand: ");
                soundBrand= sc.nextLine();
                if(soundBrand.isBlank()){
                    System.out.print("Sound brand cannot be blanked.");
                    condition= false;
                }
                else {
                    this.get(index).setSoundBrand(soundBrand);
                    condition=true;
                }
            }while(!condition);
            do {
                try {
                    System.out.print("Enter price: ");
                    price = Double.parseDouble(sc.nextLine());
                    if (price<0) throw new Exception();
                    this.get(index).setPrice(price);
                    condition=true;
                } catch (Exception e) {
                    System.out.println("Invalid. Enter again.");
                    condition=false;
                }
            } while (!condition);
            System.out.println("Updated.");
        }
        
    }
    /**
     * print out list of brand
     */
    public void listBrands(){
        if(this.size()==0) System.out.println("Empty list.");
        else{
            System.out.println("List of all brands:");
            System.out.println(header);
            System.out.println(row);
            for(Brand x : this){
                System.out.println(x);
                System.out.println(row);
            }
        }
    }
    
}
