package matrix;
import tools.Lib;
import java.util.Scanner;

public class matrix {
    public static void inputMatrix(int[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input value for the matrix:");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.printf("matrix[%d][%d]= ",i,j);
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public static void printMatrix(int[][] arr){
        System.out.println("Matrix inputted: ");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        int matrix[][];
        int rows= Lib.getInt("Enter number of row: ");
        int cols= Lib.getInt("Enter number of columns: ");
        matrix = new int[rows][cols];
        inputMatrix(matrix);
        printMatrix(matrix);
    }    
}
