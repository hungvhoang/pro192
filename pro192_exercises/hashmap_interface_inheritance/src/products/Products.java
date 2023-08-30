package products;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import models.Product;

public class Products extends HashMap<String,Product>{
    private String header ="|  Code  |    Name    | Supplier | Unit |   Price   |  Quatity  |   Value   |";
    private String row =   "|--------|------------|----------|------|-----------|-----------|-----------|";
    public Products(){
        super();
    }
    public List<Product> toList(){
        return new ArrayList<>(this.values());
    }

    public void showAll(){
        System.out.println(header);
        System.out.println(row);
        for(Product i : toList()){
            System.out.println(i);
            System.out.println(row);
        }
    }
    
    public void showAll(List<Product> list){
        System.out.println(header);
        System.out.println(row);
        for (Product i: list) {
            System.out.println(i);
            System.out.println(row);
        }
    }
    
    public void addOne(Product x){
        if(!containsKey(x.getProductCode())){
            put(x.getProductCode(), x);
            System.out.println("Product added.");
        }
        else{
            System.out.println("Product already exist.");
        }
    }
    public void removeByKey(String productCode){
        if(containsKey(productCode)){
            remove(productCode);
            System.out.println("Removed");
        }
        else System.out.println("Product doesn't exist.");
    }
    
    public List<Product> filterBySupplier(String supplier){
        List<Product> listOfSupplier = new ArrayList<>();
        for (Product product : toList()) {
            if(product.getSupplier().equalsIgnoreCase(supplier)){
                listOfSupplier.add(product);
            }
        }
        return listOfSupplier;
    }
    public void sortByName(){
        List<Product> sortlList =toList();
        Collections.sort(sortlList,Product.compareName);
        System.out.println("\tList of products sorted by name:");
        showAll(sortlList);
    }
    public void sortByValue(){ 
        List<Product> sortlList =toList();
        Collections.sort(sortlList,Product.compareValue.reversed());
        System.out.println("\tList of product sorted by value:");
        showAll(sortlList);
    } 
}
