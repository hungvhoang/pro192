package models;

import java.util.Comparator;


public class Product implements Valuable{
    private String productCode;
    private String productName;
    private String supplier;
    private String unit;
    private double price;
    private float quantity;
    private boolean hasPromotion;
    public Product() {
        this.productCode="";
        this.productName="";
        this.supplier="";
        this.unit="";
    }
    public Product(String productCode, String productName, String supplier, String unit, double price, float quantity,
            boolean hasPromotion) {
        this.productCode = productCode;
        this.productName = productName;
        this.supplier = supplier;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.hasPromotion = hasPromotion;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    public boolean isHasPromotion() {
        return hasPromotion;
    }
    public void setHasPromotion(boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }

    public String toString(){
        return String.format("|%-8s|%-12s|%-10s|%-6s|%11.1f|%11.1f|%11.1f|",productCode,productName,supplier,unit,price,quantity,value());
    }
    
    
    public static Comparator compareName = new Comparator() {

        @Override
        public int compare(Object o1, Object o2) {
            return ((Product)o1).getProductName().toLowerCase().compareTo((((Product)o2).getProductName()).toLowerCase());
        }        
    };
     public static Comparator compareValue = new Comparator() {

        @Override
        public int compare(Object o1, Object o2) {
            int result = -1;
            Product p1 = (Product)o1;
            Product p2 = (Product)o2;
            if(p1.value()>p2.value()) {
                result =1;
            }
            else if(p1.value()<p2.value()) {
                result = -1;
            }
            else{
                result = p1.getProductName().compareTo(p2.productName);
            }
            return result;
        }        
    };
    @Override
    public float value() {
       return (float) (price*quantity);
    }
    @Override
    public float vat() {
        return (float) (value()*0.08);
    }
    @Override
    public float promotion() {
        return (hasPromotion) ?  (value()*0.15f) : 0; 
    }
}
