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
            System.out.println("Please Select An Option:");
            int userInput = sc.nextInt();
            if (userInput == 1){
                Statistics.statistics(equipmentArray);
            }else if (userInput == 2){
                Equipment.searchEquipment(equipmentArray);
            }else if (userInput == 3){
                Maintenance.maintenance(equipmentArray);
            }else if (userInput == 4){
                return;
            }else if (userInput == 5){
                Equipment.printEquipmentArray(equipmentArray);
            }
            else{
                System.out.println("Invlaid input");
                continue;
            }

        }

    }  

//------------------------------------------------------------------------ OTHER
    public static boolean yesOrNo(String Question){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(Question);
            String userChoice = sc.nextLine().strip().toUpperCase();
            if (userChoice.equals("Y")||userChoice.equals("YES")){
                return true;
            }else if (userChoice.equals("N")||userChoice.equals("NO")){
                return false;
            }else{
                System.out.println("Invlaid Choice");
                continue;
            }

        }
    }

    public static void pressEnterToContinue(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Press Enter To Continue To Main Menu");
            sc.nextLine();
    }
}