package tools;
import java.util.Scanner;


public class Lib {
    
   public static int getInt(String command){
    Scanner sc = new Scanner(System.in);
    System.out.print(command);
    int number = sc.nextInt();
    return number;
} 
}
