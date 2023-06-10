package Guitar;
import java.util.*;


public class Inventory{
   ArrayList<Guitar> list = new ArrayList<Guitar>();
   public void add(Guitar guitar){
      list.add(guitar);
   }
   public void showGuitar(int index){
      System.out.println("Guitar at index "+index+":");
      System.out.println("Serial number: "+list.get(0).getSerialNumber());
      System.out.println("Price: "+list.get(0).getPrice());
      System.out.println("Builder: "+list.get(0).getBuilder());
      System.out.println("Model: "+list.get(0).getModel());
      System.out.println("Back wood: "+list.get(0).getBackWood());
      System.out.println("Top wood: " +list.get(0).getTopWood());
   }
   public void find(String serialNumber){
      for(int i=0;i<list.size();i++){
         if(serialNumber.matches(list.get(i).getSerialNumber())){
            System.out.println("Found at "+i+" index.");
            return;
         }
      }
      System.out.println("Not found");
   }
}
