package productManagement;
import java.util.List;
import java.util.Scanner;

import models.Product;
import products.Products;

public class ProductManagement {
    public static void main(String[] args) throws Exception {
        Products list = new Products();
        int choice=0;
        String[] menu ={"1-Add product information.","2-Show all product.","3-Delete a product","4- Filter product by supplier","5-Sort and display the product.","6-Statistics the product by supplier.","7-Exit the program."};
        String[] sortMenu = {"1-Sort by name(asc).","2-Sort by value(des)"};
        do {
            choice = drawMenu(menu);
            switch(choice){
                case 1:
                    addSomeProduct(list);
                    //addProduct(list);
                    break;
                case 2:
                    list.showAll();
                    break;
                case 3:
                    delete(list);
                    break;
                case 4:
                    filter(list);
                    break;
                case 5:
                    choice=drawMenu(sortMenu);
                    switch(choice){
                        case 1:
                            list.sortByName();
                            break;
                        case 2:
                            list.sortByValue();
                            break;
                    }
                case 6:
                    System.out.println("Updating...");
                    break;
                case 7:
                    System.out.println("Program quitted.");
                    break;
            }
        } while (choice != 7); 
    }

    private static void filter(Products list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter supplier: ");
        String supplier = sc.nextLine();
        List<Product> supplierList = list.filterBySupplier(supplier);
        if(supplierList.size() == 0) System.out.println("\nCan't find product of "+supplier+".\n");
        else list.showAll(supplierList);
    }

    private static void delete(Products list) {
        System.out.print("Enter product code you want to delete: ");
        Scanner sc =new Scanner(System.in);
        String code = sc.nextLine();
        list.removeByKey(code.toUpperCase());
    }

    private static void addProduct(Products list) {
       String temp = "";
       boolean condition =false; 
        do{
            Scanner sc = new Scanner(System.in);
            Product x = new Product();
            do{
                System.out.print("Enter product code: ");
                temp = sc.nextLine();
                if(!temp.matches("(PR|pr|Pr|pR)\\d{3}")){
                    System.out.println("Invalid. Please enter again(format PRxxx).");
                    condition =false;
                }
                else{
                    x.setProductCode(temp.trim().toUpperCase());
                    condition = true;
                }
            }while(!condition);
            System.out.print("Enter product name: ");
            x.setProductName(sc.nextLine());
            System.out.print("Enter name of supplier: ");
            x.setSupplier(sc.nextLine());
            System.out.print("Enter unit: ");
            temp=sc.nextLine();
            x.setUnit(temp);
            do{
                try {
                    System.out.print("Enter price: ");
                    temp=sc.nextLine();
                    if(Double.parseDouble(temp)<0) throw new Exception();
                    x.setPrice(Double.parseDouble(temp));
                    condition=true;
                } catch (Exception e) {
                    System.out.println("Invalid. Enter again.");
                    condition = false;
                }
            }while(!condition);
            do{
                try {
                    System.out.print("Enter quantity: ");
                    temp=sc.nextLine();
                    if(Float.parseFloat(temp)<0) throw new Exception();
                    x.setQuantity(Float.parseFloat(temp));
                    condition=true;
                } catch (Exception e) {
                    System.out.println("Invalid. Enter again.");
                    condition = false;
                }
            }while(!condition);
            System.out.print("Promotion(1: Yes/Other: No): ");
            temp=sc.nextLine();
            x.setHasPromotion(temp.matches("1"));
            list.addOne(x);
            System.out.print("Enter another product(y: Yes)?: ");
            temp=sc.nextLine();
        }while(temp.equalsIgnoreCase("y"));
    }

    private static int drawMenu(String[] menu) {
        boolean condition =false;
        int choice=0;
        do{
            try{
                for (String string : menu) {
                System.out.println(string);
                }
                System.out.print("Enter a choice: ");
                Scanner sc= new Scanner(System.in);
                choice = sc.nextInt();
                if(choice<1|choice>menu.length) throw new Exception();
                condition=true;
            }catch(Exception e){
                System.out.println("\nInvalid. Enter again.\n");
                condition = false;
            }
        }while(!condition);
        return choice;
    }



    /**
     * data using for test.
     * @param list
     */
    private static void addSomeProduct(Products list){
        Product x = new Product("PR001", "Apple", "ABC", "Kg", 7500, 25, true);
        list.addOne(x);
        x = new Product("PR002", "Grape", "XYZ", "Kg", 12500, 30, false);
        list.addOne(x);
        x = new Product("PR003", "Orange", "XYZ", "Kg", 65000, 35, true);
        list.addOne(x);
        x = new Product("PR004", "Lime", "XYZ", "Kg", 42500, 40, false);
        list.addOne(x);
        x = new Product("PR005", "Watermelon", "ABC", "Kg", 105000, 45, true);
        list.addOne(x);
    }
}
