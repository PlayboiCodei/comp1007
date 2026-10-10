import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Equipment[] equipmentArray = Equipment.loadEquipments();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("============================================");
            System.out.println("Hospital Equipment Maintenance Assistant");
            System.out.println("============================================\n");
            System.out.println("1. View Equipment Statistics");
            System.out.println("2. Search Equipment");
            System.out.println("3. Maintenance Report");
            System.out.println("4. Exit");
            System.out.println("Please select an option:");
            int userInput = sc.nextInt();
            if (userInput == 1){
                System.out.println("View Equipment Statistics");
            }else if (userInput == 2){
                System.out.println("Search Equipment");
            }else if (userInput == 3){
                System.out.println("Maintenance Report");
            }else if (userInput == 4){
                return;
            }else{
                System.out.println("Invlaid input");
                continue;
            }

        }

    }  
}