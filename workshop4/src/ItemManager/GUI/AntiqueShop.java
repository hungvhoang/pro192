//Main for workshop4.

package ItemManager.GUI;

import ItemManager.DTO.*;
import lib.UserInput;

public class AntiqueShop {
    public static void main(String[] args){
        Item item=null;
        int choice=0;
        do{
            System.out.println("INHERITANCE IMPLEMENT EXERCISE .-.");
            System.out.println("Currently cannot save multi-item. Updating.....");
            System.out.println("\t=====MENU=====");
            System.out.println("1. Create a Vase.");
            System.out.println("2. Create a Statue.");
            System.out.println("3. Create a Painting.");
            System.out.println("4. Display the Item.");
            System.out.println("5. Exit program.");
            boolean isValidInput=true;
            do{
                try{
                    choice=UserInput.getInt("Input a choice: ");
                    if(choice<1|choice>5) throw new Exception();
                    isValidInput=false;
                }catch(Exception e){
                    System.out.println("Choose from 1 to 5 PLEASE.");
                }
            }while(isValidInput);
            switch(choice){
            case 1:
                item=new Vase();
                ((Vase)item).inputVase(); 
                break; 
            case 2:
                item =new Statue();
                ((Statue) item).inputStatue(); 
                break;
            case 3:
                item =new Painting();
                ((Painting) item).inputPainting();
                break;
            case 4:
                if(item!=null){
                if(item instanceof Vase)
                ((Vase) item).outputVase();
                else if(item instanceof Statue)
                ((Statue) item).outputStatue ();
                else if(item instanceof Painting)
                ((Painting) item).outputPainting (); 
                }
                else System.out.println("You need to create an object.");
                break;
            case 5:
                System.out.println("Program quitted.");
            }
        }while(choice!=5);
        }
    }