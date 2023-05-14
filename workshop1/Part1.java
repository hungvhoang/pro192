/*Write a Java program that will accept a matrix of integers then this matrix will be printed out and
sum of values and average of values are printed also. */
import java.util.Scanner;

public class Part1{

    //Method to input value of the matrix.
    static void setVal(int arr[][], int x, int y){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the matrix: ");
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.printf("Enter matrix[%d][%d]= ",i,j);
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    //Method to print all values of the matrix. 
    static void getVal(int arr[][], int x, int y){
        System.out.println("Matrix inputted: ");
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
    //Calculate sum of all elements.
    static int addAll(int arr[][],int x,int y){
    int s=0;
    for(int i=0;i<x;i++){
        for(int j=0;j<y;j++){
            s=s+arr[i][j];
        }
    }
    return s;
   }
   //Calculate average.
    static float average(int x,int y,int sum){
        return (float)sum/(x*y);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int matrix[][];
        int rows,cols;
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        cols = sc.nextInt();
        matrix= new int[rows][cols];
        setVal(matrix, rows, cols);
        getVal(matrix, rows, cols);
        int sum =addAll(matrix, rows, cols);
        System.out.println("Sum: "+sum);
        float av = average(rows, cols, sum);
        System.out.println("Average: "+av); 
        sc.close();
    }
}