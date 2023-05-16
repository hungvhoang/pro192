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
            }
        sc.close();
    }

    static void upperName(String[] list,int l){
        for(int i=0;i<l; i++){
            String tempName="";
            String[] splitName = list[i].split(" ");
            for(int j=0; j < splitName.length;j++){
                splitName[j] = splitName[j].substring(0, 1).toUpperCase() + splitName[j].substring(1);
                tempName += splitName[j] + " ";
            }
            list[i] = tempName;
        }
    }

    static void printList(String[] list, int l){
        System.out.println("The list of student you entered: ");
        for(int i= 0;i<l;i++){
            System.out.println((i+1)+". "+ list[i]);
        }
    }

    public static void main(String[] args){
        String[] list = new String[10];
        inputName(list,10);
        upperName(list,10);
        printList(list, 10);
    }
}