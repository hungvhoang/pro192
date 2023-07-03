package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static int getChoice(String[] options){
        boolean condition =false;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            try{
                for(int i=0;i<options.length;i++){
                    System.out.println((i+1)+". "+options[i]+".");
                }
                System.out.print("Enter your choice: ");
                choice=Integer.parseInt(sc.nextLine());
                if(choice<1| choice >options.length) throw new Exception();
                condition=true;
            }catch(Exception e){
                System.out.println("Invalid! Enter again.");
                condition=false;
            }
        }while(!condition);
        return choice;
    }

    public static Object getObjectChoice(ArrayList options){
        int choice=0;
        boolean condition=false;
        Scanner sc = new Scanner(System.in); 
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1)+". "+options.get(i)+".");
        }
        do{
            try{
                System.out.print("Enter your choice: ");
                choice=sc.nextInt();
                if(choice<1| choice >options.size()) throw new Exception();
                condition=true;
            }catch(Exception e){
                System.out.println("Invalid. Enter again.");
                condition=false;
            }
        }while(!condition);
        return options.get(choice-1);
    }
}
