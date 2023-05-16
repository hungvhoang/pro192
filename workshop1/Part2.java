/*Write a Java program that will accept two float numbers and an operator (+ - / *) then the program
will print out the result of the specified expression that bases on the inputted operator. */

import java.util.Scanner;

public class Part2 {
     
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number 1: ");
        int num1 = sc.nextInt();
        System.out.print("Input the number 2: ");
        int num2 = sc.nextInt();
        System.out.print("Input the operator (+-/*): ");
        char op = sc.next().charAt(0);
        switch(op){
            case '+':
                System.out.printf("%d + %d= %d\n",num1,num2, num1 + num2);
                break;
            case '-':
                System.out.printf("%d - %d= %d\n",num1,num2,num1 - num2);
                break;
            case '*':
                System.out.printf("%d * %d= %d\n",num1,num2,num1 * num2);
                break;
            case '/':
                System.out.printf("%d / %d= %d\n",num1,num2,num1 / num2);
                break;
            default :
                System.out.println("Not supported.");    
        }
        sc.close();
    }
}
