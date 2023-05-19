package part1;
    /*Write a Java program that will accept a matrix of integers then this matrix will be printed out and
    sum of values and average of values are printed also. */
    import java.util.Scanner;
    
    public class Part1{
    
        //Method to input value of the matrix.
        static void setVal(int arr[][]){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the matrix: ");
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    System.out.printf("Enter matrix[%d][%d]= ",i,j);
                    arr[i][j] = sc.nextInt();
                }
            }
            sc.close();
        }
    
        //Method to print all values of the matrix. 
        static void getVal(int arr[][]){
            System.out.println("Matrix inputted: ");
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println("");
            }
        }
        //Calculate sum of all elements.
        static int addAll(int arr[][]){
        int s=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                s=s+arr[i][j];
            }
        }
        return s;
       }
       //Calculate average.
        static float average(int arr[][],int rows,int cols){
            
            return (float)addAll(arr)/(rows*cols);
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
            setVal(matrix);
            getVal(matrix);
            int sum =addAll(matrix);
            System.out.println("Sum: "+sum);
            float av = average(matrix,rows,cols);
            System.out.println("Average: "+av); 
            sc.close();
        }
    }
    

