import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import accountant.Accountant;

public class App {
    public static void main(String[] args) throws Exception {
        int choice=0;
        boolean isValidInput=false;
        List <Accountant> list=new ArrayList<>();
        List <Accountant> highSalaryList= new ArrayList<>();
        do{
            do {
                try {
                    choice=getMenu();    
                    if(choice<1|choice>10) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Choose from 1 to 10 PLEASE.");
                }
            } while (isValidInput);
            switch(choice){
                case 1:
                    inputAccountant(list);
                    break;
                case 2:
                    showAll(list);
                    break;
                case 3:
                    filterSalary(list,highSalaryList);
                    break;
                case 4:
                    searchByID(list);
                    break;
                case 5:
                    searchByName(list);
                    break;
                case 6:
                    delete(list);
                    break;
                case 7:
                    update(list);
                    break;
            }
        }while(choice!=10);
    }

    private static void update(List<Accountant> list) {
        Accountant x =searchByID(list);
        Accountant temp = new Accountant();
        Scanner sc = new Scanner(System.in);
        String a ="";
        boolean input =false;
        do{
            try{
                System.out.println("1. Update id.");
                System.out.println("2. Update first name.");
                System.out.println("3. Update sure name.");
                System.out.println("4. Update birth day.");
                System.out.println("5. Update gender.");
                System.out.println("6. Update phone.");
                System.out.println("7. Update basic salary.");
                System.out.println("8. Update reward.");
                System.out.print("Enter attribute you want to update: ");
                a=sc.nextLine();
                if(!a.toLowerCase().matches("1-8")) throw new Exception();
            }catch(Exception e){
                System.out.println("Invalid. Enter again.");
            }
        }while(input);
    }

    private static void delete(List<Accountant> list) {
        Accountant x =searchByID(list);
        list.remove(x);
        System.out.println("Accountant deleted.");
    }

    private static void searchByName(List<Accountant> list) {
        System.out.print("Enter accountant's first name: ");
        Scanner sc =new Scanner(System.in);
        String name = sc.nextLine();
        boolean found = false;
        for (Accountant accountant : list) {
            if(accountant.getFirstName().matches(name)){
                System.out.println(accountant);
                found=true;
            }
            if(!found)
                System.out.println("Not found.");
        }
    }


    private static Accountant searchByID(List<Accountant> list) {
        System.out.print("Enter accountant's id: ");
        Scanner sc =new Scanner(System.in);
        String id = sc.nextLine();
        Accountant x= new Accountant();
        for (Accountant accountant : list) {
            if(accountant.getId().matches(id)){
                x=accountant;
                System.out.println(accountant);
                break;
            }
            System.out.println("Not found.");
        }
        return x;
    }

    private static void filterSalary(List<Accountant> list, List<Accountant> highSalaryList) {
        for (Accountant accountant : list) {
            if(accountant.earnMoney()>3000){
                if(!list.contains(accountant))
                    highSalaryList.add(accountant);
            }
        }
        System.out.println("Filter list of high salary accountant.");
        showAll(highSalaryList);
    }

    private static void showAll(List<Accountant> list) {
        System.out.println("\tList of accountant: ");
        for (Accountant i : list) {
            System.out.println(i);
        }
    }

    private static void inputAccountant(List<Accountant> list) {
        String temp="";
        Scanner sc = new Scanner(System.in);
        boolean condition=false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        do{
            Accountant x = new Accountant();
            System.out.print("Enter accountant's id: ");
            temp=sc.nextLine();
            x.setId(temp);
            System.out.print("Enter first name: ");
            temp=sc.nextLine();
            x.setFirstName(temp);
            System.out.print("Enter sure name: "); 
            temp=sc.nextLine();
            x.setSureName(temp);
            do{
                try{
                    System.out.print("Enter birthdate(format dd/mm/yyyy): ");
                    temp=sc.nextLine();
                    x.setBirthDate(dateFormat.parse(temp));
                    condition=false;
                }catch(ParseException e){
                    System.out.println("Enter again");
                    condition=true;
                }
            }while(condition);
            System.out.print("Enter gender(1. male/2. female):");
            temp=sc.nextLine();
            x.setGender(temp.matches("1"));
            do{
                try{
                    System.out.print("Enter phone: ");
                    temp=sc.nextLine();
                    if(!temp.matches("\\d{10}")) throw new Exception();
                    x.setPhone(temp);
                    condition=false;
                }catch(Exception e){
                    System.out.println("Enter again.");
                    condition=true;
                }
            }while(condition);
            do{
                try{
                System.out.print("Enter basic salary: ");
                temp=sc.nextLine();
                if(Double.parseDouble(temp)<1) throw new Exception();
                x.setBasicSalary(Double.parseDouble(temp));
                condition = false;
                }catch(Exception e){
                    System.out.println("Enter again.");
                    condition = true;
                }
            }while(condition);
            do{
                try{
                System.out.print("Enter reward: ");
                temp=sc.nextLine();
                if(Integer.parseInt(temp)<1) throw new Exception();
                x.setReward(Integer.parseInt(temp));
                condition = false;
                }catch(Exception e){
                    System.out.println("Enter again.");
                    condition = true;
                }
            }while(condition);
            list.add(x);
            System.out.println("Do you want to input another accountant informaton?(y to continue): ");
            temp=sc.nextLine();
        }while(temp.toLowerCase().matches("y"));
    }

    public static int getMenu(){
        System.out.println("1. Add accountant information.");
        System.out.println("2. Show all accountants.");
        System.out.println("3. Filter accountants by high salary");
        System.out.println("4. Find accountant by ID.");
        System.out.println("5. Find accountant by FIRST NAME.");
        System.out.println("6. Delete an accountant.");
        System.out.println("7. Update the information of an accountant.");
        System.out.println("8. Sort accountants by FIRST NAME (ASCENDING).");
        System.out.println("9. Sort by BASIC SALARY (DESC), then by BIRTH DAY (ASC).");
        System.out.println("10. Exit program.");
        System.out.print("Enter a choice:");
        
        Scanner sc = new Scanner(System.in);
        int choice=sc.nextInt();
        return choice; 
    }
}
