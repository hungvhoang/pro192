import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int choice=0;
        String[] menu ={"1-Add product information.","2-Show all product.","3-Delete a product","4- Filter product by supplier","5-Sort and display the product.","6-Statistics the product by supplier."};
        String[] sortMenu = {"1-Sort by name(asc).","2-Sort by value(des)"};
        do {
            choice = drawMenu(menu);
        } while (choice != 7); 
    }

    private static int drawMenu(String[] menu) {
        Scanner sc= new Scanner(System.in);
        for (String string : menu) {
            System.out.println(string);
        }
        System.out.print("Enter a choice: ");
        int choice = sc.nextInt();
        return choice;
    }
}
