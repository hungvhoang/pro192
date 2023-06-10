package ItemManager.DTO;

import lib.UserInput;

public class Vase extends Item{
    private int height;
    private String material;
    public Vase(){
        super();
        this.material="";
    }
    Vase(int value,String creator,int height,String material){
        super(value, creator);
        this.height=height;
        this.material=material;
    }
    public int getHeight() {
        return height;
    }
    public String getMaterial() {
        return material;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setMaterial(String material) {
        if(!material.isEmpty())
        this.material = material;
    }
    public void inputVase(){
        super.input();
            boolean condition=true;
            do {
                try {
                    height=UserInput.getInt("Enter height: ");
                    if(!(height>0)) throw new Exception();
                    condition=false;
                } catch (Exception e) {
                    System.out.println("Invalid! Enter again!");
                    condition=true;
                }
            } while (condition);
            
            do{
                try{ 
                    material=UserInput.getString("Enter material: ");
                    if(material.isBlank()) throw new Exception();
                    condition=false;
                }catch (Exception e){
                    System.out.println("Something went wrong. Enter again.");
                    condition=true;
                }
            }while(condition);
        }
    
    public void outputVase(){
        super.output();
        System.out.println("Height: "+getHeight());
        System.out.println("material: "+getMaterial());
    }
}
