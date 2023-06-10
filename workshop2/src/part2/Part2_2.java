/*Write a Java program to accept a string and print out it. If the string does not match SExxx(x is 
digit) then a message “the string is invalid” is printed out. Using do..while to input again.*/
    //Task 2: use throws keyword

package part2;
import java.util.Scanner;

public class Part2_2{
    
    public String inputString() throws Exception
    {
        String pattern="(se|SE)\\d{3}";
        String s="";
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the string: ");
        s = sc.nextLine();
        if(!s.matches(pattern))
            throw new Exception();
        return s;
    }

    public static void main(String[] args){
        Part2_2 myObj = new Part2_2();
        boolean condition = false;
        do{
            try{
                String s = myObj.inputString();
                System.out.println("The string is "+s);
                condition = false;
            }catch(Exception e){
                System.out.println("The string you entered is invalid.");
                condition = true;
            }
        }while(condition);
    }
}