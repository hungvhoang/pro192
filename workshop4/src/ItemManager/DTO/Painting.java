package ItemManager.DTO;

import lib.UserInput; 
public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFrame;
    public Painting(){
        super();
    }
    Painting(int value,String creator,int height,int width,boolean isWaterColor,boolean isFrame){
        super(value, creator);
        this.height=height;
        this.width=width;
        this.isWaterColor=isWaterColor;
        this.isFrame=isFrame;
    }

    //getters
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public boolean isWaterColor() {
        return isWaterColor;
    }
    public boolean isFrame() {
        return isFrame;
    }
    
    //setters
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setWaterColor(boolean isWaterColor) {
        this.isWaterColor = isWaterColor;
    }
    public void setFrame(boolean isFrame) {
        this.isFrame = isFrame;
    }
    
    public void inputPainting(){
        super.input();
        boolean condition=true;   
        do {
            try {
                height=UserInput.getInt("Enter height: ");
                if(height<1) throw new Exception();
                condition=false;
            } catch (Exception e) {
                System.out.println("Invalid! Enter again.");
                condition=true;
            }
        } while (condition);
        
        do {
            try {
                width=UserInput.getInt("Enter width: ");
                if(width<1) throw new Exception();
                condition=false;
            } catch (Exception e) {
                System.out.println("Invalid! Enter again.");
                condition=true;
            }
        } while (condition);

        do {
            try {
                isWaterColor=UserInput.getBoolean("Water color(true/false): ");
                condition=false;
            } catch (Exception e) {
                System.out.println("Wrong format! Enter again.");
                condition=true;
            }
        } while (condition);

        do {
            try {
                isFrame=UserInput.getBoolean("Frame(true/false): ");
                condition=false;
            } catch (Exception e) {
                System.out.println("Wrong format! Enter again.");
                condition=true;
            }
        } while (condition);
    }
    
    
    public void outputPainting(){
        super.output();
        System.out.println("Height: "+getHeight());
        System.out.println("Width: "+getWidth());
        System.out.println("Water color: "+isWaterColor());
        System.out.println("Frame: "+isFrame());
    }
}