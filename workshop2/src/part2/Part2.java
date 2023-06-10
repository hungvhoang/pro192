/*Write a Java program to accept a string and print out it. If the string does not match SExxx(x is 
digit) then a message “the string is invalid” is printed out. Using do..while to input again.
    This program uses try-catch*/

package part2;

import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        boolean condition = true;
        do{
            try{
                Scanner sc = new Scanner(System.in);
                String s = "";
                String pattern ="(SE|se)\\d{3}";
                System.out.print("Enter the string: ");
                s = sc.nextLine();
                if(! s.matches(pattern))
                    throw new Exception();
                System.out.println("The string is "+ s);
                condition = false;
            }catch(Exception e){
                System.out.println("The string is invalid");
            }
        }while(condition);
    }
}
