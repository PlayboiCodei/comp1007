import java.util.Scanner;

public class Maintenance{
    private static Equipment[] equipmentArray;
    private static Date reportDate;
    private static int requireMaintenanceCount;
    private static int[] requireMaintenanceArrayIndex;
    private static int highPriorityMaintenanceCount;
    private static boolean maintenanceCacluated = false;

    public static void maintenance(){
        equipmentArray = Main.returnEquipmentArray();
        System.out.println("============================================");
        System.out.println("           Maintenance Report");
        System.out.println("============================================");
        if (!maintenanceCacluated || askForNewMaintenceReportDate()){
            calcualteMaintenence();
            printMaintenanceReport();
            Main.pressEnterToContinue();
            return;
        }else{
            printMaintenanceReport();
            Main.pressEnterToContinue();
            return;
        }
    }

    public static void calcualteMaintenence(){
        equipmentArray = Main.returnEquipmentArray();
        getReportDate();
        getItemsRequiringMaintenanceCount();
        getItemsRequiringMaintenanceIndex();
        getHighPriorityMaintenanceCount();
        maintenanceCacluated = true;
    }

    public static boolean askForNewMaintenceReportDate(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1. For New Report Date");
            System.out.println("Press Enter To Print Maintence Report");
            System.out.print(":");
            String userInput = sc.nextLine().strip();
            if (userInput.equals("1")){
                return true;
            }else if (userInput.equals("")){
                return false;
            }else{
                System.out.println("Invlaid Input");
                continue;
            }
        }
    }


    public static void printMaintenanceReport(){
        int index = 0;
        System.out.println("\nEquipment Requiring Maintenance\n");
        Logger.log("Maintenance Report: ");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < requireMaintenanceCount; i++){
            index = requireMaintenanceArrayIndex[i];
            System.out.println("Equipment ID: " + equipmentArray[index].returnEquipmentID());
            Logger.log("Equipment ID: " + equipmentArray[index].returnEquipmentID());
            System.out.println("Equipment Type: " + equipmentArray[index].returnEquipmentType());
            Logger.log("Equipment Type: " + equipmentArray[index].returnEquipmentType());
            System.out.println("Department: " + equipmentArray[index].returnDepartment());
            Logger.log("Department: " + equipmentArray[index].returnDepartment());
            System.out.println("Priority: " + equipmentArray[index].returnPriority());
            Logger.log("Priority: " + equipmentArray[index].returnPriority());
            System.out.println("Next Maintenance Date: " + equipmentArray[index].returnNextMaintenanceDateString());
            Logger.log("Next Maintenance Date: " + equipmentArray[index].returnNextMaintenanceDateString());
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total Number Of Equipment Items Requiring Maintenance: "+requireMaintenanceCount);
        Logger.log("Total Number Of Equipment Items Requiring Maintenance: "+requireMaintenanceCount);
        System.out.println("Total Number Of High-Priority Items Requiring Maintenance: "+ highPriorityMaintenanceCount);
        Logger.log("Total Number Of High-Priority Items Requiring Maintenance: "+ highPriorityMaintenanceCount);
    }

    public static boolean returnmaintenanceCacluated(){
        return maintenanceCacluated;
    }

    public static int[] returnMaintenanceArrayIndex(){
        return requireMaintenanceArrayIndex;
    }

    public static int returnRequireMaintenanceCount(){
        return requireMaintenanceCount;
    }

    public static void getHighPriorityMaintenanceCount(){
        int count = 0;
        for (int i = 0; i < requireMaintenanceCount; i++){
            String result = equipmentArray[requireMaintenanceArrayIndex[i]].returnPriority();
            if (result.equals("High")){
                count++;
            }
        }
        highPriorityMaintenanceCount = count;
    }

    public static void getItemsRequiringMaintenanceIndex(){
        int[] array = new int[requireMaintenanceCount];
        int index = 0;
        for (int i = 0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].returnNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                array[index++] = i;
            }
        }
        requireMaintenanceArrayIndex = array;
    }

    public static void getItemsRequiringMaintenanceCount(){
        int count = 0;
        for(int i=0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].returnNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                count++;
            }
        }
        requireMaintenanceCount = count;
    }

        public static void getReportDate(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("\nEnter Report Date \ndd/mm/yyyy\n: ");
            String userInput = sc.nextLine();
            try{
                reportDate = new Date(userInput);
                Logger.log("Report Date Added: "+reportDate.returnStringDate());
                return;
            }
            catch (Exception e){
                System.out.println("Error "+e);
                continue;
            }
        }
    }
}



