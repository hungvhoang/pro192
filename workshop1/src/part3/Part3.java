
/*Write a Java program that will accept the list of student name, convert all names to uppercase
and then the program will print out the list of student name.*/
package part3;
import java.util.Scanner;
public class Part3 {
    //Method to input name of the student.
    static void inputName(String[] list){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of 10 students: ");
        for(int i=0;i<list.length;i++){
            System.out.print("Student "+(i+1)+": ");
            list[i]= sc.nextLine();
            }
        sc.close();
    }
    //Method to capitalize first name and last name of the student.
    static void upperName(String[] list){
        for(int i=0;i<list.length; i++){
            list[i]=list[i].toLowerCase();
            String tempName="";
            String[] splitName = list[i].split(" ");
            for(int j=0; j < splitName.length;j++){
                tempName += splitName[j].substring(0, 1).toUpperCase() + splitName[j].substring(1)+" ";
            }
            list[i] = tempName;
        }
    }
    
    static void printList(String[] list){
        System.out.println("The list of student you entered: ");
        for(int i= 0;i<list.length;i++){
            System.out.println((i+1)+". "+ list[i]);
        }
    }

    public static void main(String[] args){
        String[] list = new String[10];
        inputName(list);
        upperName(list);
        printList(list);
    }
}