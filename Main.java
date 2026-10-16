import java.util.Scanner;

public class Main{
    private static Equipment[] equipmentArray;
    public static void main(String[] args){
        equipmentArray = Equipment.loadEquipments();
        Scanner sc = new Scanner(System.in);
        Logger.log("System Starts");
        Logger.log("Loads Equipment Array");
        while (true){
            System.out.println("============================================");
            System.out.println("Hospital Equipment Maintenance Assistant");
            System.out.println("============================================\n");
            System.out.println("1. View Equipment Statistics");
            System.out.println("2. Search Equipment");
            System.out.println("3. Maintenance Report");
            System.out.println("4. Change Report Date");
            System.out.println("5. Exit");
            System.out.println("Please Select An Option");
            System.out.print(":");
            String userInput = sc.nextLine().strip();
            if (userInput == ""){
                continue;
            }else if (userInput.equals("1")){
                Logger.log("System Loads Into Satistics");
                Statistics.statistics();
            }else if (userInput.equals("2")){
                Logger.log("System Loads Into Search Equipment");
                Equipment.searchEquipment();
            }else if (userInput.equals("3")){
                Logger.log("System loads Into Maintenance");
                Maintenance.maintenance();
            }else if (userInput.equals("4")){
                Logger.log("User Changes Report Date");
                changeReportDate();
            }else if (userInput.equals("5")){
                Logger.log("System Exit's");
                return;
            }else{
                System.out.println("Invlaid input");
                pressEnterToContinue();
                continue;
            }

        }

    }  

//------------------------------------------------------------------------ OTHER

    public static Equipment[] returnEquipmentArray(){
        return equipmentArray;
    }

    public static void changeReportDate(){
        Maintenance.calcualteMaintenence();
    }

    public static boolean yesOrNo(String Question){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(Question);
            System.out.println("Y/N");
            System.out.print(":");
            String userChoice = sc.nextLine().strip().toUpperCase();
            if (userChoice == ""){
                continue;
            }else if (userChoice.equals("Y")||userChoice.equals("YES")){
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