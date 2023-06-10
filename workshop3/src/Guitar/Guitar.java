package Guitar;

public class Guitar {
    private String serialNumber;
    private int price;
    private String builder;
    private String model;
    private String backWood;
    private String topWood;

    public Guitar(){
        this.serialNumber="";
        this.builder="";
        this.model="";
        this.backWood="";
        this.topWood="";
    };
    public Guitar(String serialNumber,int price,String builder,String model,String backWood,String topWood){
        this.serialNumber=serialNumber;
        this.price=price;
        this.builder=builder;
        this.model=model;
        this.backWood=backWood;
        this.topWood=topWood;
    }

    //getters
    
    public String getSerialNumber(){
        return serialNumber;
    }

    public int getPrice(){
        return price;
    }

    public String getBuilder(){
        return builder;
    }

    public String getModel(){
        return model;
    }

    public String getBackWood(){
        return backWood;
    }

    public String getTopWood(){
        return topWood;
    }
    
    //setters
    public void setSerialNumber(String serialNumber){
        if(!serialNumber.isEmpty())
            this.serialNumber=serialNumber;
    }
    public void setPrice(int price){
        if(price!=0)
            this.price=price; 
    }
    public void setBuilder(String builder){
        if(!builder.isEmpty())
            this.builder=builder;
    }
    public void setModel(String model){
        if(!model.isEmpty())
            this.model=model;
    }
    public void setBackWood(String backWood){
        if(!backWood.isEmpty())
            this.backWood=backWood;
    }
    public void setTopWood(String topWood){
        if(!topWood.isEmpty())
            this.topWood=topWood;
    }

    public void createSound(){
        System.out.println("Serial Number: "+getSerialNumber());
        System.out.println("Price: "+getPrice());
        System.out.println("Builder: "+getBuilder());
        System.out.println("Model: "+getModel());
        System.out.println("Back wood: "+getBackWood());
        System.out.println("Top wood: "+getTopWood());
    }
}
