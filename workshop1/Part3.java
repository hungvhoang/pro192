/*Write a Java program that will accept the list of student name, convert all names to uppercase
and then the program will print out the list of student name.*/
import java.util.Scanner;
public class Part3 {
    static void inputName(String[] list, int l){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of 10 students: ");
        for(int i=0;i<l;i++){
            System.out.print("Student "+(i+1)+": ");
            list[i]= sc.nextLine();
            if(list[i]==".") break;
            }
        sc.close();
    }

    static void upperName(String[] list,int l){
        for(int i=0;i<l; i++){
        
        }
    }

    public static void main(String[] args){
        String[] list = new String[10];
        inputName(list,10);
        upperName(list,10);
    }
}
