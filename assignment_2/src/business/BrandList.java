package business;

import java.io.*;
import java.util.*;

import menu.Menu;
import models.Brand;

public class BrandList extends ArrayList<Brand>{
    private File file = new File("./brands.txt");
    public static Scanner sc = new Scanner(System.in);

    /**
     * read data of brand from file
     * @return
     */
    public boolean loadFromFile(){
        if(file.isFile()&&file.exists()){
            try {
                Scanner reader = new Scanner(file);
                // read data line-by-line
                while(reader.hasNextLine()){
                    String data = reader.nextLine();
                    // split the line into part of string
                    // format (brandID, brandName, soundbrand: price)
                    String[] arr = data.split(", ");
                    String[] split = arr[2].split(": ");
                    Brand brand = new Brand(arr[0], arr[1], split[0],Double.parseDouble(split[1]));
                    this.add(brand);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        else {
            System.out.println("Cannot read data from file.");
            return false;
        }
    }

    /**
     * save data of brand to file
     * @return
     */
    public boolean saveToFile(){
        try{
            FileWriter writer = new FileWriter(file);
            for (Brand x : this) {
                writer.write(x+"\n");
            }
            writer.close();        
        }catch(Exception e){
        }
        return true;
    }

    /**
     * search brand id
     * @param brandID
     * @return index of brand have the ID
     */
    public int searchID(String brandID){
        for(int i=0;i<this.size();i++){
            if(this.get(i).getBrandID().equalsIgnoreCase(brandID)) 
            return i;
        }
        return -1;
    }

    /**
     * Search brand by its ID and print out the information
     */
    public void searchByID(){
        System.out.print("Enter brand ID to search: ");
        String brandID = sc.nextLine();
        if(searchID(brandID)==-1)
            System.out.println("Not found.");
        else
            System.out.println(this.get(searchID(brandID)));
    }

    /**
     * print out a menu for user to choose brand
     * @return
     */
    public Brand getBrandChoice(){
        return (Brand)Menu.getObjectChoice(this);
    }

    /**
     * get brandID from user
     * @return
     */
    private String inputBrandID(){
        boolean condition = false;
        String brandID="";
        do{
                System.out.print("Enter brand ID: ");
                brandID = sc.nextLine();
                if(this.searchID(brandID)!=-1) {
                    System.out.println("Brand ID already exist!");
                    condition=false;
                }
                else condition =true;
            }while(!condition);
            return brandID;
    }

    /**
     * get brand name form user
     * @return
     */
    private String inputBrandName(){
        boolean condition=false; 
        String brandName="";
        do{                         
            System.out.print("Enter brand name: ");
            brandName= sc.nextLine();
            if(brandName.isBlank()){
                System.out.print("Brand name cannot be blanked.");
                condition= false;
            }
            else condition=true;
        }while(!condition);
        return brandName;
    }

    /**
     * get sound brand from user
     * @return
     */
    private String inputSoundBrand(){
        boolean condition =false;
        String soundBrand="";
        do{                         
            System.out.print("Enter sound brand: ");
            soundBrand= sc.nextLine();
            if(soundBrand.isBlank()){
                System.out.print("Sound brand cannot be blanked.");
                condition= false;
            }
            else condition=true;
        }while(!condition);
        return soundBrand;
    }

    /**
     * get price of the brand from user
     * @return
     */
    private double inputPrice(){
        boolean condition=false;
        double price=-1;
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
            }while(!condition);
            return price;
    }

    /**
     * add a new brand to the list
     */
    public void addBrand(){
        String temp ="";
        String brandID="",brandName="",soundBrand="";
        double price=0;
        do {
            brandID = inputBrandID();
            brandName = inputBrandName();
            soundBrand = inputSoundBrand();
            price =inputPrice();
            this.add(new Brand(brandID, brandName, soundBrand, price));
            System.out.print("Enter another brand?(y- yes): ");
            temp=sc.nextLine();
        } while (temp.equalsIgnoreCase("y"));
    }

    /**
     * input the brandID and update its attributes
     */
    public void updateBrand(){
        System.out.print("Enter brand ID to update: ");
        String brandID = sc.nextLine();
        int index = searchID(brandID);
        if(index==-1) System.out.println("Not found.");
        else{
            System.out.println(this.get(index));
            this.get(index).setBrandName(inputBrandName());
            this.get(index).setSoundBrand(inputSoundBrand());
            this.get(index).setPrice(inputPrice());
            System.out.println("Brand "+brandID+" updated.");
        }
    }

    /**
     * print out all brands in the list
     */
    public void listBrands(){
        System.out.println("\tList of all brands: ");
        for (Brand x : this) {
            System.out.println(x);
        }
    }
}
