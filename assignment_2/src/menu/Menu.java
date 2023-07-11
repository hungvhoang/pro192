package menu;

import java.util.*;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    /**
     * print out a menu an get choice from user
     * @param options
     * @return an integer
     */
    public static int getIntChoice(ArrayList options){
        int choice =0;
        boolean condition =false;
        do {
            try {
                for(int i = 0; i<options.size();i++){
                    System.out.println((i+1)+". "+options.get(i)+".");
                }    
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if(choice<1|choice>options.size()) throw new Exception();
                condition=true;
            } catch (Exception e) {
                System.out.println("Invalid. Enter again.");
                condition = false;
            }
        } while (!condition);
        return choice;
    }

    /**
     * print out list of objects and get user choice
     * @param options
     * @return object from the list
     */
    public static Object getObjectChoice(ArrayList options){
        int choice=getIntChoice(options);
        return options.get(choice-1);
    }
}
