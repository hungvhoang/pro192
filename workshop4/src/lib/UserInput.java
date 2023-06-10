package lib;
import java.util.Scanner;

public class UserInput {
    /**
     * get Integer from user.
     * @param message
     * @return int.
     */
    public static int getInt(String message){
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print(message);
        num = sc.nextInt();
        return num;
    }
    
    /**
     * get String from user.
     * @param message
     * @return string
     */
    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String string = sc.nextLine();
        return string;
    }

    /**
     * get condition (true/false) from user.
     * @param message
     * @return boolean
     */
    public static boolean getBoolean(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        boolean bool = sc.nextBoolean();
        return bool;
    }
}
