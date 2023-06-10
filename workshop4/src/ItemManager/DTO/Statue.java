package ItemManager.DTO;

import lib.UserInput;

public class Statue extends Item{
    private int weight;
    private String color;
    public Statue(){
        super();
        this.color="";
    }
    Statue(int value,String creator,int weight,String color){
        super(value, creator);
        this.weight=weight;
        this.color=color;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void inputStatue(){
        super.input();
            boolean condition=true;
            do {
                try { 
                    weight=UserInput.getInt("Enter weight: ");
                    if(weight<1) throw new Exception();
                    condition=false;
                } catch (Exception e) {
                    System.out.println("Invalid! Enter again.");
                    condition=true;
                }
            } while (condition);
            do{
                try{
                    color=UserInput.getString("Enter color: ");
                    if(color.isBlank()) throw new Exception();
                    condition=false;
                }catch (Exception e){
                    System.out.println("Something went wrong");
                    condition=true;
                }
            }while(condition);
        }
    

    public void outputStatue(){
        super.output();
        System.out.println("Weight: "+getWeight());
        System.out.println("Color: "+getColor());
    }
}

