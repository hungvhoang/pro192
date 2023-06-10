package ItemManager.DTO;
import lib.UserInput;

public class Item {
    private int value;
    private String creator;
    Item(){
        this.creator="";
    }
    Item(int value,String creator){
        this.value=value;
        this.creator=creator;
    }
    public String getCreator() {
        return creator;
    }
    public int getValue() {
        return value;
    }
    public void setCreator(String creator) {
        if(!creator.isEmpty())
        this.creator = creator;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void output(){
        System.out.println("Value: "+getValue());
        System.out.println("Creator: "+getCreator());
    }
    public void input(){
        boolean condition=true;
            do{
                try{
                    value=UserInput.getInt("Enter value: ");
                    if(value<1) throw new Exception();
                    condition=false;
                }catch(Exception e){
                    System.out.println("Invalid! Enter again.");
                    condition=true;
                }
                
            }while(condition);
            
            do{
                try{
                    creator=UserInput.getString("Enter creator: ");
                    if(creator.isBlank()) throw new Exception();
                    condition=false;
                }catch (Exception e){
                    System.out.println("Something went wrong. Enter again.");
                    condition=true;
                }
            }while(condition);
        }

}
