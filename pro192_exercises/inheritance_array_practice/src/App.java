import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import pupil.Pupil;
import teacher.Teacher;

public class App {
    public static void main(String[] args) throws Exception {
        int choice=0;
        Pupil[] pupilList = new Pupil[50]; int pupilIndex=-1;
        Teacher[] teacherList = new Teacher[50]; int teacherIndex=-1;
        do {
            try {
                choice =menu();
                if(choice<1 | choice>7) throw new Exception(); 
            } catch (Exception e) {
                System.out.println("Error. Enter again.");
            }
            switch(choice){
                case 1:
                    pupilIndex = inputPupil(pupilList,pupilIndex);
                    break;
                case 2:
                    sheetGoodPupil(pupilList,pupilIndex);
                    break;
                case 3:
                    sheetBadPupil(pupilList,pupilIndex);
                    break;
                case 4:
                    teacherIndex = inputTeacher(teacherList,teacherIndex);
                    break;
                case 5:
                    searchTeacher(teacherList,teacherIndex);
                    break;
                case 6:
                    sheetSalary(teacherList, teacherIndex);
                    break;
                case 7:
                    System.out.println("Program quitted.");
                    break;
            }
        } while (choice!=7);
    }


    /**
     * Draw menu
     * @return
     */
    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("1. Enter student data.");
        System.out.println("2. Show the sheet of GOOD pupils.");
        System.out.println("3. Show the sheet of BAD pupils.");
        System.out.println("4. Enter teacher data.");
        System.out.println("5. Search teacher by name.");
        System.out.println("6. Show sheet of teacher's salary.");
        System.out.println("7. Exit the program.");
        System.out.print("Enter a choice: ");
        choice =sc.nextInt();
        return choice;
    }
    /**
     * Get pupil's data from user
     * @param list
     * @param index
     */
    public static int inputPupil(Pupil[] list,int index){
        boolean condition =false;
        String temp="";
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do {
            Pupil x = new Pupil();
            System.out.print("Enter pupil's id: ");
            temp=sc.nextLine();
            x.setId(temp);
            System.out.print("Enter pupil's name: ");
            temp=sc.nextLine();
            x.setName(temp);
            do{                 
                try {                    
                    System.out.print("Enter birthdate(Format:dd/mm/yyyy): ");
                    temp=sc.nextLine();
                    //if(!temp.matches("1-31/1-12/\\d")) throw new Exception();
                    x.setBirthDay(format.parse(temp));
                    condition=false;
                    } catch (ParseException e) {
                        System.out.println("Error. Enter again.");
                        condition=true;
                }
            }while(condition);
            System.out.print("Enter gender(1: Male/ 2: Female): ");
            temp=sc.nextLine();
            x.setGender(temp.equals("1"));
            System.out.print("Enter pupil's level: ");
            temp=sc.nextLine();
            x.setLevel(temp);
            do{
                try{
                    System.out.print("Enter pupil's score: ");
                    temp=sc.nextLine();
                    x.setScored(Float.parseFloat(temp));
                    if(x.getScored()<1) throw new Exception();
                    condition=false;
                    }catch(Exception e){
                    System.out.println("Error. Enter again.");
                    condition=true;
                    }
                }while(condition);
            index++;
            list[index]=x;
            System.out.print("Input another pupil's data?(y/n): ");
            temp=sc.nextLine();
        } while (temp.toLowerCase().equals("y"));
        return index;
    }
    
    /**
     * Print out table of Good students.
     * @param list
     * @param index
     */
    public static void sheetGoodPupil(Pupil[] list,int index){
        System.out.println("\tList of Good pupil.");
        System.out.println("____________________________________________________________________________");
        System.out.printf("| |%-30s|%8s|%10s|%8s|%5s|%5s|\n","Name","ID","Birth date","Gender","Level","Score");
        System.out.println("____________________________________________________________________________");
        for (int i=0;i<=index;i++) {
            if(list[i].evaluate().matches("Good")){
                System.out.println(list[i]);
                System.out.println("____________________________________________________________________________");
            }  
        }
    }

    /**
     * Print out table of bad student
     * @param list
     * @param index
     */
    public static void sheetBadPupil(Pupil[] list,int index){
        System.out.println("\tList of Bad pupil.");
        System.out.println("____________________________________________________________________________");
        System.out.printf("| |%-30s|%8s|%10s|%8s|%5s|%5s|\n","Name","ID","Birth date","Gender","Level","Score");
        System.out.println("____________________________________________________________________________");
        for (int i=0;i<=index;i++) {
            if(list[i].evaluate().matches("Bad")){
                System.out.println(list[i]);
                System.out.println("____________________________________________________________________________");
            }  
        }
    }
    /**
     * Get teacher's data from user
     * @param list
     * @param index
     * @return
     */
    public static int inputTeacher(Teacher[] list,int index){
        boolean condition =false;
        String temp="";
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do {
            Teacher x = new Teacher();
            System.out.print("Enter teacher's id: ");
            temp=sc.nextLine();
            x.setId(temp);
            System.out.print("Enter teacher's name: ");
            temp=sc.nextLine();
            x.setName(temp);
            do{                 
                try {                    
                    System.out.print("Enter birthdate(Format:dd/mm/yyyy): ");
                    temp=sc.nextLine();
                    //if(!temp.matches("1-31/1-12/\\d")) throw new Exception();
                    x.setBirthDay(format.parse(temp));
                    condition=false;
                    } catch (ParseException e) {
                        System.out.println("Error. Enter again.");
                        condition=true;
                }
            }while(condition);
            System.out.print("Enter gender(1: Male/ 2: Female): ");
            temp=sc.nextLine();
            x.setGender(temp.equals("1"));
            System.out.print("Enter teacher's subject: ");
            temp=sc.nextLine();
            x.setSubject(temp);
            do{
                try{
                    System.out.print("Enter pupil's salary: ");
                    temp=sc.nextLine();
                    x.setSalary(Float.parseFloat(temp));
                    if(x.getSalary()<1) throw new Exception();
                    condition=false;
                    }catch(Exception e){
                    System.out.println("Error. Enter again.");
                    condition=true;
                    }
                }while(condition);
            index++;
            list[index]=x;
            System.out.print("Input another teacher's data?(y/n): ");
            temp=sc.nextLine();
        } while (temp.toLowerCase().equals("y"));
        return index;
    }
    /**
     * Search teacher by name
     * @param list
     * @param index
     */
    public static void searchTeacher(Teacher[] list,int index){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of the teacher: ");
        String name =sc.nextLine();
        System.out.println("Information about \""+name+"\": ");
        for(int i=0;i<=index;i++){
            if(list[i].getName().toLowerCase().contains(name.toLowerCase())){
            System.out.println(list[i]);
            }
        }
    }
    /**
     * Print out teacher's salary
     * @param list
     * @param index
     */
    public static void sheetSalary(Teacher[] list,int index){
        System.out.println("SALARY TABLE:");
        System.out.println("______________________________________________________________________________________");
        System.out.printf("| |%-30s|%8s|%10s|%8s|%10s|%10s|\n","Name","ID","Birthdate","Gender","Subject","Salary");
        System.out.println("______________________________________________________________________________________");
        for(int i=0;i<=index;i++){
            System.out.println(list[i]);
            System.out.println("______________________________________________________________________________________");
        }
    }
}
