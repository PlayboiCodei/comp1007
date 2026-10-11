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

        if (!maintenanceCacluated){
            calcualteMaintenence();
            printMaintenanceReport();
            Main.pressEnterToContinue();
            return;
        }else if (askForNewMaintenceReportDate()){
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
        System.out.println("Equipment Requiring Maintenance");
        for (int i = 0; i < requireMaintenanceCount; i++){
            index = requireMaintenanceArrayIndex[i];
            System.out.println(equipmentArray[index].returnEquipmentID());
            System.out.println(equipmentArray[index].returnEquipmentType());
            System.out.println(equipmentArray[index].returnDepartment());
            System.out.println(equipmentArray[index].returnPriority());
            System.out.println(equipmentArray[index].returnNextMaintenanceDateString());
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total Number Of Equipment Items Requiring Maintenance: "+requireMaintenanceCount);
        System.out.println("Total Number Of High-Priority Items Requiring Maintenance: "+ highPriorityMaintenanceCount);
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
        int count = 0;
        for (int i = 0; i < equipmentArray.length; i++){
            String result = Date.compareDate(reportDate, equipmentArray[i].returnNextMaintenanceDate());
            if (result.equals("Same") || result.equals("After")){
                array[count++] = i;
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
            System.out.print("Enter Report Date \ndd/mm/yyyy\n: ");
            String userInput = sc.nextLine();
            try{
                reportDate = new Date(userInput);
                return;
            }
            catch (Exception e){
                System.out.println("Error "+e);
                continue;
            }
        }
    }
}



