import java.util.Scanner;
public class Statistics{
    private static Equipment[] equipmentArray;
    private static int totalEquipment;
    private static int operationalEquipment;
    private static int unavailableEquipment;
    private static int requireingMaintenanceCount;
    private static double percentageRequiringMaintenance;
    private static double avrageMaintenanceCost;
    public static void statistics(Equipment[] equipmentArrayinput){
        equipmentArray = equipmentArrayinput;
        System.out.println("============================================");
        System.out.println("           Equipment Statistics");
        System.out.println("============================================");
        Scanner sc = new Scanner(System.in);
        calculateSatistics();
        printSatistics();
        System.out.println("Press Enter TO Exit");
        sc.nextLine();
        return;

    }

public static void calculateSatistics(){
        getEquipmentItems();
        getOperatiaonalEquipmentItems();
        getUnavailableEquipmentItems();
        getEquipmentRequiringmaintenanceCount();
        getPercentageRequiringMaintenance();
        getAvrageMaintenanceCost();
}

public static void printSatistics(){
    System.out.println("--------------------------------------------");
    System.out.println("Total Number Of Equipment Items: "+totalEquipment);
    System.out.println("Number Of Operational Items: "+ operationalEquipment);
    System.out.println("Number Of Unavailable Items: "+ unavailableEquipment);
    System.out.println("Number Of Equipment Items Requiring Maintenance: "+requireingMaintenanceCount);
    System.out.println("Percentage of Equipment Requiring Maintenance: "+percentageRequiringMaintenance);
    System.out.println("Average Estimated Maintenance Cost Of All Equipment Items That Require Maintenance: "+ avrageMaintenanceCost);
    System.out.println("--------------------------------------------");
}

    public static void getEquipmentItems(){
        totalEquipment = equipmentArray.length;
    }
    public static void getOperatiaonalEquipmentItems(){
        int count = 0;
        for (int i = 0; i < totalEquipment;i++){
            if (equipmentArray[i].getStatus() == "Operational"){
                count++;
            }
        }
        operationalEquipment = count;
    }
    public static void getUnavailableEquipmentItems(){
        int count = 0;
        for (int i = 0; i < totalEquipment;i++){
            if (equipmentArray[i].getStatus() == "Unavailable"){
                count++;
            }
        }
        unavailableEquipment = count;
    }

    public static void getEquipmentRequiringmaintenanceCount(){
        requireingMaintenanceCount = Maintenance.returnRequireMaintenanceCount();
    }



    public static void getPercentageRequiringMaintenance(){
        percentageRequiringMaintenance = (requireingMaintenanceCount/totalEquipment)*100.0;
    }

    public static void getAvrageMaintenanceCost(){
        avrageMaintenanceCost = getTotalMaintenanceCost()/requireingMaintenanceCount;
    }

    public static double getTotalMaintenanceCost(){
        double total = 0;
        int[] arrayIndex = Maintenance.returnMaintenanceArrayIndex();
        for (int i=0; i<arrayIndex.length;i++){
            total += equipmentArray[arrayIndex[i]].getMaintenanceCost();
        }
        return total;
    }




}