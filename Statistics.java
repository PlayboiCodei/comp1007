import java.util.Scanner;
public class Statistics{
    private static Equipment[] equipmentArray;
    private static int totalEquipment;
    private static int totalOperationalEquipment;
    private static int unavailableItemsRequiringMaintenence;
    private static int operationalItemsRequiringMaintenence;
    private static int totalUnavailableEquipment;
    private static int requireingMaintenanceCount;
    private static double percentageRequiringMaintenance=0;
    private static double avrageMaintenanceCost;
    public static void statistics(){
        equipmentArray = Main.returnEquipmentArray();
        System.out.println("============================================");
        System.out.println("           Equipment Statistics");
        System.out.println("============================================");
        if (!Maintenance.returnmaintenanceCacluated()){
            Maintenance.calcualteMaintenence();
        }
        calculateSatistics();
        printSatistics();
        Main.pressEnterToContinue();
        Logger.log("Exits To Main Menu");
        return;

    }

public static void calculateSatistics(){
        getEquipmentItems();
        getTotalOperatiaonalEquipmentItems();
        getUnoporationalItemsRequiringMaintenenceCount();
        getTotalUnavailableEquipmentItems();
        getOperatiaonalItemsRequiringMaintenenceCount();
        getEquipmentRequiringmaintenanceCount();
        getPercentageRequiringMaintenance();
        getAvrageMaintenanceCost();
}

public static void printSatistics(){
    Logger.log("Satistics:");
    System.out.println("--------------------------------------------");
    System.out.println("Total Number Of Equipment Items: "+totalEquipment);
    Logger.log("Total Number Of Equipment Items: "+totalEquipment);

    System.out.println("Total Number Of Operational Items: "+ totalOperationalEquipment);
    Logger.log("Total Number Of Operational Items: "+ totalOperationalEquipment);

    System.out.println("Total Number Of Unavailable Items: "+ totalUnavailableEquipment);
    Logger.log("Total Number Of Unavailable Items: "+ totalUnavailableEquipment);
    
    System.out.println("Number Of Operational Items Requiring Maintenence: "+ operationalItemsRequiringMaintenence);
    Logger.log("Number Of Operational Items Requiring Maintenence: "+ operationalItemsRequiringMaintenence);

    System.out.println("Number Of Unavailable Items Requiring Maintenence: "+ unavailableItemsRequiringMaintenence);
    Logger.log("Number Of Unavailable Items Requiring Maintenence: "+ unavailableItemsRequiringMaintenence);

    System.out.println("Number Of Equipment Items Requiring Maintenance: "+requireingMaintenanceCount);
    Logger.log("Number Of Equipment Items Requiring Maintenance: "+requireingMaintenanceCount);

    System.out.println("Percentage of Equipment Requiring Maintenance: "+ String.format("%.2f", percentageRequiringMaintenance));
    Logger.log("Percentage of Equipment Requiring Maintenance: "+ String.format("%.2f", percentageRequiringMaintenance));

    System.out.println("Average Estimated Maintenance Cost Of All Equipment Items That Require Maintenance: "+ String.format("%.2f", avrageMaintenanceCost));
    Logger.log("Average Estimated Maintenance Cost Of All Equipment Items That Require Maintenance: "+ String.format("%.2f", avrageMaintenanceCost));

    System.out.println("--------------------------------------------");
}

    public static void getUnoporationalItemsRequiringMaintenenceCount(){
        int[] arrayIndex = Maintenance.returnMaintenanceArrayIndex();
        int count = 0;
        for (int i = 0; i < arrayIndex.length;i++){
            if (equipmentArray[arrayIndex[i]].returnStatus().equals("Unavailable")){
                count++;
            }
        }
        unavailableItemsRequiringMaintenence = count;
    }


    public static void getOperatiaonalItemsRequiringMaintenenceCount(){
        int[] arrayIndex = Maintenance.returnMaintenanceArrayIndex();
        int count = 0;
        for (int i = 0; i < arrayIndex.length;i++){
            if (equipmentArray[arrayIndex[i]].returnStatus().equals("Operational")){
                count++;
            }
        }
        operationalItemsRequiringMaintenence = count;
    }

    public static void getEquipmentItems(){
        totalEquipment = equipmentArray.length;
    }

    public static void getTotalOperatiaonalEquipmentItems(){
        int count = 0;
        for (int i = 0; i < totalEquipment;i++){
            if (equipmentArray[i].returnStatus().equals("Operational")){
                count++;
            }
        }
        totalOperationalEquipment = count;
    }

    public static void getTotalUnavailableEquipmentItems(){
        int count = 0;
        for (int i = 0; i < totalEquipment;i++){
            if (equipmentArray[i].returnStatus().equals("Unavailable")){
                count++;
            }
        }
        totalUnavailableEquipment = count;
    }

    public static void getEquipmentRequiringmaintenanceCount(){
        requireingMaintenanceCount = Maintenance.returnRequireMaintenanceCount();
    }

    public static void getPercentageRequiringMaintenance(){
        percentageRequiringMaintenance = ((double) requireingMaintenanceCount/totalEquipment)*100.0;
    }

    public static void getAvrageMaintenanceCost(){
        if (requireingMaintenanceCount == 0){
            avrageMaintenanceCost = 0;
            return;
        }
        avrageMaintenanceCost = getTotalMaintenanceCost()/requireingMaintenanceCount;
    }

    public static double getTotalMaintenanceCost(){
        double total = 0;
        int[] arrayIndex = Maintenance.returnMaintenanceArrayIndex();
        for (int i=0; i<arrayIndex.length;i++){
            total += equipmentArray[arrayIndex[i]].returnMaintenanceCost();
        }
        return total;
    }

}